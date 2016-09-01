package fr.pizzeria.model;

import fr.pizzeria.service.CreditException;
import fr.pizzeria.service.DebitException;

public class Livreur extends AbstractPersonne {

	private double solde;

	private double montantDecouvertAutorise;

	public Livreur(int id, String nom, String prenom, double solde) {
		super(id, nom, prenom, solde);
		// TODO Auto-generated constructor stub
	}

	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}

	@Override
	public void crediterCompte(double montant) throws CreditException {
		double soldeTemporaire;
		soldeTemporaire = this.solde + montant;

		this.solde = soldeTemporaire;
	}

	@Override
	public void debiterCompte(double montant) throws DebitException {
		double soldeTemporaire;
		soldeTemporaire = this.solde - montant;

		this.solde = soldeTemporaire;
	}

}
