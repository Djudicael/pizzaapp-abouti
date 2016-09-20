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
import fr.pizzeria.service.StockagePizzaJpa;

@WebServlet("/update")
public class PizzaServletUpdate extends HttpServlet {
	@EJB 
	private PizzaServiceEJB  stockagePizza;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = (RequestDispatcher) this.getServletContext()
				.getRequestDispatcher("/WEB-INF/editer.jsp");

		String code = req.getParameter("code");

		//StockagePizzaJpa stockage = new StockagePizzaJpa();

		try {
			Pizza pizza = stockagePizza.finAll().get(code);
			req.setAttribute("pizza", pizza);
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldref = req.getParameter("oldref");
		String categorie = req.getParameter("categorie");
		CategoriePizza categorieFin = CategoriePizza.valueOf(categorie);

		String reference = req.getParameter("reference");
		String libelle = req.getParameter("libelle");
		String prix = req.getParameter("prix");
		double prixFin = Double.valueOf(prix);

		Pizza newPizza = new Pizza(reference, libelle, prixFin, categorieFin);
		//StockagePizzaJpa pizza = new StockagePizzaJpa();
		try {
			stockagePizza.update(reference, newPizza, oldref);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/listes");
	}

}
