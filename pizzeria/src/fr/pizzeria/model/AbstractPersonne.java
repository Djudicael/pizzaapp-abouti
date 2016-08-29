package fr.pizzeria.model;

import fr.pizzeria.service.CreditException;
import fr.pizzeria.service.DebitException;

public class AbstractPersonne {

	private int id;
	private String nom;
	private String prenom;
	private double solde;

	public AbstractPersonne(int id, String nom, String prenom, double solde) {

		this.id = id;

		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public void crediterCompte(double montant) throws CreditException {
		double soldeTemporaire;
		soldeTemporaire = this.solde + montant;

		if (soldeTemporaire > 5000) {
			// declencher exception
			CreditException e = new CreditException("le montante est trop elevé");
			throw e;
		}

		this.solde = soldeTemporaire;

	}

	public void debiterCompte(double montant) throws DebitException {
		double soldeTemporaire;
		soldeTemporaire = this.solde - montant;
		if (soldeTemporaire < 0) {

			// declencher exception
			DebitException e = new DebitException("le montant du solde est négatif ");
			throw e;

		}
		this.solde = soldeTemporaire;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " -> " + prenom + " " + nom + " (" + solde + " euros) ";
	}
}
