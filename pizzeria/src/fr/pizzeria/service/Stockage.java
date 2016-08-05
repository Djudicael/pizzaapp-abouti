package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public interface Stockage {
	// contrat
	Pizza[] FindAllPizzas();

	/*
	 * void updatePizza(String codePizza, Pizza pizza) throws
	 * UpdatePizzaException;
	 * 
	 * void deletePizza(String codePizza) throws DeletePizzaException;
	 */

	void savePizza(Pizza newPizza) throws SavePizzaException;

	void modifPizza(Pizza pizza);

	public void suprimPizza(int id);

}
