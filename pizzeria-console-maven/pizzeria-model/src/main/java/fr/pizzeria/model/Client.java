package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "client.findId", query = "select p from Client p where p.id=:toto"),
		@NamedQuery(name = "client.delete", query = "delete from Client p where p.id=:toto") })
public class Client extends AbstractPersonne {
	@OneToMany(mappedBy = "client")
	private Set<Commande> commande;

	public Client(String nom, String prenom, double solde) {
		super(nom, prenom, solde);

	}

	public Client(String nom, String prenom) {
		super(nom, prenom, 0);

	}

	public Client(String nom, String prenom, String email, String motDePasse) {
		super(nom, prenom, email, motDePasse);

	}

	public Client() {

		// TODO Auto-generated constructor stub

	}

}
