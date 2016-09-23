package dta.pizzeria_spring.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJDBC;
import fr.pizzeria.service.StockageTableau;

@Configuration
@ComponentScan({"dta.pizzeria_spring"})
public class SpringConfig {

@Bean	
	public Stockage<?, ?> stockage(){
		return new StockageTableau();
	}



@Bean
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
    dataSource.setUsername("root");
    dataSource.setPassword("");
    return dataSource;
}

}
