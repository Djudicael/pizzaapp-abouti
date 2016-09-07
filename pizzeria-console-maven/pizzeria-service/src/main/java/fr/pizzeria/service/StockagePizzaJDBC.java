package fr.pizzeria.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaJDBC implements Stockage<String, Pizza> {

	@Override
	public Map<String, Pizza> finAll() throws IOException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pizzeria?useSSL=false", "root",
				"");

		Map<String, Pizza> struct = new HashMap<>();
		PreparedStatement selectPizzaSt = connection.prepareStatement("SELECT *FROM pizza ");

		ResultSet resultats = selectPizzaSt.executeQuery();

		while (resultats.next()) {
			Pizza pizza = new Pizza();
			// Integer id = resultats.getInt("id");
			String code = resultats.getString("reference");
			String nom = resultats.getString("libelle");
			BigDecimal prix = resultats.getBigDecimal("prix");
			String categorie = resultats.getString("categorie");
			// System.out.println("[CODE=" + code + " nom=" + nom + " prix=" +
			// prix + "]");

			pizza.setCode(code);
			pizza.setNom(nom);
			pizza.setPrix(prix.doubleValue());

			if (categorie != null) {
				pizza.setCategorie(CategoriePizza.valueOf(categorie));
			}

			struct.put(pizza.getCode(), pizza);
		}
		resultats.close();
		selectPizzaSt.close();
		connection.close();

		return struct;
	}

	@Override
	public void save(String newcode, Pizza newPizza) throws PizzeriaException, IOException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pizzeria?useSSL=false", "root",
				"");

		PreparedStatement savePizza = connection.prepareStatement(
				" INSERT INTO pizza ( reference, libelle, prix , url_image,  categorie) VALUES (?, ? , ? , ?, ? )");
		savePizza.setString(1, newPizza.getCode());
		savePizza.setString(2, newPizza.getNom());
		savePizza.setDouble(3, newPizza.getPrix());
		savePizza.setString(4, newPizza.getNom() + ".jpg");
		savePizza.setString(5, newPizza.getCategorie().toString());
		savePizza.executeUpdate();

	}

	@Override
	public void update(String newcode, Pizza pizza, String anciencode) throws IOException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pizzeria?useSSL=false", "root",
				"");

		PreparedStatement savePizza = connection.prepareStatement(
				" UPDATE pizza SET  reference =?, libelle= ?, prix=? , url_image= ?,  categorie= ? WHERE reference =?");
		savePizza.setString(1, pizza.getCode());
		savePizza.setString(2, pizza.getNom());
		savePizza.setDouble(3, pizza.getPrix());
		savePizza.setString(4, pizza.getNom() + ".jpg");
		savePizza.setString(5, pizza.getCategorie().toString());
		savePizza.setString(6, anciencode);
		savePizza.executeUpdate();
		savePizza.close();
		connection.close();
	}

	@Override
	public void delete(String code) throws IOException, SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pizzeria?useSSL=false", "root",
				"");

		PreparedStatement deletePizza = connection.prepareStatement(" DELETE FROM pizza WHERE reference= ?");
		deletePizza.setString(1, code);
		deletePizza.executeUpdate();
		deletePizza.close();
		connection.close();

	}

}
