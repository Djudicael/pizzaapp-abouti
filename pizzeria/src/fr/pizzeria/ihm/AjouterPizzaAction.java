package fr.pizzeria.ihm;

public class AjouterPizzaAction extends Action{
	
	 public AjouterPizzaAction() {
		 super("Ajouter pizza");
	}

	@Override
	public void execute() {
		System.out.println("ajout d'une pizza");
		
	}

}
