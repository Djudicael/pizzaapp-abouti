package fr.pizzeria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractPersonne implements CompteStat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	protected double solde;

	public AbstractPersonne(String nom, String prenom, String email, String motDePasse) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;

	}

	public AbstractPersonne(String nom, String prenom, double solde) {

		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	public AbstractPersonne() {

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

	public Double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void crediterCompte(double montant) throws CreditException {
		double soldeTemporaire;
		soldeTemporaire = this.solde + montant;

		if (soldeTemporaire > 5000) {
			// declencher exception
			CreditException e = new CreditException("le montant est trop elevé");
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
