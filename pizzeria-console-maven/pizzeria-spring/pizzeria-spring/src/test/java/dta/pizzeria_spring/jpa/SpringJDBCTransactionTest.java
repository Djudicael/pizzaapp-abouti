package dta.pizzeria_spring.jpa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.pizzeria_spring.StockagePizzaParLotSpringJdbc;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringJPAConfig.class)
public class SpringJDBCTransactionTest {
	
	@Autowired
	private StockagePizzaParLotSpringJdbc stockageParLot;
	
	
	@Test
	public void testAjoutbaseBean() throws IOException, SQLException, PizzeriaException {
		
		List<Pizza> pizzas = new ArrayList<>();
		
		pizzas.add(new Pizza("papa", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("dff", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("ani", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("pari", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("pari", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("dfr", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("vbvc", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("azer", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		
		
		stockageParLot.insererParLot(pizzas);

		
	
		
	}

	
	

}
