package web;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class PersistanceUtils {

	private static PersistanceUtils instanceUnique = new PersistanceUtils();

	private Stockage<String, Pizza> stockagePizza = new StockagePizzaJpa();

	private PersistanceUtils() {

	}

	public static PersistanceUtils getInstance() {
		return instanceUnique;
	}

	public Stockage<String, Pizza> getStockagePizza() {
		return stockagePizza;

	}
}
