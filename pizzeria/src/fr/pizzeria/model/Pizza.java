package fr.pizzeria.model;

public class Pizza {
	private static int idPiz;
	private int id;
	private String code;
	private String nom;
	private double prix;
	public static int nbPizzas;

	public Pizza(String code, String nom, double prix) {
		super();
		id = idPiz + 1;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public static int getIdPiz() {
		return idPiz;
	}

	public static void setIdPiz(int idPiz) {
		Pizza.idPiz = idPiz;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code + " " + nom + " " + prix;
	}
}
