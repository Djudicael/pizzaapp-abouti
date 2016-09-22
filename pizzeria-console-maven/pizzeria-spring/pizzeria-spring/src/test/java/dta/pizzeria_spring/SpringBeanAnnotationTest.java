package dta.pizzeria_spring;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.service.Stockage;

public class SpringBeanAnnotationTest {
	@Test
	public void testCreationBean() throws IOException, SQLException {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)){

            Stockage<?, ?> pizzaStockage = context.getBean(Stockage.class);

            pizzaStockage.finAll().values().forEach(System.out::println);
		}
		
	}

}
