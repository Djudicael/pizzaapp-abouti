package fr.pizzeria.model;

public class Pizza {

	
	private int id;
	private String code;
	private String nom;
	private double prix;
	public static int nbPizzas;
	
	
	public Pizza( String nom, double prix) {
		super();
		
		this.nom = nom;
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
