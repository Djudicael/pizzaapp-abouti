package fr.pizzeria.service;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage<String, Pizza> {

	public Map<String, Pizza> listePizza = new TreeMap<>();

	public StockageTableau() {

		Pizza pepe = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);

		listePizza.put(pepe.getCode(), pepe);
		Pizza marg = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		listePizza.put(marg.getCode(), marg);
		Pizza reine = new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		listePizza.put(reine.getCode(), reine);
		Pizza fromage = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		listePizza.put(fromage.getCode(), fromage);
		Pizza canni = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.POISSON);
		listePizza.put(canni.getCode(), canni);
		Pizza savo = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		listePizza.put(savo.getCode(), savo);
		Pizza orien = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE);
		listePizza.put(orien.getCode(), orien);
		Pizza indie = new Pizza("IND", "L'indienne", 14.00, CategoriePizza.POISSON);
		listePizza.put(indie.getCode(), indie);

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
