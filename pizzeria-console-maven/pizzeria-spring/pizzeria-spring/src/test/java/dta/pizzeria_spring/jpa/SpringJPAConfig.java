package dta.pizzeria_spring.jpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageTableau;



@ComponentScan({"dta.pizzeria_spring"})

@Configuration
// activer la gestion des transactions
@EnableTransactionManagement

// activer Spring Data Jpa
@EnableJpaRepositories("dta.pizzeria_spring.repository")
public class SpringJPAConfig {

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
    // activer JPA et lire le fichier META-INF/persistence.xml
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("pizzeria-ihm");
        return emf;
    }
    
    // pouvoir utiliser les annotations JPA (@PersistenceContext)
    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnn() {
        return new  PersistenceAnnotationBeanPostProcessor();
    }
    
    // configuration du gestionnaire de transaction
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new JpaTransactionManager();
    }

}