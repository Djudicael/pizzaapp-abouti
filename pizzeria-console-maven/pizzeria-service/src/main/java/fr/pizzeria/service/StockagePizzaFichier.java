package fr.pizzeria.service;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaFichier implements Stockage<String, Pizza> {

	@Override
	public Map<String, Pizza> finAll() throws IOException {
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

		return struct;

	}

	@Override
	public void save(String newcode, Pizza newPizza) throws PizzeriaException, IOException {

		Path cheminFichier = Paths.get("data", "pizza", newcode + ".txt");
		// Création d'un nouveau fichier
		Files.createFile(cheminFichier);
		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		Files.write(cheminFichier, Arrays.asList(newPizza.getCode() + " " + newPizza.getNom() + " " + newPizza.getPrix()
				+ " " + newPizza.getCategorie()));
		// Parcourir les lignes d'un fichier
		try (Stream<String> lines = Files.lines(cheminFichier)) {
			lines.forEach(System.out::println);
		}
		;

		// cheminFichier.getFileName()

	}

	@Override
	public void update(String newcode, Pizza pizza, String anciencode) throws IOException {
		// parcourir le répertoire data/pizza
		Path cheminFichier = Paths.get("data", "newcode", anciencode + ".txt");
		System.out.println(cheminFichier);

		// Files.delete(cheminFichier);
		String userMessage = "";
		try {
			// do not check for permission
			// just go ahead and delete
			// if denied, act based on it
			Files.deleteIfExists(Paths.get("data", "pizza", anciencode + ".txt"));
			userMessage = "Deleted Successfully!";
		} catch (AccessDeniedException ade) {
			ade.printStackTrace();
			userMessage = ade.getMessage() + " File is not writable.";
		}
		/*-------
		 * 
		 */
		// Mise a jour du fichier

		// Création d'un nouveau fichier
		Files.createFile(cheminFichier);
		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		Files.write(cheminFichier, Arrays
				.asList(pizza.getCode() + " " + pizza.getNom() + " " + pizza.getPrix() + " " + pizza.getCategorie()));
		// Parcourir les lignes d'un fichier
		Files.lines(cheminFichier).forEach(System.out::println);

	}

	@Override
	public void delete(String code) throws IOException {
		// parcourir le répertoire data/pizza
		Path cheminFichier = Paths.get("data", "pizza", code + ".txt");
		System.out.println(cheminFichier);

		// Files.delete(cheminFichier);
		String userMessage = "";
		try {
			// do not check for permission
			// just go ahead and delete
			// if denied, act based on it
			Files.deleteIfExists(Paths.get("data", "pizza", code + ".txt"));
			userMessage = "Deleted Successfully!";
		} catch (AccessDeniedException ade) {
			ade.printStackTrace();
			userMessage = ade.getMessage() + " File is not writable.";
		}

	}

}
