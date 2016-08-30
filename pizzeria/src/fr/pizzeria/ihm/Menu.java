package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();
	private Scanner scanner;
	private IhmHelper helper;

	public Menu(Stockage<String, Pizza> stockage, IhmHelper helper, Stockage<Integer, Livreur> stockageL) {

		this.actions.put(1, new ListerPizzaAction(stockage));
		this.actions.put(2, new AjouterPizzaAction(stockage, scanner));
		this.actions.put(3, new ModifierPizzaAction(stockage, scanner));
		this.actions.put(4, new SuprimerPizzaAction(stockage, scanner, " suprimer pizza"));
		this.actions.put(5, new ListerAction<>(helper.getStockageClient(), "liste des client"));
		this.actions.put(6, new AjouterClientAction(helper.getStockageClient(), scanner));
		this.actions.put(7, new ModifierClientAction(helper));
		this.actions.put(8, new SuprimerClientAction(helper.getStockageClient(), scanner, " suprimer client"));
		this.actions.put(9, new CrediterClient(helper.getStockageClient(), scanner));
		this.actions.put(10, new DebiterClient(helper.getStockageClient(), scanner));
		this.actions.put(11, new ListerAction<>(stockageL, " liste des livreurs"));
		this.actions.put(12, new AfficherStatCompte(helper.getStockageClient(), stockageL));
		this.actions.put(13, new EffectuerVirement(helper.getStockageClient(), scanner));
		this.scanner = scanner;
		this.helper = helper;

	}

	/*
	 * public Menu(IhmHelper ihmHelper) { this.actions.put(1, new
	 * ModifierClientAction(ihmHelper)); }
	 */

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
		actions.forEach((numero, valeur) -> {
			Action actionEnCours = valeur;
			String libellAction = actionEnCours.getLibelle();
			System.out.println(numero + " " + libellAction);

		});

		/*
		 * for (Integer numero : actions.keySet()) { Action actionEnCours =
		 * actions.get(numero);
		 * 
		 * System.out.println(numero + ". " + actionEnCours.getLibelle()); }
		 */
		System.out.println(CHOIX_SORTIR + " . Quitter");

	}

	private boolean choisir() {
		System.out.println("Veuillez choisir une option");

		int choix = helper.getSc().nextInt();
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
