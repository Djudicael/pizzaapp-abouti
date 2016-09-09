package fr.pizzeria.ihm;

import java.io.IOException;
import java.sql.SQLException;
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
	public void execute() throws IOException, SQLException {
		System.out.println(" Mettre à jour");
		System.out.println("voici la liste ");

		Action liste = getListerAction(stockage);
		liste.execute();

		K ancienCode = getSaisieCle();
		K newId = getSaisieCle();
		T newClient = getSaisieNouvelEntite();

		// modification
		stockage.update(newId, newClient, ancienCode);

	}
}
