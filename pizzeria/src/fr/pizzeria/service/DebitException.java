package fr.pizzeria.service;

public class DebitException extends Exception {

	public DebitException() {
		super();
	}

	public DebitException(String message, Throwable cause) {
		super(message, cause);
	}

	public DebitException(Throwable cause) {
		super(cause);
	}

	public DebitException(String message) {
		super(message);
	}

}
