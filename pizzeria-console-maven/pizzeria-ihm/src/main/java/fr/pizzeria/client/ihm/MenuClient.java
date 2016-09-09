package fr.pizzeria.client.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.ihm.Action;
import fr.pizzeria.ihm.helper.IhmHelper;

public class MenuClient {
	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();

	private IhmHelper helper;

	public MenuClient(IhmHelper helper) {
		this.actions.put(1, new InscrireClientAction(helper, "S’inscrire"));
		this.actions.put(2, new ConnecterClientAction(helper, "Se connecter"));
		this.helper = helper;
	}

	public void start() throws SQLException {
		boolean result = false;
		do {
			afficher();
			result = choisir();
		} while (!result);
	}

	public void afficher() {
		// menu du programme
		System.out.println("***** Pizzeria Client *****");
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

	private boolean choisir() throws SQLException {
		System.out.println("Veuillez choisir une option");

		int choix = helper.getSc().nextInt();
		if (!actions.containsKey(choix)) {

			if (choix != CHOIX_SORTIR) {

				System.out.println("veuiller nettoyer vos lunettes");
			}

		} else {

			Action laBonneAction = actions.get(choix);
			try {
				laBonneAction.execute();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return choix == CHOIX_SORTIR;
	}

}
