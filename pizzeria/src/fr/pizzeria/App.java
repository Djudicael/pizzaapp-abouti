package fr.pizzeria;

import java.util.Scanner;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClient;
import fr.pizzeria.service.StockageTableau;

public class App {

	public static void main(String[] args) {
		// Objectif 1 - Afficher le menu
		// Objectif 2 Récupérer la saisie

		Scanner sc = new Scanner(System.in);
		Stockage<String, Pizza> stockage = new StockageTableau();
		Stockage<Integer, Client> stockagec = new StockageClient();
		Stockage<Integer, Livreur> stockageL = new StockageLivreurs();// choisi
																		// le
																		// stockage
		// tableau
		Menu menuPrincipale = new Menu(stockage, stockagec, stockageL, sc);
		menuPrincipale.start();
	}

}
