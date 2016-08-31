package fr.pizzeria;

import java.util.Scanner;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClient;
import fr.pizzeria.service.StockageLivreurs;
import fr.pizzeria.service.StockagePizzaFichier;

public class App {

	public static void main(String[] args) {
		// Objectif 1 - Afficher le menu
		// Objectif 2 R�cup�rer la saisie

		Scanner sc = new Scanner(System.in);
		// Stockage<String, Pizza> stockageP = new StockageTableau();
		Stockage<String, Pizza> stockageF = new StockagePizzaFichier();
		Stockage<Integer, Client> stockagec = new StockageClient();
		Stockage<Integer, Livreur> stockageL = new StockageLivreurs();// choisi
																		// le
																		// stockage

		IhmHelper ihmHelper = new IhmHelper(stockagec, stockageF, stockageL, sc);
		// tableau
		Menu menuPrincipale = new Menu(ihmHelper);
		menuPrincipale.start();

	}

}
