package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
@Annotationaction(constructAction="simple")
public class ModifierPizzaAction extends Action {
	private IhmHelper helper;

	public ModifierPizzaAction(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws IOException {
		System.out.println("Menu 3. Mettre à jour une pizza");
		System.out.println("voici la liste de pizza");
		ListerAction<String, Pizza> liste = new ListerAction<>(helper.getStockagePizza(), "");
		liste.execute();
		System.out.println("Veuillez choisir la pizza à modifier");
		String ancienCode = helper.getSc().next();

		// modification
		System.out.println("entrez le code");
		String code3 = helper.getSc().next();
		System.out.println("entrez le nom de la pizza");
		String nom3 = helper.getSc().next();
		System.out.println("entrez le prix");
		double prix3 = helper.getSc().nextDouble();
		System.out.println("entrez la categorie");
		// String cate = helper.getSc().next();

		Arrays.asList(CategoriePizza.values()).forEach(cat -> {
			System.out.println(cat.ordinal() + " -> " + cat);
		});// cette vertion affiche le numero correspondant a l'enum

		/*
		 * Arrays.asList(CategoriePizza.values()).forEach(System.out::println);
		 */

		Integer cateOrdinal = helper.getSc().nextInt();
		Optional<CategoriePizza> optCatPizza = Arrays.asList(CategoriePizza.values()).stream()
				.filter(cat -> cat.ordinal() == cateOrdinal).findFirst();

		if (optCatPizza.isPresent()) {
			CategoriePizza catPizzaOrd = optCatPizza.get();
			Pizza newModif = new Pizza(code3, nom3, prix3, catPizzaOrd);
			helper.getStockagePizza().update(code3, newModif, ancienCode);
		} else {
			System.out.println("votre choix n'est pas dans la liste");
		}

		// String Cate = helper.getSc().next();
		// CategoriePizza catPizza = CategoriePizza.valueOf();

	}

}
