package fr.pizzeria.service;

public class SavePizzaException extends Exception {

	public SavePizzaException() {
		super();
	}

	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public SavePizzaException(Throwable cause) {
		super(cause);
	}

	public SavePizzaException(String message) {
		super(message);
	}

}
