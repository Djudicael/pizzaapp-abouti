package dta.pizzeria_spring;

import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
public class StockagePizzaParLotSpringJdbc {
	
	@Autowired StockagePizzaSpringJDBC stockagePizzaSpringJdbc;
	@Transactional
	public void insererParLot(List<Pizza>pizzas){
		
		ListUtils.partition(pizzas, 3).forEach(stockagePizzaSpringJdbc::saveAll);
		
	}
	
	
	
	

}
