package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJpa;

public class PizzaServletWebApi extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			Stockage<String, Pizza> stockageProperties = new StockagePizzaJpa();
			Map<String, Pizza> pizzas = stockageProperties.finAll();
			pizzas.values().forEach(e -> {
				try {
					resp.getWriter().write(e.toString() + "\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
