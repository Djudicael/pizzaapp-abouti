package fr.pizzeria.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.CreditException;
import fr.pizzeria.service.Stockage;

public class CrediterClient extends Action {

	private Stockage<Integer, Client> stockage;
	private IhmHelper helper;

	public CrediterClient(Stockage<Integer, Client> stockage, String libelle) {
		super(libelle);
		this.stockage = stockage;
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException, SQLException {
		Map<Integer, Client> clients = this.helper.getStockageClient().finAll();

		System.out.println("Veuillez choisir le client à crediter");
		int idClient = helper.getSc().nextInt();

		System.out.println("Veuillez rentrer le montant a crediter");
		double montant = helper.getSc().nextDouble();
		Client clientTrouve = clients.get(idClient);
		try {
			clientTrouve.crediterCompte(montant);
		} catch (CreditException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
