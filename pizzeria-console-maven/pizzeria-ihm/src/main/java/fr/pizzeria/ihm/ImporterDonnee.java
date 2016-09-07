package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.service.Importation;

public class ImporterDonnee extends Action {

	private IhmHelper helper;

	public ImporterDonnee(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException {
		System.out.println("**** liste ****");
		Importation PizzaImporter = new Importation();
		PizzaImporter.finAllAndImport();

	}

}
