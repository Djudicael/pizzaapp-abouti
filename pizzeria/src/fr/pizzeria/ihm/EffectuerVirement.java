package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.CreditException;
import fr.pizzeria.service.DebitException;
import fr.pizzeria.service.Stockage;

public class EffectuerVirement extends Action {
	private Stockage<Integer, Client> stockage;
	private Scanner sc;

	public EffectuerVirement(Stockage<Integer, Client> stockageC, Scanner sc) {
		super("virement enrte client");
		this.stockage = stockageC;
		this.sc = sc;
	}

	@Override
	public void execute() {
		Map<Integer, Client> clients = this.stockage.finAll();
		System.out.println("selectionne le client qui doit effectuer le virement");
		int idClientDebiter = sc.nextInt();
		System.out.println("slectionner le client qui doit recevoir le virement");
		int idClientCrediter = sc.nextInt();
		System.out.println("Veuillez rentrer le montant a debiter du client:");
		double montant = sc.nextDouble();
		Client clientTrouveDebiteur = clients.get(idClientDebiter);

		try {
			clientTrouveDebiteur.debiterCompte(montant);
		} catch (DebitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Client clientTrouveCrediteur = clients.get(idClientCrediter);
		try {
			clientTrouveCrediteur.crediterCompte(montant);
		} catch (CreditException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
