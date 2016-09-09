package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Livreur extends AbstractPersonne {
	@OneToMany(mappedBy = "livreur")
	private Set<Commande> commande;

	private double montantDecouvertAutorise;

	public Livreur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livreur(String nom, String prenom, double solde) {
		super(nom, prenom, solde);
		// TODO Auto-generated constructor stub
	}

	public Livreur(String nom, String prenom, String email, String motDePasse) {
		super(nom, prenom, email, motDePasse);
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
