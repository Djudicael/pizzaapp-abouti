package fr.pizzeria.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numeroCommande;

	private Calendar date;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Commande(Integer id, Integer numeroCommande, Calendar date, Client client, Livreur livreur, Set<Pizza> pizza,
			StatutCommande statut) {
		super();
		this.id = id;
		this.numeroCommande = numeroCommande;
		this.date = date;
		this.client = client;
		this.livreur = livreur;
		this.pizza = pizza;
		this.statut = statut;
	}

	public Commande() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private Set<Pizza> pizza;

	@Enumerated(EnumType.STRING)
	private StatutCommande statut;

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public Calendar getDate() {
		return date;
	}

	public Client getClient() {
		return client;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public Set<Pizza> getPizza() {
		return pizza;
	}

	public StatutCommande getStatut() {
		return statut;
	}

}
