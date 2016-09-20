package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;

@Path("/rest/pizzas/")
public class PizzaRessource {
	@EJB 
	private PizzaServiceEJB  stockagePizza;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Pizza>list() throws IOException, SQLException{
		Map<String, Pizza> pizzas;
		pizzas = stockagePizza.finAll();
		Collection<Pizza> pizzaListe = pizzas.values();
		
		
		return pizzaListe;
	}
	
	@POST
	@Consumes({"application/json"})
	public void post(Pizza p) throws PizzeriaException, IOException, SQLException{
		
		stockagePizza.save(p.getCode(), p);

	}
	
	@PUT
	@Path("/{oldredf}")
	@Consumes({"application/json"})
	public void put(Pizza p, @PathParam("oldredf") String oldref) throws PizzeriaException, IOException, SQLException{
		
		stockagePizza.update(p.getCode(), p, oldref);

	}
	
	@DELETE
	@Path("/{oldredf}")
	@Consumes({"application/json"})
	public void put(@PathParam("oldredf") String oldref) throws PizzeriaException, IOException, SQLException{
		
		stockagePizza.delete(oldref);

	}

}
