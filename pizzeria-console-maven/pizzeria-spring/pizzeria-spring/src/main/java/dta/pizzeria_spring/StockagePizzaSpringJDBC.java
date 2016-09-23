package dta.pizzeria_spring;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.PizzeriaException;
@Repository
public class StockagePizzaSpringJDBC  {

	
	
	@Autowired StockagePizzaParLotSpringJdbc stockagePizzaSpringJdbc;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired	
public StockagePizzaSpringJDBC(DataSource datasource) {
	this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	
	private RowMapper<Pizza> rowmapper = (ResultSet res, int rowNumber)-> {
		Pizza pizza = new Pizza();
		
		String code = res.getString("reference");
		String nom = res.getString("libelle");
		BigDecimal prix = res.getBigDecimal("prix");
		String categorie = res.getString("categorie");
		

		pizza.setCode(code);
		pizza.setNom(nom);
		pizza.setPrix(prix.doubleValue());

		if (categorie != null) {
			pizza.setCategorie(CategoriePizza.valueOf(categorie));
		}
		return pizza;
		};
		
		public void saveAll(List<Pizza> pizzas) {
			pizzas.forEach(t -> {
				try {
					save(t);
				} catch (PizzeriaException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	
		}
	
		




	public List<Pizza> finAll() throws IOException, SQLException {
		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, rowmapper);
	}

	public void save(Pizza newPizza) throws PizzeriaException, IOException, SQLException {
		String sql = "INSERT INTO pizza ( reference, libelle, prix , url_image,  categorie) VALUES (?, ? , ? , ?, ? )";
		this.jdbcTemplate.update(sql, newPizza.getCode(), newPizza.getNom(),newPizza.getPrix(),newPizza.getNom() + ".jpg",newPizza.getCategorie().toString());
		
	}

	public void update(String newcode, Pizza pizza, String anciencode) throws IOException, SQLException {
		String sql = " UPDATE pizza SET  reference =?, libelle= ?, prix=? , url_image= ?,  categorie= ? WHERE reference =?";
		this.jdbcTemplate.update(sql, pizza.getCode(),  pizza.getNom(), pizza.getPrix(),pizza.getNom() + ".jpg",pizza.getCategorie().toString(),anciencode);
		
	}

	public void delete(String code) throws IOException, SQLException {
		String sql = " DELETE FROM pizza WHERE reference= ?";
		this.jdbcTemplate.update(sql, code);
		
	}
	



}