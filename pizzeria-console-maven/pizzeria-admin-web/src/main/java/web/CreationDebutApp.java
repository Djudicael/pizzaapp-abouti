package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
@WebListener
public class CreationDebutApp implements ServletContextListener {
	
	@EJB 
	private PizzaServiceEJB  stockagePizza;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		Pizza newPizza = new Pizza("MAN", "manopl", 15.2, CategoriePizza.valueOf("VIANDE"));
		Pizza newPizza1 = new Pizza("POI", "poisonnerie", 15.2, CategoriePizza.valueOf("POISSON"));
		Pizza newPizza2 = new Pizza("MPUI", "issabella", 15.2, CategoriePizza.valueOf("VIANDE"));
		Pizza newPizza3 = new Pizza("ANU", "capintaine", 15.2, CategoriePizza.valueOf("POISSON"));
		Pizza newPizza4 = new Pizza("BUY", "achate", 15.2, CategoriePizza.valueOf("POISSON"));
		//StockagePizzaJpa pizza = new StockagePizzaJpa();
		
		
		try {
			stockagePizza.save("MPUI", newPizza2);
			stockagePizza.save("MAN", newPizza);
			stockagePizza.save("POI", newPizza1);
			stockagePizza.save("ANU", newPizza3);
			stockagePizza.save("BUY", newPizza4);
			
			ctx.setAttribute("PizzaDB", stockagePizza);
		} catch (PizzeriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
