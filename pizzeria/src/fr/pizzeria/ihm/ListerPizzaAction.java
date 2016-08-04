package fr.pizzeria.ihm;

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
		Pizza[] pizzas = this.stockage.FindAllPizzas();
		for (int i = 0; i < pizzas.length; i++) {
			Pizza p = pizzas[i];
			System.out.println(p.getCode() + " " + p.getNom());
		}
	}

}
