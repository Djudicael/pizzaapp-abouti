package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.ejb.ClientServiceEJB;
import fr.pizzeria.ejb.LivreurServiceEJB;
import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
@WebListener
public class CreationDebutApp implements ServletContextListener {
	
	@EJB 
	private PizzaServiceEJB  stockagePizza;
	@EJB 
	private ClientServiceEJB  stockageClient;
	@EJB 
	private LivreurServiceEJB  stockageLivreur;
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		Pizza newPizza = new Pizza("MAN", "manopl", 15.2, CategoriePizza.valueOf("VIANDE"));
		Pizza newPizza1 = new Pizza("POI", "poisonnerie", 15.2, CategoriePizza.valueOf("POISSON"));
		Pizza newPizza2 = new Pizza("MPUI", "issabella", 15.2, CategoriePizza.valueOf("VIANDE"));
		Pizza newPizza3 = new Pizza("ANU", "capintaine", 15.2, CategoriePizza.valueOf("POISSON"));
		Pizza newPizza4 = new Pizza("BUY", "achate", 15.2, CategoriePizza.valueOf("POISSON"));
		
		//Client(String nom, String prenom, String email, String motDePasse)
		Client jojo = new Client("alin", "Morpal", "Joel@gmail", "tatayoyo");
		//StockagePizzaJpa pizza = new StockagePizzaJpa();
		Livreur mano = new Livreur("papy", "poipoi", "camell@gmail", "yoyotata");
		
		
		try {
			stockagePizza.save("MPUI", newPizza2);
			stockagePizza.save("MAN", newPizza);
			stockagePizza.save("POI", newPizza1);
			stockagePizza.save("ANU", newPizza3);
			stockagePizza.save("BUY", newPizza4);
			
			stockageClient.save(jojo);
			stockageLivreur.save(mano);
			
			ctx.setAttribute("PizzaDB", stockagePizza);
			ctx.setAttribute("PizzaDB", stockageClient);
			ctx.setAttribute("PizzaDB", stockageLivreur);
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
