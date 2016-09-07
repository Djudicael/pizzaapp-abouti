package fr.pizzeria.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class Importation {

	public void finAllAndImport() throws IOException {

		Map<String, Pizza> struct = new HashMap<>();

		Files.list(Paths.get("data", "pizza")).map(chemin -> {

			Pizza pizza = new Pizza();
			pizza.setCode(chemin.getFileName().toString());

			try (Stream<String> lines = Files.lines(chemin)) {
				;
				String firstLine = lines.findFirst().get();

				String[] tab = firstLine.split(" ");

				pizza.setCode(tab[0]);
				pizza.setNom(tab[1]);
				pizza.setPrix(Double.valueOf(tab[2]));
				pizza.setCategorie(CategoriePizza.valueOf(tab[3]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return pizza;
		}).collect(Collectors.groupingBy(Pizza::getCode)).forEach((cle, valeur) -> {
			struct.put(cle, valeur.get(0));
		});

		List<Pizza> ListePiz = new ArrayList<>();
		ListePiz.addAll(struct.values());
		List<List<Pizza>> listePizzaDecoupe = ListUtils.partition(ListePiz, 3);
		System.out.println(listePizzaDecoupe);
		listePizzaDecoupe.forEach(listePizza -> {
			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false", "root", "");) {

				try {
					connection.setAutoCommit(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				listePizza.forEach(pizza -> {

					try (PreparedStatement savePizza = connection.prepareStatement(
							"INSERT INTO PIZZA(reference, libelle, prix, categorie, url_image) VALUES( ?, ?, ?, ?, ?)");) {
						savePizza.setString(1, pizza.getCode());
						savePizza.setString(2, pizza.getNom());
						savePizza.setDouble(3, pizza.getPrix());
						savePizza.setString(4, pizza.getCategorie().toString());
						savePizza.setString(5, pizza.getNom() + ".jpg");
						savePizza.executeUpdate();
					} catch (SQLException e) {
						try {
							connection.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						throw new ServiceException(e);

					}

				});

				try {
					connection.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (SQLException e) {
				throw new ServiceException(e);
			}
		});
	}
}
