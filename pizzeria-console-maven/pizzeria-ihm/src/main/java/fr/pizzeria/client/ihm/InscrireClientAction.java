package fr.pizzeria.client.ihm;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

import fr.pizzeria.ihm.Action;
import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.service.PizzeriaException;

public class InscrireClientAction extends Action {
	private IhmHelper helper;

	public InscrireClientAction(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException, SQLException {
		System.out.println("Inscription");
		System.out.println("veuillez saisir le nom sans espace");
		String newnom = helper.getSc().next();

		System.out.println("veuillez saisir le prenom sans espace");
		String newPrenom = helper.getSc().next();
		System.out.println("veuillez saisir votre email");
		String email = helper.getSc().next();
		System.out.println("veuillez saisir votre email");
		String motDePasse = helper.getSc().next();
		String motDePasseEncoded;
		try {
			motDePasseEncoded = helper.encodage(motDePasse);

			Client newClient = new Client(newnom, newPrenom, email, motDePasseEncoded);
			try {
				helper.getStockageClient().save(newClient);
			} catch (PizzeriaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (GeneralSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
