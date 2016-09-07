package fr.pizzeria.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;

@Annotationaction(constructAction = "simple")
public class AjouterPizzaAction extends Action {

	private IhmHelper helper;

	public AjouterPizzaAction(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException, SQLException {
		System.out.println("Menu 2. Ajouter une nouvelle pizza");
		System.out.println("veuiller saisir le code");
		String newcode = helper.getSc().next();

		System.out.println("veuillez saisir le nom sans espace");
		String newnom = helper.getSc().next();

		System.out.println("veuillez saisir le prix");
		double newprix = helper.getSc().nextDouble();

		/*
		 * partie categorie
		 */
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
			Pizza newPizza = new Pizza(newcode, newnom, newprix, catPizzaOrd);
			try {
				helper.getStockagePizza().save(newcode, newPizza);
			} catch (PizzeriaException e) {
				// TODO Auto-generated catch block
				// System.out.println("attention vous avez rentré un code de
				// plus de
				// 3 lettres");
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}

			System.out.println("votre nouvelle pizza a été ajouté");

		}

		// String Cate = helper.getSc().next();
		// CategoriePizza catPizza = CategoriePizza.valueOf();

		// creation de la nouelle pizza

		// sauvegrde de la pizza

	}

}
