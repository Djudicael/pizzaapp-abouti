package fr.pizzeria.service;

import java.io.IOException;
import java.util.Map;

public interface Stockage<K, V> {
	// contrat
	Map<K, V> finAll() throws IOException;

	/*
	 * void updatePizza(String codePizza, Pizza pizza) throws
	 * UpdatePizzaException;
	 * 
	 * void deletePizza(String codePizza) throws DeletePizzaException;
	 */

	public void save(K newcode, V newPizza) throws PizzeriaException, IOException;

	public void update(K newcode, V pizza, K anciencode) throws IOException;

	public void delete(K code) throws IOException;

}
