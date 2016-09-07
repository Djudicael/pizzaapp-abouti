package fr.pizzeria.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.Pizza;

@Annotationaction(constructAction = "simple")
public class GrouperPizzaCategorie extends Action {

	private IhmHelper helper;

	public GrouperPizzaCategorie(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() throws IOException, SQLException {

		helper.getStockagePizza().finAll().values().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((cle, valeur) -> System.out.println(cle + " -> " + valeur));
	}

}
