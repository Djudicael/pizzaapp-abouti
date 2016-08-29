package fr.pizzeria.service;

import java.util.Map;

public interface Stockage<K, V> {
	// contrat
	Map<K, V> finAll();

	/*
	 * void updatePizza(String codePizza, Pizza pizza) throws
	 * UpdatePizzaException;
	 * 
	 * void deletePizza(String codePizza) throws DeletePizzaException;
	 */

	public void save(K newcode, V newPizza) throws PizzeriaException;

	public void update(K newcode, V pizza, K anciencode);

	public void delete(K code);

}
