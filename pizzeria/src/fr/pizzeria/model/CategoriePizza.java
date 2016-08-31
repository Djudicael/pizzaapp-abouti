package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String cate;

	CategoriePizza(String cate) {
		this.cate = cate;

	}

}
