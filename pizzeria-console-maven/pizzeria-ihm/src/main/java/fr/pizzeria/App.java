package fr.pizzeria;

import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.commons.lang3.time.DateFormatUtils;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientFichier;
import fr.pizzeria.service.StockageLivreurs;

public class App {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// Objectif 1 - Afficher le menu
		// Objectif 2 R�cup�rer la saisie

		Scanner sc = new Scanner(System.in);
		// lire le fichier de prorpiert� se trouvant de ressource
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(classeStockagePizza);
		Class<?> classePizza = Class.forName(classeStockagePizza);
		Stockage<String, Pizza> stockageProperties = (Stockage<String, Pizza>) classePizza.newInstance();
		// Stockage<String, Pizza> stockageP = new StockageTableau();
		// Stockage<String, Pizza> stockageF = new StockagePizzaFichier();
		// Stockage<Integer, Client> stockagec = new StockageClient();
		Stockage<Integer, Client> stockagec = new StockageClientFichier();
		Stockage<Integer, Livreur> stockageL = new StockageLivreurs();// choisi
																		// le
																		// stockage

		Calendar date;
		date = Calendar.getInstance();

		System.out.println(DateFormatUtils.format(date, "dd/MM - HH:MM"));

		IhmHelper ihmHelper = new IhmHelper(stockageC, stockageProperties, stockageL, sc);
		// tableau
		Menu menuPrincipale = new Menu(ihmHelper);
		menuPrincipale.start();

	}

}
