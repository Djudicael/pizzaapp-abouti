package fr.pizzeria.model;

public class Pizza {
	private static int idPiz;
	private int id;
	private String code;
	private String nom;
	private Double prix;
	private CategoriePizza categorie;
	public static int nbPizzas;

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		id = idPiz + 1;
		this.categorie = categorie;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public static int getIdPiz() {
		return idPiz;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code + " " + nom + " " + prix + "  " + categorie;
	}
}
