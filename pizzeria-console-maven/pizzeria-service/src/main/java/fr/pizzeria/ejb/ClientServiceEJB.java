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
public class ClientServiceEJB {
	
@PersistenceContext(unitName="pizzeria-ihm") private EntityManager em;
	
	public Map<Integer, Client> finAll() throws IOException, SQLException {
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		Map<Integer, Client> resulQuerry = query.getResultList().stream()
				.collect(Collectors.toMap(Client::getId, c -> c));

		
		return resulQuerry;
	}
	


	public void save(Client newClient) throws PizzeriaException, IOException, SQLException {
	
			em.persist(newClient);

		
	}

	public void update(Integer numClient, Client client, Integer anciennumClient) throws IOException, SQLException {
		TypedQuery<Client> cli = em.createNamedQuery("client.findId", Client.class);
		cli.setParameter("toto", anciennumClient);
		Client client2 = cli.getResultList().get(0);
		client.setId(client2.getId());
		em.merge(client);
		
	}

	
	public void delete(Integer numClient) throws IOException, SQLException {
		Query cli = em.createNamedQuery("client.delete");
		cli.setParameter("toto", numClient);
		cli.executeUpdate();
		
	}

}
