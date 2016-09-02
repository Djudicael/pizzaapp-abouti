package fr.pizzeria.ihm;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Client;
import fr.pizzeria.service.Stockage;

public class SuprimerClientAction extends SuprimerAction<Integer, Client> {

	public SuprimerClientAction(Stockage<Integer, Client> stockage, String libelle, IhmHelper helper) {
		super(stockage, libelle, helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	Integer getSaisieCle() {
		Integer code = helper.getSc().nextInt();
		return code;
	}

}
