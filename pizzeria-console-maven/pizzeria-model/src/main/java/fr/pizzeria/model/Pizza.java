package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "pizza.findId", query = "select p from Pizza p where p.code=:toto"),
		@NamedQuery(name = "pizza.delete", query = "delete from Pizza p where p.code=:toto") })
public class Pizza {
	private static final String DEFAULT_URL_IMAGE = "http://placehold.it/350x150";

	private static int idPiz;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "reference")
	private String code;
	@Column(name = "libelle")
	private String nom;
	private Double prix;
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	@Column(name = "url_image")
	private String urlImage = DEFAULT_URL_IMAGE;
	public static int nbPizzas;

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		// id = idPiz + 1;
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " " + code + " " + nom + " " + prix + " " + categorie + " ";
		// return code + " " + nom + " " + prix;
	}
}
