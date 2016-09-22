package dta.pizzeria_spring;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import junit.framework.Assert;

public class SpringBeansXmlTes {
	
	@Test
	public void testCreationBean() throws IOException, SQLException{
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-config.xml")) {

            Stockage<?, ?> pizzaStockage = (Stockage<?, ?>) context.getBean("stockage");

            pizzaStockage.finAll().values().forEach(System.out::println);
            
        };
	}
        
        @Test
       public void testPizza(){
    	   try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                   "spring-config.xml")) {

               Pizza maPizza= context.getBean(Pizza.class);
               Assert.assertEquals("POPI", maPizza.getCode());
               
               
               
               
           };
    	   
       }
	

 }

