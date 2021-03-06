package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ModifierPizzaAction extends Action {
	private Stockage stockage;
	private Scanner sc;

	public ModifierPizzaAction(Stockage stockage, Scanner sc) {
		super("Modifier une pizza");
		this.stockage = stockage;
		this.sc = sc;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("Menu 3. Mettre � jour une pizza");
		System.out.println("voici la liste de pizza");
		ListerPizzaAction liste = new ListerPizzaAction(stockage);
		liste.execute();
		System.out.println("Veuillez choisir la pizza � modifier");
		int id = sc.nextInt();

		// modification
		System.out.println("entrez le code");
		String code3 = sc.next();
		System.out.println("entrez le nom de la pizza");
		String nom3 = sc.next();
		System.out.println("entrez le prix");
		double prix3 = sc.nextDouble();
		Pizza newModif = new Pizza(id - 1, code3, nom3, prix3);
		stockage.modifPizza(newModif);
	}

}
