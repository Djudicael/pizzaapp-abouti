package fr.pizzeria.service;

import java.util.List;
import java.util.Map;

import fr.pizzeria.model.Pizza;

public interface Stockage {
	// contrat
	Map< String, Pizza> FindAllPizzas();

	/*
	 * void updatePizza(String codePizza, Pizza pizza) throws
	 * UpdatePizzaException;
	 * 
	 * void deletePizza(String codePizza) throws DeletePizzaException;
	 */

	public void savePizza(String newcode ,Pizza newPizza) throws SavePizzaException;

	public void modifPizza(String newcode, Pizza pizza, String anciencode);

	public void suprimPizza(String code);

}
