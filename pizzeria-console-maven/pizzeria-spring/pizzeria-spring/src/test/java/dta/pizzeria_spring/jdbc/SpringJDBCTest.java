package dta.pizzeria_spring.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.pizzeria_spring.StockagePizzaSpringJDBC;
import dta.pizzeria_spring.beans.SpringConfig;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
import fr.pizzeria.service.StockagePizzaJDBC;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringJDBCConfig.class)
public class SpringJDBCTest {
	
	@Autowired
	StockagePizzaSpringJDBC pizzaStockage;
	
	
	@Test
	public void testCreationBean() throws IOException, SQLException {

            pizzaStockage.finAll().forEach(System.out::println);
	
		
	}
	@Test
	public void testAjoutbaseBean() throws IOException, SQLException, PizzeriaException {

		Pizza reine = new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		pizzaStockage.save(reine);
	
		
	}
	
	@Test
	public void testUpdateBean() throws IOException, SQLException {
		Pizza fromage = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
        pizzaStockage.update("FRO", fromage, "ANU");
	
		
	}
	
	@Test
	public void testDelete() throws IOException, SQLException {

		pizzaStockage.delete("POI");
	
		
	}
	
	

}
