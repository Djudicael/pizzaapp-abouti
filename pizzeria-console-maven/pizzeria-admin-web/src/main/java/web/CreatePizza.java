package web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.event.Observes;

import fr.pizzeria.model.Pizza;

public class CreatePizza {
	
	
	private List<Pizza> PizzaListe = new ArrayList<Pizza>();
	private Pizza pizzaCree;
	public Pizza getPizzaCree() {
		return pizzaCree;
	}
	public void setPizzaCree(Pizza pizzaCree) {
		this.pizzaCree = pizzaCree;
	}



	private Calendar date ;
	
	public List<Pizza> getPizzaListe() {
		return PizzaListe;
	}
	public void setPizzaListe(List<Pizza> pizzaListe) {
		PizzaListe = pizzaListe;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	

	
	public void ecouteMonEvent(@Observes Pizza pizzaEvent){
		PizzaListe.add(pizzaEvent);
	}
	

}
