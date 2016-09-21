package fr.pizzeria.ejb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.StatutCommande;
import fr.pizzeria.service.PizzeriaException;

@Stateless
public class CommandeServiceEJB {
	@PersistenceContext(unitName="pizzeria-ihm") private EntityManager em;
	
	public Map<Integer, Commande> finAll() throws IOException, SQLException {
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c join fetch c.pizza", Commande.class);
		Map<Integer, Commande> resulQuerry = new HashSet<>(query.getResultList()).stream()
				.collect(Collectors.toMap(Commande::getNumeroCommande, c -> c));

		
		return resulQuerry;
	}
	@Schedule(second="0", minute="*", hour="*")
	public void insererCommande() {
		Random randomGenerator = new Random();
		Integer randomInt = randomGenerator.nextInt(100);
		Client client = em.getReference(Client.class, 1);
		Livreur livreur = em.getReference(Livreur.class, 2);
		Livreur momo = new Livreur();
		 Set<Pizza> pizza = new HashSet<>();
		 /*pizza.add(new Pizza("POI", "poisonnerie", 15.2, CategoriePizza.valueOf("POISSON")));*/
		 TypedQuery<Pizza> createQuery = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		 pizza.addAll(createQuery.getResultList());
		
		
		Calendar date = Calendar.getInstance();
		Commande newComande = new Commande(randomInt,date, client, livreur, pizza, StatutCommande.valueOf("EN_COURS"));
		em.persist(newComande);
	}


	public void save(Integer newNumCommande, Commande newCommande) throws PizzeriaException, IOException, SQLException {
	
			em.persist(newCommande);

		
	}

	public void update(Integer newNumCommande, Commande commande, Integer ancienNumecommande) throws IOException, SQLException {
		TypedQuery<Commande> com = em.createNamedQuery("commande.findId", Commande.class);
		com.setParameter("toto", ancienNumecommande);
		Commande commande2 = com.getResultList().get(0);
		commande.setId(commande2.getId());
		em.merge(commande);
		
	}

	
	public void delete(Integer numeroCommande) throws IOException, SQLException {
		Query com = em.createNamedQuery("commande.delete");
		com.setParameter("toto", numeroCommande);
		com.executeUpdate();
		
	}

}
