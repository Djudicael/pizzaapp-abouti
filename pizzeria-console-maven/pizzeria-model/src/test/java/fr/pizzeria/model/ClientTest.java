package fr.pizzeria.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	private Client client;

	@Before
	public void setUp() {
		client = new Client();

	}

	@Test(expected = CreditException.class)
	public void tesCrediterCompte() throws CreditException {
		client.crediterCompte(5000);

		Assert.assertTrue(client.getSolde().equals(7000.0));

	}

	@Test()
	public void tesCrediterCompte1() throws CreditException {
		client.crediterCompte(300);

		Assert.assertTrue(client.getSolde().equals(2300.0));

	}

	@Test(expected = DebitException.class)
	public void debiterCompte1() throws DebitException {
		client.debiterCompte(5000);

		Assert.assertTrue(client.getSolde().equals(-3000.0));

	}

	@Test()
	public void debiterCompte() throws DebitException {
		client.debiterCompte(300);

		Assert.assertTrue(client.getSolde().equals(1700.0));

	}

}
