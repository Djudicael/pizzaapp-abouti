package fr.pizzeria.ihm;

import java.util.Map;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ListerPizzaAction extends Action {

	private Stockage<String, Pizza> stockage;

	public ListerPizzaAction(Stockage<String, Pizza> stockage) {
		// this.setLibelle("lister les pizzas");
		super("Lister les pizzas");
		this.stockage = stockage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("**** liste pizza ****");
		Map<String, Pizza> pizzas = this.stockage.finAll();
		/*
		 * for (int i = 0; i < pizzas.size(); i++) { Pizza p = pizzas[i];
		 * System.out.println(p.getCode() + " " + p.getNom() + " " +
		 * p.getPrix()); }
		 */

		for (String p : pizzas.keySet()) {

			Pizza pizzaEnCours = pizzas.get(p);
			System.out.println(p + " " + pizzaEnCours.getNom() + " " + pizzaEnCours.getPrix());

		}
	}

}
