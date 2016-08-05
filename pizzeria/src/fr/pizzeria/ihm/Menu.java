package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Action[] actions;
	private Scanner scanner;

	public Menu(Stockage stockage, Scanner scanner) {
		actions = new Action[] { new ListerPizzaAction(stockage), new AjouterPizzaAction(stockage, scanner),
				new ModifierPizzaAction(stockage, scanner), new SuprimerPizzaAction(stockage, scanner) };
		this.scanner = scanner;

	}

	public void start() {
		boolean result = false;
		do {
			afficher();
			result = choisir();
		} while (!result);
	}

	public void afficher() {
		// menu du programme
		System.out.println("***** Pizzeria Administration *****");
		for (int i = 0; i < actions.length; i++) {
			Action actionEnCours = actions[i];
			String libbelleAction = actionEnCours.getLibelle();
			int indexMenu = i + 1;
			System.out.println(indexMenu + ". " + libbelleAction);
		}
		System.out.println(CHOIX_SORTIR + " . Quitter");

	}

	private boolean choisir() {
		System.out.println("Veuillez choisir une option");

		int choix = scanner.nextInt();
		if (choix <= 0 || choix > actions.length) {
			if (choix != CHOIX_SORTIR) {
				System.out.println("veuiller nettoyer vos lunettes");
			}

		} else {
			Action laBonneAction = actions[choix - 1];
			laBonneAction.execute();
		}

		return choix == CHOIX_SORTIR;
	}

}
