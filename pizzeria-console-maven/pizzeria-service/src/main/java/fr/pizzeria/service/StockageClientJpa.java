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

import fr.pizzeria.model.Client;

public class StockageClientJpa implements Stockage<Integer, Client> {
	private EntityManagerFactory emf;

	public StockageClientJpa() {
		this.emf = Persistence.createEntityManagerFactory("pizzeria-ihm");
	}

	@Override
	public Map<Integer, Client> finAll() throws IOException, SQLException {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT p FROM Client p", Client.class);
		Map<Integer, Client> resulQuerry = query.getResultList().stream()
				.collect(Collectors.toMap(Client::getId, p -> p));

		em.close();
		return resulQuerry;
	}

	@Override
	public void save(Integer newcode, Client newPizza) throws PizzeriaException, IOException, SQLException {
		mutualiser(em -> {
			em.persist(newPizza);

		});

	}

	@Override
	public void save(Client newPizza) throws PizzeriaException, IOException, SQLException {
		mutualiser(em -> {
			em.persist(newPizza);

		});

	}

	@Override
	public void update(Integer newcode, Client client, Integer anciencode) throws IOException, SQLException {
		mutualiser(em -> {
			TypedQuery<Client> clients = em.createNamedQuery("client.findId", Client.class);
			clients.setParameter("toto", anciencode);
			Client client2 = clients.getResultList().get(0);
			client.setId(client2.getId());
			em.merge(client);

		});

	}

	@Override
	public void delete(Integer code) throws IOException, SQLException {
		mutualiser(em -> {
			Query client = em.createNamedQuery("client.delete");
			client.setParameter("toto", code);
			client.executeUpdate();

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
