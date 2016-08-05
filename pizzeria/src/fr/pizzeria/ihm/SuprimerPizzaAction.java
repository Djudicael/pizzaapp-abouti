package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class SuprimerPizzaAction extends Action {
	private Stockage stockage;
	private Scanner sc;

	public SuprimerPizzaAction(Stockage stockage, Scanner sc) {

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
		int id = sc.nextInt();
		stockage.suprimPizza(id);
	}

}
