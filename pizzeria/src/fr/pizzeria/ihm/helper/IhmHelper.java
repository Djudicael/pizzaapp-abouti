package fr.pizzeria.ihm.helper;

import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class IhmHelper {

	private Stockage<Integer, Client> stockageClient;
	private Stockage<String, Pizza> stockage;
	private Scanner sc;

	public IhmHelper(Stockage<Integer, Client> stockage, Scanner sc) {
		super();
		this.stockageClient = stockage;
		this.sc = sc;
	}

	public Client buildClientBySaisie() {
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
		return newModif;
	}

	public Stockage<Integer, Client> getStockageClient() {
		return stockageClient;
	}

	public Scanner getSc() {
		return sc;
	}

}
