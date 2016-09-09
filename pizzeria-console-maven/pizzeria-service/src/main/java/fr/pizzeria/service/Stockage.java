package fr.pizzeria.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import fr.pizzeria.model.Client;

public interface Stockage<K, V> {
	// contrat
	Map<K, V> finAll() throws IOException, SQLException;

	/*
	 * void updatePizza(String codePizza, Pizza pizza) throws
	 * UpdatePizzaException;
	 * 
	 * void deletePizza(String codePizza) throws DeletePizzaException;
	 */

	public void save(K newcode, V newPizza) throws PizzeriaException, IOException, SQLException;

	public void update(K newcode, V pizza, K anciencode) throws IOException, SQLException;

	public void delete(K code) throws IOException, SQLException;

	void save(Client newPizza) throws PizzeriaException, IOException, SQLException;

}
