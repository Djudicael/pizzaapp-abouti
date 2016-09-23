package dta.pizzeria_spring.beans;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.pizzeria_spring.SpringConsole;
import fr.pizzeria.service.Stockage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfig.class)
public class SpringBeanAnnotationTest {
	
	@Autowired
	Stockage<?, ?> pizzaStockage;
	@Autowired
	SpringConsole sc;
	
	@Test
	public void testCreationBean() throws IOException, SQLException {

            pizzaStockage.finAll().values().forEach(System.out::println);
	
		
	}
	
	@Test
	public void testSpringConsole() throws IOException, SQLException{
		sc.afficherToutesLesPizzas();
	}

}
