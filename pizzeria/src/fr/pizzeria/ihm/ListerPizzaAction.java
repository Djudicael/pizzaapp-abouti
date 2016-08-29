package fr.pizzeria.ihm;

import java.util.List;
import java.util.Map;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ListerPizzaAction extends Action {

	private Stockage stockage;

	public ListerPizzaAction(Stockage stockage) {
		// this.setLibelle("lister les pizzas");
		super("Lister les pizzas");
		this.stockage = stockage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("**** liste pizza ****");
		Map< String, Pizza> pizzas = this.stockage.FindAllPizzas();
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
