package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Map;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.Stockage;

@Annotationaction
public class AjouterClientAction extends Action {
	private Stockage<Integer, Client> stockage;

	private IhmHelper helper;

	public AjouterClientAction(Stockage<Integer, Client> stockagec, String libelle, IhmHelper helper) {
		super(libelle);
		this.stockage = stockagec;
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException {
		Map<Integer, Client> clients = this.stockage.finAll();

		Client newModif = helper.buildClientBySaisie();

		System.out.println("Menu 6. Ajouter nouveau client");

		if (clients.containsKey(newModif.getId())) {

			System.out.println("Un client poss�de deja cet Id");

		} else {
			// sauvegrde de la pizza
			try {
				stockage.save(newModif.getId(), newModif);
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
