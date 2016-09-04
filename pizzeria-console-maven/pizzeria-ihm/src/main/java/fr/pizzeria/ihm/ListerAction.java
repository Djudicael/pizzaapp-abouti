package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Map;

import fr.pizzeria.service.Stockage;


public class ListerAction<K, T> extends Action {

	private Stockage<K, T> stockage;

	public ListerAction(Stockage<K, T> stockage, String libelle) {
		// TODO Auto-generated constructor stub
		super(libelle);
		this.stockage = stockage;
	}

	@Override
	public void execute() throws IOException {
		System.out.println("**** liste ****");
		Map<K, T> clients = this.stockage.finAll();
		clients.values().forEach(System.out::println);
		/*
		 * for (T clientEnCours : clients.values()) {
		 * System.out.println(clientEnCours.toString()); }
		 */
	}

}
