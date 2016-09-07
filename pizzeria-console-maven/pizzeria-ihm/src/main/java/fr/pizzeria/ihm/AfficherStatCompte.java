package fr.pizzeria.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.ihm.helper.IhmHelper;
import fr.pizzeria.model.CompteStat;

@Annotationaction(constructAction = "simple")
public class AfficherStatCompte extends Action {
	private IhmHelper helper;

	public AfficherStatCompte(IhmHelper helper, String libelle) {
		super(libelle);
		this.helper = helper;

	}

	@Override
	public void execute() throws IOException, SQLException {

		List<CompteStat> stat = new ArrayList<>();
		stat.addAll(helper.getStockageClient().finAll().values());
		stat.addAll(helper.getStockageLivreur().finAll().values());

		System.out.println("le nombre de compte est de " + stat.size());
		Double som = stat.stream().collect(Collectors.summingDouble(cs -> cs.getSolde()));

		System.out.println("Total somme " + som);
		Double average = stat.stream().collect(Collectors.averagingDouble(CompteStat::getSolde));

		System.out.println("Moyenne somme " + average);
		Optional<CompteStat> max = stat.stream().collect(Collectors.maxBy(Comparator.comparing(CompteStat::getSolde)));

		if (max.isPresent()) {
			CompteStat stat1 = max.get();
		}
		Optional<CompteStat> min = stat.stream().collect(Collectors.minBy(Comparator.comparing(CompteStat::getSolde)));
		if (min.isPresent()) {
			CompteStat stat2 = min.get();
		}

		/*
		 * CompteStat min = Collections.min(stat, new Comparator<CompteStat>() {
		 * 
		 * @Override public int compare(CompteStat o1, CompteStat o2) { return
		 * o1.getSolde().compareTo(o2.getSolde()); } });
		 */

		System.out.println("Solde le plus elevé " + max.get().getSolde());
		System.out.println("Solde le plus faible " + min.get().getSolde());

	}

}
