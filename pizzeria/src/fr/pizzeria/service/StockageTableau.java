package fr.pizzeria.service;

import java.util.Arrays;

import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public Pizza[] listePizza = { new Pizza(0, "PEP", "Pépéroni", 12.50), new Pizza(1, "MAR", "Margherita", 14.00),
			new Pizza(2, "REI", "La Reine", 11.50), new Pizza(3, "FRO", "La 4 fromages", 12.00),
			new Pizza(4, "CAN", "La cannibale", 12.50), new Pizza(5, "SAV", "La savoyarde", 13.00),
			new Pizza(6, "ORI", "L'orientale", 13.50), new Pizza(7, "IND", "L'indienne", 14.00) };

	@Override
	public Pizza[] FindAllPizzas() {
		// TODO Auto-generated method stub
		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaException {
		if (newPizza.getCode().length() < 3 || newPizza.getCode().length() > 3) {
			// déclencher exception
			SavePizzaException e = new SavePizzaException("attention vous avez rentré un code non conventionel");

			throw e;
		}
		Pizza[] newPizzaTab = Arrays.copyOf(listePizza, listePizza.length + 1);
		newPizza.setId(listePizza.length);
		newPizzaTab[listePizza.length] = newPizza;
		listePizza = newPizzaTab;
	}

	public void modifPizza(Pizza pizza) {
		int id = pizza.getId();
		listePizza[id] = pizza;
	}

	public void suprimPizza(int id) {
		int newIndex;
		// on parcourt la liste
		Pizza listeProvisoire[] = new Pizza[listePizza.length - 1]; // tableau
																	// provisoire
																	// décrémenté
																	// de 1

		for (int i = 0; i < listePizza.length - 1; i++) {
			if (i >= id) {
				newIndex = i + 1;
			} // on modifie l'index pour passer la pizza à modifier
			else {
				newIndex = i;
			}
			// on copie les informations de l'ancienne liste sauf la pizza
			// supprimée
			listeProvisoire[i] = listePizza[newIndex];

		}
		listePizza = listeProvisoire;

	}

}
