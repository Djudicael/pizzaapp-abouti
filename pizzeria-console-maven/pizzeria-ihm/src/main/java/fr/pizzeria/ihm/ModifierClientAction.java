package fr.pizzeria.ihm;

import java.io.IOException;
import java.sql.SQLException;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;

public class ModifierClientAction extends Action {

	private IhmHelper ihmHelper;

	public ModifierClientAction(IhmHelper ihmHelper) {
		super("Modifier un client");

	}

	@Override
	public void execute() throws IOException, SQLException {
		System.out.println("Menu 3. Mettre à jour un client");
		System.out.println("voici la liste de client");
		ListerAction<Integer, Client> liste = new ListerAction<>(ihmHelper.getStockageClient(), "");
		liste.execute();

		System.out.println("Veuillez choisir le client à modifier");
		int ancienCode = ihmHelper.getSc().nextInt();

		Client newModif = ihmHelper.buildClientBySaisie();

		ihmHelper.getStockageClient().update(newModif.getId(), newModif, ancienCode);

	}

}
