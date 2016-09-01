package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Pizza;

public class AfficherPizzaTarifEleve extends Action {
	private IhmHelper helper;

	public AfficherPizzaTarifEleve(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;
	}

	@Override
	public void execute() throws IOException {
		Optional<Pizza> PizzaCher = helper.getStockagePizza().finAll().values().stream()
				.collect(Collectors.maxBy(Comparator.comparing(Pizza::getPrix)));

		System.out.println("La pizza au tarif la plus elevé est :" + PizzaCher.get());
	}

}
