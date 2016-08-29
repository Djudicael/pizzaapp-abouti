package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public abstract class ModifierAction<K, T> extends Action {

	private Stockage<K, T> stockage;
	private Scanner sc;

	public ModifierAction(Stockage<K, T> stockage, Scanner scanner) {
		super("Modifier un");
		this.stockage = stockage;
		this.sc = scanner;
	}

	abstract Action getListerAction(Stockage<K, T> stockage);

	abstract K getSaisieCle();

	abstract K getSaisieNewCle();

	abstract T getSaisieNouvelEntite();

	@Override
	public void execute() {
		System.out.println("Menu 3. Mettre à jour un client");
		System.out.println("voici la liste de client");

		Action liste = getListerAction(stockage);
		liste.execute();

		K ancienCode = getSaisieCle();
		K newId = getSaisieCle();
		T newClient = getSaisieNouvelEntite();

		// modification
		stockage.update(newId, newClient, ancienCode);

	}
}
