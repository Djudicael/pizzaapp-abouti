package fr.pizzeria.service;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Livreur;

public class StockageLivreurs implements Stockage<Integer, Livreur> {

	public Map<Integer, Livreur> listeLivreur = new TreeMap<>();

	public StockageLivreurs() {
		super();
		Livreur manu = new Livreur(1, "Ehmanu", "Tudecend", 1000.0);
		listeLivreur.put(manu.getId(), manu);
		Livreur hari = new Livreur(2, "haribo", "cestbolavie", 200);
		listeLivreur.put(hari.getId(), hari);
		Livreur mcdo = new Livreur(3, "elton", "notle", 1000);
		listeLivreur.put(mcdo.getId(), mcdo);
	}

	@Override
	public Map<Integer, Livreur> finAll() {
		// TODO Auto-generated method stub
		return listeLivreur;
	}

	@Override
	public void save(Integer newcode, Livreur newPizza) throws PizzeriaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Integer newcode, Livreur pizza, Integer anciencode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer code) {
		// TODO Auto-generated method stub

	}

}
