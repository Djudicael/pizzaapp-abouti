package fr.pizzeria;

import java.util.Scanner;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageTableau;

public class App {

	public static void main(String[] args) {
		// Objectif 1 - Afficher le menu
		// Objectif 2 Récupérer la saisie

		Scanner sc = new Scanner(System.in);
		Stockage stockage = new StockageTableau(); // choisi le stockage tableau
		Menu menuPrincipale = new Menu(stockage, sc);
		menuPrincipale.start();
	}

}
