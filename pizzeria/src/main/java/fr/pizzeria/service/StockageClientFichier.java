package fr.pizzeria.service;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.Stockage;

public class StockageClientFichier implements Stockage<Integer, Client> {

	@Override
	public Map<Integer, Client> finAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Integer newcode, Client newPizza) throws PizzeriaException, IOException {
		Path cheminFichier = Paths.get("data", "client", newcode + ".txt");
		// Création d'un nouveau fichier
		Files.createFile(cheminFichier);
		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		Files.write(cheminFichier,
				Arrays.asList(newPizza.getId() + " " + newPizza.getNom() + " " + newPizza.getSolde()));
		// Parcourir les lignes d'un fichier
		try (Stream<String> lines = Files.lines(cheminFichier)) {
			lines.forEach(System.out::println);
		}
		;

	}

	@Override
	public void update(Integer newcode, Client pizza, Integer anciencode) throws IOException {
		// parcourir le répertoire data/pizza
		Path cheminFichier = Paths.get("data", "newcode", anciencode + ".txt");
		System.out.println(cheminFichier);

		// Files.delete(cheminFichier);
		String userMessage = "";
		try {
			// do not check for permission
			// just go ahead and delete
			// if denied, act based on it
			Files.deleteIfExists(Paths.get("data", "client", anciencode + ".txt"));
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
		Files.write(cheminFichier, Arrays.asList(pizza.getId() + " " + pizza.getNom() + " " + pizza.getSolde()));
		// Parcourir les lignes d'un fichier
		try (Stream<String> lines = Files.lines(cheminFichier)) {
			lines.forEach(System.out::println);
		}
		;

	}

	@Override
	public void delete(Integer code) throws IOException {
		// parcourir le répertoire data/pizza
		Path cheminFichier = Paths.get("data", "client", code + ".txt");
		System.out.println(cheminFichier);

		// Files.delete(cheminFichier);
		String userMessage = "";
		try {
			// do not check for permission
			// just go ahead and delete
			// if denied, act based on it
			Files.deleteIfExists(Paths.get("data", "client", code + ".txt"));
			userMessage = "Deleted Successfully!";
		} catch (AccessDeniedException ade) {
			ade.printStackTrace();
			userMessage = ade.getMessage() + " File is not writable.";
		}

	}

}
