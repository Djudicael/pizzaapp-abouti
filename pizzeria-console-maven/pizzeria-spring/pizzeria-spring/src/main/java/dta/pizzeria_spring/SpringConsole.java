package dta.pizzeria_spring;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.service.Stockage;

@Component
public class SpringConsole {
	  @Autowired private Stockage<?, ?> stockage;
	    
	    
	    public void afficherToutesLesPizzas() throws IOException, SQLException {
	        stockage.finAll().values().forEach(System.out::println);
	    }

}
