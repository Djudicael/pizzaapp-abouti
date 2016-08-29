package fr.pizzeria.service;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage<String, Pizza> {

	public Map<String, Pizza> listePizza = new TreeMap<>();

	public StockageTableau() {
		Pizza pepe = new Pizza("Pépéroni", 12.50);

		listePizza.put("PEP", pepe);
		Pizza marg = new Pizza("Margherita", 14.00);
		listePizza.put("MAR", marg);
		Pizza reine = new Pizza("La Reine", 11.50);
		listePizza.put("REI", reine);
		Pizza fromage = new Pizza("La 4 fromages", 12.00);
		listePizza.put("FRO", fromage);
		Pizza canni = new Pizza("La cannibale", 12.50);
		listePizza.put("CAN", canni);
		Pizza savo = new Pizza("La savoyarde", 13.00);
		listePizza.put("SAV", savo);
		Pizza orien = new Pizza("L'orientale", 13.50);
		listePizza.put("ORI", orien);
		Pizza indie = new Pizza("L'indienne", 14.00);
		listePizza.put("IND", indie);

	}

	@Override
	public Map<String, Pizza> finAll() {

		/*
		 * for (Pizza p : listePizza) { System.out.println(p.getNom()); }
		 */

		return listePizza;
	}

	@Override
	public void save(String newcode, Pizza newPizza) throws SavePizzaException {

		listePizza.put(newcode, newPizza);
	}

	public void update(String newcode, Pizza pizza, String anciencode) {
		String code = anciencode;
		String pizzaAModifier = null;

		for (String pizzaEnCours : listePizza.keySet()) {
			if (pizzaEnCours == code) {
				pizzaAModifier = pizzaEnCours;
				// option 2
				/*
				 * pizzaAModifier.setCode(pizza.getCode());
				 * pizzaAModifier.setPrix(pizza.getPrix());
				 */
			}
		}
		// option 1
		listePizza.remove(anciencode);
		listePizza.put(newcode, pizza);

	}

	public void delete(String code) {
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
		/*
		 * String pizzaAModifier = null ;
		 * 
		 * for (String pizzaEnCours : listePizza.keySet()) { if (pizzaEnCours ==
		 * code) { pizzaAModifier = pizzaEnCours;
		 * 
		 * } }
		 */
		listePizza.remove(code);

	}

}
