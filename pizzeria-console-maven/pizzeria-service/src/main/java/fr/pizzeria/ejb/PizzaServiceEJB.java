package fr.pizzeria.ejb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.Stockage;

@Stateless
public class PizzaServiceEJB /*implements Stockage<String, Pizza>*/{
	
	@PersistenceContext(unitName="pizzeria-ihm") private EntityManager em;

	
	public Map<String, Pizza> finAll() throws IOException, SQLException {
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		Map<String, Pizza> resulQuerry = query.getResultList().stream()
				.collect(Collectors.toMap(Pizza::getCode, p -> p));

		
		return resulQuerry;
	}


	public void save(String newcode, Pizza newPizza) throws PizzeriaException, IOException, SQLException {
	
			em.persist(newPizza);

		
	}

	public void update(String newcode, Pizza pizza, String anciencode) throws IOException, SQLException {
		TypedQuery<Pizza> piz = em.createNamedQuery("pizza.findId", Pizza.class);
		piz.setParameter("toto", anciencode);
		Pizza pizza2 = piz.getResultList().get(0);
		pizza.setId(pizza2.getId());
		em.merge(pizza);
		
	}

	
	public void delete(String code) throws IOException, SQLException {
		Query piz = em.createNamedQuery("pizza.delete");
		piz.setParameter("toto", code);
		piz.executeUpdate();
		
	}


}
