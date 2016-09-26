package dta.spring.web.mvc.controller;

import org.springframework.stereotype.Repository;

@Repository
public class ClientSolde {
	private String operation;
	private double solde;

	public String getOperation() {
		return operation;
	}
	
	public Operation getTypedOperation() {
		return Operation.valueOf(this.operation);
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}

}
