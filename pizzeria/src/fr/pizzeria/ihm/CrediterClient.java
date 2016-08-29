package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.CreditException;
import fr.pizzeria.service.Stockage;

public class CrediterClient extends Action {

	private Stockage<Integer, Client> stockage;
	private Scanner sc;

	public CrediterClient(Stockage<Integer, Client> stockage, Scanner sc) {
		super("crediter client");
		this.stockage = stockage;
		this.sc = sc;
	}

	@Override
	public void execute() {
		Map<Integer, Client> clients = this.stockage.finAll();

		System.out.println("Veuillez choisir le client à crediter");
		int idClient = sc.nextInt();

		System.out.println("Veuillez rentrer le montant a crediter");
		double montant = sc.nextDouble();
		Client clientTrouve = clients.get(idClient);
		try {
			clientTrouve.crediterCompte(montant);
		} catch (CreditException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
