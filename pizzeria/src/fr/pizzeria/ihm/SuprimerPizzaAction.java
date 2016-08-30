package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class SuprimerPizzaAction extends SuprimerAction<String, Pizza> {

	public SuprimerPizzaAction(Stockage<String, Pizza> stockage, Scanner sc, String libelle) {

		super(stockage, sc, libelle);
	}

	@Override
	String getSaisieCle() {
		String code = sc.next();
		return code;
	}

}
