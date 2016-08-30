package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.service.CompteStat;
import fr.pizzeria.service.Stockage;

public class AfficherStatCompte extends Action {
	private Stockage<Integer, Client> stockageC;
	private Stockage<Integer, Livreur> stockageL;

	public AfficherStatCompte(Stockage<Integer, Client> stockageC, Stockage<Integer, Livreur> stockageL) {
		super("Afficher statistique compte");
		this.stockageC = stockageC;
		this.stockageL = stockageL;
	}

	@Override
	public void execute() {

		List<CompteStat> stat = new ArrayList<>();
		stat.addAll(stockageC.finAll().values());
		stat.addAll(stockageL.finAll().values());

		System.out.println("le nombre de compte est de " + stat.size());
		// total somme
		double sommeTotale = 0;
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
