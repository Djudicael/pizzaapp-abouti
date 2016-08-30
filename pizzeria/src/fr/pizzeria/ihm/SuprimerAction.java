package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public abstract class SuprimerAction<K, T> extends Action {

	private Stockage<K, T> stockage;
	protected Scanner sc;

	public SuprimerAction(Stockage<K, T> stockage, Scanner scanner, String libelle) {
		super(libelle);
		this.stockage = stockage;
		this.sc = scanner;
	}

	abstract K getSaisieCle();

	@Override
	public void execute() {
		// TODO Auto-generated method stub

		ListerAction<K, T> liste = new ListerAction<K, T>(stockage, "");
		liste.execute();

		System.out.println("Veuillez choisir l'élément à supprimer");
		K code = getSaisieCle();
		stockage.delete(code);
	}

}
