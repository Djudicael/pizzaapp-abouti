package fr.pizzeria;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import org.apache.commons.lang3.time.DateFormatUtils;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Importation;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientFichier;
import fr.pizzeria.service.StockageLivreurs;

public class App {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// Objectif 1 - Afficher le menu
		// Objectif 2 Récupérer la saisie
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		Scanner sc = new Scanner(System.in);
		// lire le fichier de prorpierté se trouvant de ressource
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("stockage.pizza");
		System.out.println(classeStockagePizza);
		Class<?> classePizza = Class.forName(classeStockagePizza);
		Stockage<String, Pizza> stockageProperties = (Stockage<String, Pizza>) classePizza.newInstance();
		// Stockage<String, Pizza> stockageP = new StockageTableau();
		// Stockage<String, Pizza> stockageF = new StockagePizzaFichier();
		// Stockage<Integer, Client> stockagec = new StockageClient();
		// Stockage<String, Pizza> stockageddb = new StockagePizzaJDBC();
		Importation stockagePizDaa = new Importation();

		Stockage<Integer, Client> stockagec = new StockageClientFichier();
		Stockage<Integer, Livreur> stockageL = new StockageLivreurs();// choisi
																		// le
																		// stockage

		Calendar date;
		date = Calendar.getInstance();

		System.out.println(DateFormatUtils.format(date, "dd/MM - HH:MM"));

		IhmHelper ihmHelper = new IhmHelper(stockagec, stockageProperties, stockageL, sc, stockagePizDaa);
		// tableau
		Menu menuPrincipale = new Menu(ihmHelper);
		menuPrincipale.start();

	}

}
