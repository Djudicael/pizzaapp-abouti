package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.Stockage;

public class AjouterClientAction extends Action {
	private Stockage<Integer, Client> stockage;
	private Scanner sc;
	private IhmHelper helper;

	public AjouterClientAction(Stockage<Integer, Client> stockagec, Scanner scanner) {
		super("Ajouter client");
		this.stockage = stockagec;
		this.sc = scanner;
	}

	@Override
	public void execute() {
		Map<Integer, Client> clients = this.stockage.finAll();

		Client newModif = helper.buildClientBySaisie();

		System.out.println("Menu 6. Ajouter nouveau client");
		System.out.println("veuiller saisir l'id");
		int newId = sc.nextInt();

		if (clients.containsKey(newModif.getId())) {

			System.out.println("Un client poss�de deja cet Id");

		} else {
			System.out.println("veuillez saisir le nom sans espace");
			String newnom = sc.next();

			System.out.println("veuillez saisir le prenom sans espace");
			String newPrenom = sc.next();

			System.out.println("veuillez saisir le solde");
			double newSolde = sc.nextDouble();
			// creation de la nouelle pizza
			Client newClient = new Client(newId, newnom, newPrenom, newSolde);

			// sauvegrde de la pizza
			try {
				stockage.save(newId, newClient);
			} catch (PizzeriaException e) {
				// TODO Auto-generated catch block
				// System.out.println("attention vous avez rentr� un code de
				// plus de
				// 3 lettres");
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}

			System.out.println("Client ajout�");

		}

	}

}
