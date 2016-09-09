package fr.pizzeria.client;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import fr.pizzeria.client.ihm.MenuClient;
import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Importation;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientJpa;
import fr.pizzeria.service.StockageLivreurs;

public class AppClient {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		Scanner sc = new Scanner(System.in);
		Stockage<Integer, Client> stockagec = new StockageClientJpa();
		Stockage<Integer, Livreur> stockageL = new StockageLivreurs();// choisi
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(classeStockagePizza);
		Class<?> classePizza = Class.forName(classeStockagePizza);
		Stockage<String, Pizza> stockageProperties = (Stockage<String, Pizza>) classePizza.newInstance();
		Importation stockagePizDaa = new Importation();

		IhmHelper ihmHelper = new IhmHelper(stockagec, stockageProperties, stockageL, sc, stockagePizDaa);
		MenuClient menu = new MenuClient(ihmHelper);
		menu.start();

	}

}
