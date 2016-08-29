package fr.pizzeria.ihm;

import java.util.Map;

import fr.pizzeria.service.Stockage;

public class ListerPersonneAction<K, T> extends Action {

	private Stockage<K, T> stockage;

	public ListerPersonneAction(Stockage<K, T> stockagec) {
		// TODO Auto-generated constructor stub
		super("lister les clients");
		this.stockage = stockagec;
	}

	@Override
	public void execute() {
		System.out.println("**** liste Clients ****");
		Map<K, T> clients = this.stockage.finAll();

		for (T clientEnCours : clients.values()) {
			System.out.println(clientEnCours.toString());
		}
	}

}
