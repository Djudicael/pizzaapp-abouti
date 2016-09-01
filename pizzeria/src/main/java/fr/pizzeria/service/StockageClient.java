package fr.pizzeria.service;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Client;

public class StockageClient implements Stockage<Integer, Client> {

	public Map<Integer, Client> listeClient = new TreeMap<>();

	public StockageClient() {
		super();
		Client jojo = new Client(1, "Morpal", "Joel", 1000);
		listeClient.put(jojo.getId(), jojo);
		Client mar = new Client(2, "Tariel", "Marie", 2005);
		listeClient.put(mar.getId(), mar);
		Client opal = new Client(3, "Opal", "Lucie", 500);
		listeClient.put(opal.getId(), opal);
	}

	@Override
	public Map<Integer, Client> finAll() {
		// TODO Auto-generated method stub
		return listeClient;
	}

	@Override
	public void save(Integer newcode, Client newPizza) throws PizzeriaException {
		listeClient.put(newcode, newPizza);

	}

	@Override
	public void update(Integer newcode, Client pizza, Integer anciencode) {
		int code = anciencode;
		int clientAModifier;

		for (int ClientEnCours : listeClient.keySet()) {
			if (ClientEnCours == code) {
				clientAModifier = ClientEnCours;

			}
		}
		// option 1
		listeClient.remove(anciencode);
		listeClient.put(newcode, pizza);

	}

	@Override
	public void delete(Integer code) {
		listeClient.remove(code);

	}

}
