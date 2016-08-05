package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class AjouterPizzaAction extends Action {

	private Stockage stockage;
	private Scanner sc;

	public AjouterPizzaAction(Stockage stockage, Scanner sc) {
		super("Ajouter pizza");
		this.stockage = stockage;
		this.sc = sc;
	}

	@Override
	public void execute() {
		System.out.println("Menu 2. Ajouter une nouvelle pizza");
		System.out.println("veuiller saisir le code");
		String newcode = sc.next();

		System.out.println("veuillez saisir le nom sans espace");
		String newnom = sc.next();

		System.out.println("veuillez saisir le prix");
		double newprix = sc.nextDouble();
		// creation de la nouelle pizza
		Pizza newPizza = new Pizza(0, newcode, newnom, newprix);

		// sauvegrde de la pizza
		stockage.savePizza(newPizza);

		System.out.println("votre nouvelle pizza a été ajouté");

	}

}
