package fr.pizzeria.model;

public enum StatutCommande {

	EN_COURS("En Livraison"), LIVRER("Livré"), EN_CONSTRUCTION("En preparation");

	private String statut;

	StatutCommande(String statut) {
		this.statut = statut;

	}

}
