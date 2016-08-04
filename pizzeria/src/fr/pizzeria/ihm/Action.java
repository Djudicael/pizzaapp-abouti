package fr.pizzeria.ihm;

public  class Action {
	
	private String libelle;
	
	
	public Action(String libelle) {
		this.libelle = libelle;
	}


	public Action() {
		super();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public  void execute(){
		
	}

}
