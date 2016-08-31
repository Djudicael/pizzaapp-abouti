package fr.pizzeria.ihm;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class SuprimerPizzaAction extends SuprimerAction<String, Pizza> {

	public SuprimerPizzaAction(Stockage<String, Pizza> stockage, String libelle, IhmHelper helper) {

		super(stockage, libelle, helper);
	}

	@Override
	String getSaisieCle() {
		String code = helper.getSc().next();
		return code;
	}

}
