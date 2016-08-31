package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.service.Stockage;

public abstract class SuprimerAction<K, T> extends Action {

	private Stockage<K, T> stockage;
	protected IhmHelper helper;

	public SuprimerAction(Stockage<K, T> stockage, String libelle, IhmHelper helper) {
		super(libelle);
		this.stockage = stockage;
		this.helper = helper;
	}

	abstract K getSaisieCle();

	@Override
	public void execute() throws IOException {
		// TODO Auto-generated method stub

		/*
		 * ListerAction<K, T> liste = new ListerAction<K, T>(stockage, "");
		 * liste.execute();
		 */

		System.out.println("Veuillez choisir l'élément à supprimer");
		K code = getSaisieCle();
		stockage.delete(code);
	}

}
