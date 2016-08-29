package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.Stockage;

public class ModifierClientAction extends Action {

	private Stockage<Integer, Client> stockage;
	private Scanner sc;

	public ModifierClientAction(Stockage<Integer, Client> stockage, Scanner scanner) {
		super("Modifier un client");
		this.stockage = stockage;
		this.sc = scanner;
	}

	@Override
	public void execute() {
		System.out.println("Menu 3. Mettre à jour un client");
		System.out.println("voici la liste de client");
		ListerPersonneAction liste = new ListerPersonneAction(stockage);
		liste.execute();

		System.out.println("Veuillez choisir le client à modifier");
		int ancienCode = sc.nextInt();

		// modification
		System.out.println("entrez le nouvel Id");
		int newID = sc.nextInt();
		System.out.println("veuillez saisir le nom sans espace");
		String newnom = sc.next();

		System.out.println("veuillez saisir le prenom sans espace");
		String newPrenom = sc.next();

		System.out.println("veuillez saisir le solde");
		double newSolde = sc.nextDouble();

		Client newModif = new Client(newID, newnom, newPrenom, newSolde);
		stockage.update(newID, newModif, ancienCode);

	}

}
