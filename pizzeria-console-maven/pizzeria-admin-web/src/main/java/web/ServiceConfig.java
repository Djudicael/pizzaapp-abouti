package web;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class ServiceConfig {
	
	@Produces
	@ApplicationScoped
	
	public Stockage<String, Pizza> getStockagePizza(){
		
		return new StockagePizzaJpa();
		
	}

}
