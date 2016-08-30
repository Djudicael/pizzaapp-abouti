package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Client;
import fr.pizzeria.service.Stockage;

public class SuprimerClientAction extends SuprimerAction<Integer, Client> {

	public SuprimerClientAction(Stockage<Integer, Client> stockage, Scanner scanner, String libelle) {
		super(stockage, scanner, libelle);
		// TODO Auto-generated constructor stub
	}

	@Override
	Integer getSaisieCle() {
		Integer code = sc.nextInt();
		return code;
	}

}
