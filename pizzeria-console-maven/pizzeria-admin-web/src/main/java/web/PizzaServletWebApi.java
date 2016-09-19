package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.StockagePizzaJpa;

@WebServlet("/listes")
public class PizzaServletWebApi extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Pizza> pizzas;
		try {
			pizzas = PersistanceUtils.getInstance().getStockagePizza().finAll();
			Collection<Pizza> pizzaListe = pizzas.values();
			RequestDispatcher dispatcher = (RequestDispatcher) this.getServletContext()
					.getRequestDispatcher("/WEB-INF/listepizza.jsp");
			req.setAttribute("liste", pizzaListe);
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		StockagePizzaJpa pizza = new StockagePizzaJpa();
		try {
			pizza.save(reference, newPizza);
		} catch (PizzeriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String oldref = req.getParameter("oldref"); String categorie =
		 * req.getParameter("categorie"); CategoriePizza categorieFin =
		 * CategoriePizza.valueOf(categorie);
		 * 
		 * String reference = req.getParameter("reference"); String libelle =
		 * req.getParameter("libelle"); String prix = req.getParameter("prix");
		 * double prixFin = Double.valueOf(prix);
		 * 
		 * Pizza newPizza = new Pizza(reference, libelle, prixFin,
		 * categorieFin); StockagePizzaJpa pizza = new StockagePizzaJpa(); try {
		 * pizza.update(reference, newPizza, oldref); } catch (SQLException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		Map<String, String> map = new HashMap<String, String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String data = br.readLine();
		System.out.println(data);
		Pizza pizza = new Pizza();
		StockagePizzaJpa pizzaStoc = new StockagePizzaJpa();

		String[] tab = data.split("&");

		for (String keyValue : tab) {
			String[] kv = keyValue.split("=");
			map.put(kv[0], kv[1]);
			// kv[0] => la clé
			// kv[1] => la valeur
		}
		String nom = map.get("libelle");
		String code = map.get("reference");
		double prix = Double.valueOf(map.get("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(map.get("categorie").toString());

		Pizza newPizza = new Pizza(code, nom, prix, categorie);
		StockagePizzaJpa pizzafin = new StockagePizzaJpa();
		try {
			pizzafin.update(code, newPizza, map.get("oldref"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldref = req.getParameter("oldref");
		StockagePizzaJpa pizza = new StockagePizzaJpa();
		try {
			pizza.delete(oldref);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
