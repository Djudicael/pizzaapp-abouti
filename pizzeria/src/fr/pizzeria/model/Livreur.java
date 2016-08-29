package fr.pizzeria.model;

public class Livreur extends AbstractPersonne  {

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
	public double getSolde() {
		// TODO Auto-generated method stub
		return super.getSolde();
	}

	
}
