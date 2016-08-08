package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public List<Pizza> listePizza = new ArrayList<>();

	public StockageTableau() {
		Pizza pepe = new Pizza(0, "PEP", "Pépéroni", 12.50);
		listePizza.add(pepe);
		Pizza marg = new Pizza(1, "MAR", "Margherita", 14.00);
		listePizza.add(marg);
		Pizza reine = new Pizza(2, "REI", "La Reine", 11.50);
		listePizza.add(reine);
		Pizza fromage = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		listePizza.add(fromage);
		Pizza canni = new Pizza(4, "CAN", "La cannibale", 12.50);
		listePizza.add(canni);
		Pizza savo = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listePizza.add(savo);
		Pizza orien = new Pizza(6, "ORI", "L'orientale", 13.50);
		listePizza.add(orien);
		Pizza indie = new Pizza(7, "IND", "L'indienne", 14.00);
		listePizza.add(indie);

	}

	@Override
	public List<Pizza> FindAllPizzas() {

		/*
		 * for (Pizza p : listePizza) { System.out.println(p.getNom()); }
		 */

		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza) throws SavePizzaException {

		listePizza.add(newPizza);
	}

	public void modifPizza(Pizza pizza) {
		int id = pizza.getId();
		Pizza pizzaAModifier = null;
		for (Pizza pizzaEnCours : listePizza) {
			if (pizzaEnCours.getId() == id) {
				pizzaAModifier = pizzaEnCours;
				// option 2
				/*
				 * pizzaAModifier.setCode(pizza.getCode());
				 * pizzaAModifier.setPrix(pizza.getPrix());
				 */
			}
		}
		// option 1
		listePizza.remove(pizzaAModifier);
		listePizza.add(pizza);

	}

	public void suprimPizza(int id) {
		/*
		 * int newIndex; // on parcourt la liste Pizza listeProvisoire[] = new
		 * Pizza[listePizza.size() - 1]; // tableau // provisoire // décrémenté
		 * // de 1
		 * 
		 * for (int i = 0; i < listePizza.length - 1; i++) { if (i >= id) {
		 * newIndex = i + 1; } // on modifie l'index pour passer la pizza à
		 * modifier else { newIndex = i; } // on copie les informations de
		 * l'ancienne liste sauf la pizza // supprimée listeProvisoire[i] =
		 * listePizza[newIndex];
		 * 
		 * } listePizza = listeProvisoire;
		 */
		Pizza pizzaAModifier = null;

		for (Pizza pizzaEnCours : listePizza) {
			if (pizzaEnCours.getId() == id) {
				pizzaAModifier = pizzaEnCours;

			}
		}
		listePizza.remove(pizzaAModifier);

	}

}
