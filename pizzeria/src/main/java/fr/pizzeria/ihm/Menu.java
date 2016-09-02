package fr.pizzeria.ihm;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.reflections.Reflections;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Pizza;

public class Menu {

	private static final int CHOIX_SORTIR = 99;
	private Map<Integer, Action> actions = new HashMap<>();

	private IhmHelper helper;

	public Menu(IhmHelper helper) {

		Reflections reflections = new Reflections();

		this.actions.put(1, new ListerAction<String, Pizza>(helper.getStockagePizza(), "Lister pizzas"));
		this.actions.put(2, new AjouterPizzaAction(helper, "Ajouter une pizza"));
		this.actions.put(3, new ModifierPizzaAction(helper, "Modifier une pizza"));
		this.actions.put(4, new SuprimerPizzaAction(helper.getStockagePizza(), " suprimer pizza", helper));
		this.actions.put(5, new ListerAction<>(helper.getStockageClient(), "liste des client"));
		this.actions.put(6, new AjouterClientAction(helper.getStockageClient(), "Ajouter client", helper));
		this.actions.put(7, new ModifierClientAction(helper));
		this.actions.put(8, new SuprimerClientAction(helper.getStockageClient(), " suprimer client", helper));
		this.actions.put(9, new CrediterClient(helper.getStockageClient(), "crediter client"));
		this.actions.put(10, new DebiterClient(helper.getStockageClient(), "Debiter client"));
		this.actions.put(11, new ListerAction<>(helper.getStockageLivreur(), " liste des livreurs"));
		this.actions.put(12, new AfficherStatCompte(helper, "Afficher statistique compte"));
		this.actions.put(13, new EffectuerVirement(helper, "virement enrte client"));
		this.actions.put(14, new GrouperPizzaCategorie(helper, "Lister les pizzas groupées par catégorie"));
		this.actions.put(15, new AfficherPizzaTarifEleve(helper, "Afficher la pizza au tarif le plus élevé"));

		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Annotationaction.class);
		AtomicInteger youWillTry = new AtomicInteger(0);

		annotated.forEach(uneClasse -> {
			try {
				// Constructor<?> constructor =
				// uneClasse.getConstructor(parameterTypes);
				// Constructor<?> constructor = uneClasse.;
				Constructor<?>[] constructor = uneClasse.getConstructors();
				System.out.println("voici les constructeurs: " + constructor);
				// Constructor<?> constructor =
				// uneClasse.getConstructor(IhmHelper.class);
				// Object action = constructor.newInstance(helper);
				// this.actions.put(youWillTry.incrementAndGet(), (Action)
				// action);
			} catch (Exception e) {

			}
		});

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
		System.out.println("****Pizzeria Administration *****");
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
