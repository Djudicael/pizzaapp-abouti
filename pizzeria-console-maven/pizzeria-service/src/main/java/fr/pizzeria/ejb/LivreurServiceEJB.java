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
import fr.pizzeria.model.Livreur;
import fr.pizzeria.service.PizzeriaException;
@Stateless
public class LivreurServiceEJB {
	@PersistenceContext(unitName="pizzeria-ihm") private EntityManager em;
	
	
	public Map<Integer, Livreur> finAll() throws IOException, SQLException {
		TypedQuery<Livreur> query = em.createQuery("SELECT c FROM Livreur c", Livreur.class);
		Map<Integer, Livreur> resulQuerry = query.getResultList().stream()
				.collect(Collectors.toMap(Livreur::getId, c -> c));

		
		return resulQuerry;
	}
	


	public void save(Livreur newClient) throws PizzeriaException, IOException, SQLException {
	
			em.persist(newClient);

		
	}

	public void update(Integer numClient, Livreur client, Integer anciennumClient) throws IOException, SQLException {
		TypedQuery<Livreur> cli = em.createNamedQuery("livreur.findId", Livreur.class);
		cli.setParameter("toto", anciennumClient);
		Livreur client2 = cli.getResultList().get(0);
		client.setId(client2.getId());
		em.merge(client);
		
	}

	
	public void delete(Integer numClient) throws IOException, SQLException {
		Query cli = em.createNamedQuery("livreur.delete");
		cli.setParameter("toto", numClient);
		cli.executeUpdate();
		
	}

}
