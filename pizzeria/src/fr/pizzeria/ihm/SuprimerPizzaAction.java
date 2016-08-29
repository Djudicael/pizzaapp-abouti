package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class SuprimerPizzaAction extends Action {
	private Stockage<String, Pizza> stockage;
	private Scanner sc;

	public SuprimerPizzaAction(Stockage<String, Pizza> stockage, Scanner sc) {

		super("Suprimer pizza");
		this.stockage = stockage;
		this.sc = sc;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("voici la liste de pizza");
		ListerPizzaAction liste = new ListerPizzaAction(stockage);
		liste.execute();

		System.out.println("Veuillez choisir la pizza à supprimer");
		String code = sc.next();
		stockage.delete(code);
	}

}
