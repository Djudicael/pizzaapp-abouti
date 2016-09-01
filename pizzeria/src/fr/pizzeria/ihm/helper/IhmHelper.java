package fr.pizzeria.ihm.helper;

import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class IhmHelper {

	private Stockage<Integer, Client> stockageClient;
	private Stockage<Integer, Livreur> stockageLivreur;
	private Stockage<String, Pizza> stockagePizza;
	private Scanner sc;

	public IhmHelper(Stockage<Integer, Client> stockage, Stockage<String, Pizza> stockageP,
			Stockage<Integer, Livreur> stockageL, Scanner sc) {
		super();
		this.stockageClient = stockage;
		this.stockagePizza = stockageP;
		this.setStockageLivreur(stockageL);
		this.sc = sc;
	}

	public Stockage<String, Pizza> getStockagePizza() {
		return stockagePizza;
	}

	public void setStockagePizza(Stockage<String, Pizza> stockagePizza) {
		this.stockagePizza = stockagePizza;
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

	public Stockage<Integer, Livreur> getStockageLivreur() {
		return stockageLivreur;
	}

	public void setStockageLivreur(Stockage<Integer, Livreur> stockageLivreur) {
		this.stockageLivreur = stockageLivreur;
	}

}