package web.commande;

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

import fr.pizzeria.ejb.CommandeServiceEJB;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;

@Path("/rest/commandes/")
public class CommandeRessource {
	@EJB 
	private CommandeServiceEJB  stockageCommande;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Commande>list() throws IOException, SQLException{
		Collection< Commande> commandes;
		commandes = stockageCommande.finAll();
		
		
		
		return commandes;
	}
	
	@POST
	@Consumes({"application/json"})
	public void post(Commande c) throws PizzeriaException, IOException, SQLException{
		
		stockageCommande.save(c.getNumeroCommande(), c);

	}
	
	@PUT
	@Path("/{oldredf}")
	@Consumes({"application/json"})
	public void put(Commande c, @PathParam("oldredf") Integer oldref) throws PizzeriaException, IOException, SQLException{
		
		stockageCommande.update(c.getNumeroCommande(), c, oldref);

	}
	
	@DELETE
	@Path("/{oldredf}")
	@Consumes({"application/json"})
	public void put(@PathParam("oldredf") Integer oldref) throws PizzeriaException, IOException, SQLException{
		
		stockageCommande.delete(oldref);

	}


}
