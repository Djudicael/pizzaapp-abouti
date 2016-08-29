package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.DebitException;
import fr.pizzeria.service.Stockage;

public class DebiterClient extends Action {

	private Stockage<Integer, Client> stockage;
	private Scanner sc;

	public DebiterClient(Stockage<Integer, Client> stockage, Scanner sc) {
		super("debiter credits");
		this.stockage = stockage;
		this.sc = sc;
	}

	@Override
	public void execute() {
		Map<Integer, Client> clients = this.stockage.finAll();

		System.out.println("Veuillez choisir le client à debiter");
		int idClient = sc.nextInt();

		System.out.println("Veuillez rentrer le montant a debiter");
		double montant = sc.nextDouble();
		Client clientTrouve = clients.get(idClient);

		try {
			clientTrouve.debiterCompte(montant);
		} catch (DebitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
