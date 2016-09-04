package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Map;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.DebitException;
import fr.pizzeria.service.Stockage;

@Annotationaction(constructAction="client")
public class DebiterClient extends Action {

	private Stockage<Integer, Client> stockage;
	private IhmHelper helper;

	public DebiterClient(Stockage<Integer, Client> stockage, String libelle) {
		super(libelle);
		this.stockage = stockage;
		this.helper = helper;
	}

	@Override
	public void execute() throws IOException {
		Map<Integer, Client> clients = this.stockage.finAll();

		System.out.println("Veuillez choisir le client à debiter");
		int idClient = helper.getSc().nextInt();

		System.out.println("Veuillez rentrer le montant a debiter");
		double montant = helper.getSc().nextDouble();
		Client clientTrouve = clients.get(idClient);

		try {
			clientTrouve.debiterCompte(montant);
		} catch (DebitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
