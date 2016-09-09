package fr.pizzeria.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class StockagePizzaJpa implements Stockage<String, Pizza> {

	private EntityManagerFactory emf;

	public StockagePizzaJpa() {
		super();
		this.emf = Persistence.createEntityManagerFactory("pizzeria-ihm");
	}

	@Override
	public Map<String, Pizza> finAll() throws IOException, SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		Map<String, Pizza> resulQuerry = query.getResultList().stream()
				.collect(Collectors.toMap(Pizza::getCode, p -> p));

		em.close();
		return resulQuerry;

	}

	@Override
	public void save(String newcode, Pizza newPizza) throws PizzeriaException, IOException, SQLException {
		/*
		 * EntityManager em = emf.createEntityManager();
		 * 
		 * EntityTransaction et = em.getTransaction(); et.begin(); try {
		 * em.persist(newPizza);
		 * 
		 * et.commit();
		 * 
		 * } catch (PersistenceException e) { et.rollback(); }
		 * 
		 * em.close();
		 */

		mutualiser(em -> {
			em.persist(newPizza);

		});

	}

	@Override
	public void update(String newcode, Pizza pizza, String anciencode) throws IOException, SQLException {
		/*
		 * EntityManager em = emf.createEntityManager();
		 * 
		 * TypedQuery<Pizza> piz = em.createNamedQuery("pizza.findId",
		 * Pizza.class); piz.setParameter("toto", anciencode); Pizza pizza2 =
		 * piz.getResultList().get(0);
		 * 
		 * EntityTransaction et = em.getTransaction(); et.begin(); try { if
		 * (pizza2 != null) { pizza.setId(pizza2.getId()); em.merge(pizza); }
		 * 
		 * et.commit();
		 * 
		 * } catch (PersistenceException e) { et.rollback(); }
		 * 
		 * em.close();
		 */

		mutualiser(em -> {
			TypedQuery<Pizza> piz = em.createNamedQuery("pizza.findId", Pizza.class);
			piz.setParameter("toto", anciencode);
			Pizza pizza2 = piz.getResultList().get(0);
			pizza.setId(pizza2.getId());

		});

	}

	@Override
	public void delete(String code) throws IOException, SQLException {
		/*
		 * EntityManager em = emf.createEntityManager();
		 * 
		 * EntityTransaction et = em.getTransaction(); et.begin(); try { Query
		 * piz = em.createNamedQuery("pizza.delete"); piz.setParameter("toto",
		 * code); piz.executeUpdate(); et.commit();
		 * 
		 * } catch (PersistenceException e) { et.rollback(); }
		 * 
		 * em.close();
		 */

		mutualiser(em -> {
			Query piz = em.createNamedQuery("pizza.delete");
			piz.setParameter("toto", code);
			piz.executeUpdate();

		});

	}

	public EntityManager createEm() {
		return emf.createEntityManager();
	}

	public void mutualiser(Consumer<EntityManager> code) {
		EntityManager em = createEm();
		em.getTransaction().begin();
		try {
			code.accept(em);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
