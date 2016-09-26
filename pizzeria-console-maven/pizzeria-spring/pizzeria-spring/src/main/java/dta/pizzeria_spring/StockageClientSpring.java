package dta.pizzeria_spring;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.Stockage;

@Repository
public class StockageClientSpring implements Stockage<Integer, Client> {
	@PersistenceContext(unitName="pizzeria-ihm") private EntityManager em;
	@Override
	public Map<Integer, Client> finAll() throws IOException, SQLException {
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		Map<Integer, Client> resulQuerry = query.getResultList().stream()
				.collect(Collectors.toMap(Client::getId, c -> c));

		
		return resulQuerry;
	}

	@Override
	public void save(Integer newcode, Client newPizza) throws PizzeriaException, IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integer newcode, Client pizza, Integer anciencode) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer code) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Client newPizza) throws PizzeriaException, IOException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
