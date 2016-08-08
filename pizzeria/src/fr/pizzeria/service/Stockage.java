package fr.pizzeria.service;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface Stockage {
	// contrat
	List<Pizza> FindAllPizzas();

	/*
	 * void updatePizza(String codePizza, Pizza pizza) throws
	 * UpdatePizzaException;
	 * 
	 * void deletePizza(String codePizza) throws DeletePizzaException;
	 */

	public void savePizza(Pizza newPizza) throws SavePizzaException;

	public void modifPizza(Pizza pizza);

	public void suprimPizza(int id);

}
