package fr.pizzeria.service;

public class CreditException extends Exception {

	public CreditException() {
		super();
	}

	public CreditException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreditException(Throwable cause) {
		super(cause);
	}

	public CreditException(String message) {
		super(message);
	}

}
