package dta.spring.web.mvc.controller;

public enum Operation {
	
	CREDIT("credit"), DEBIT("Debit");

	private String decre;

	Operation(String decre) {
		this.decre = decre;

	}

}
