package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ModifierPizzaAction extends Action {
	private Stockage<String, Pizza> stockage;
	private Scanner sc;

	public ModifierPizzaAction(Stockage<String, Pizza> stockage, Scanner sc) {
		super("Modifier une pizza");
		this.stockage = stockage;
		this.sc = sc;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("Menu 3. Mettre à jour une pizza");
		System.out.println("voici la liste de pizza");
		ListerPizzaAction liste = new ListerPizzaAction(stockage);
		liste.execute();
		System.out.println("Veuillez choisir la pizza à modifier");
		String ancienCode = sc.next();

		// modification
		System.out.println("entrez le code");
		String code3 = sc.next();
		System.out.println("entrez le nom de la pizza");
		String nom3 = sc.next();
		System.out.println("entrez le prix");
		double prix3 = sc.nextDouble();
		Pizza newModif = new Pizza(nom3, prix3);
		stockage.update(code3, newModif, ancienCode);
	}

}
