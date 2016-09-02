package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Map;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.CreditException;
import fr.pizzeria.model.DebitException;

public class EffectuerVirement extends Action {
	private IhmHelper helper;

	public EffectuerVirement(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException {
		Map<Integer, Client> clients = this.helper.getStockageClient().finAll();
		System.out.println("selectionne le client qui doit effectuer le virement");
		int idClientDebiter = helper.getSc().nextInt();
		System.out.println("slectionner le client qui doit recevoir le virement");
		int idClientCrediter = helper.getSc().nextInt();
		System.out.println("Veuillez rentrer le montant a debiter du client:");
		double montant = helper.getSc().nextDouble();
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
