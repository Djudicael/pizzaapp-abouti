package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.StockagePizzaJpa;

@WebServlet("/ajoutpizza")
public class PizzaServletAjoutWeb extends HttpServlet {
	@EJB 
	private PizzaServiceEJB  stockagePizza;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = (RequestDispatcher) this.getServletContext()
				.getRequestDispatcher("/WEB-INF/ajout.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* Récupération des champs du formulaire. */

		String categorie = req.getParameter("categorie");
		CategoriePizza categorieFin = CategoriePizza.valueOf(categorie);

		String reference = req.getParameter("reference");
		String libelle = req.getParameter("libelle");
		String prix = req.getParameter("prix");
		double prixFin = Double.valueOf(prix);

		Pizza newPizza = new Pizza(reference, libelle, prixFin, categorieFin);
		//StockagePizzaJpa pizza = new StockagePizzaJpa();
		try {
			stockagePizza.save(reference, newPizza);
		} catch (PizzeriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/listes");
	}

}
