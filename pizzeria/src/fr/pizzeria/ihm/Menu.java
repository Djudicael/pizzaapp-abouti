package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();
	private Scanner scanner;

	public Menu(Stockage<String, Pizza> stockage, Stockage<Integer, Client> stockageC,
			Stockage<Integer, Livreur> stockageL, Scanner scanner) {

		this.actions.put(1, new ListerPizzaAction(stockage));
		this.actions.put(2, new AjouterPizzaAction(stockage, scanner));
		this.actions.put(3, new ModifierPizzaAction(stockage, scanner));
		this.actions.put(4, new SuprimerPizzaAction(stockage, scanner));
		this.actions.put(5, new ListerPersonneAction(stockagec));
		this.actions.put(6, new AjouterClientAction(stockagec, scanner));
		this.actions.put(7, new ModifierClientAction(stockagec, scanner));
		this.actions.put(8, new SuprimerClientAction(stockagec, scanner));
		this.actions.put(9, new CrediterClient(stockagec, scanner));
		this.actions.put(10, new DebiterClient(stockagec, scanner));
		this.actions.put(11, new ListerPersonneAction(stockageL));
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
		for (Integer numero : actions.keySet()) {
			Action actionEnCours = actions.get(numero);

			System.out.println(numero + ". " + actionEnCours.getLibelle());
		}
		System.out.println(CHOIX_SORTIR + " . Quitter");

	}

	private boolean choisir() {
		System.out.println("Veuillez choisir une option");

		int choix = scanner.nextInt();
		if (!actions.containsKey(choix)) {
			if (choix != CHOIX_SORTIR) {
				System.out.println("veuiller nettoyer vos lunettes");
			}

		} else {
			Action laBonneAction = actions.get(choix);
			laBonneAction.execute();
		}

		return choix == CHOIX_SORTIR;
	}

}
