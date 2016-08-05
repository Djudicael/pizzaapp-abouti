package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public interface Stockage {
	// contrat
	Pizza[] FindAllPizzas();

	void savePizza(Pizza newPizza);

	void modifPizza(Pizza pizza);

	public void suprimPizza(int id);

}
