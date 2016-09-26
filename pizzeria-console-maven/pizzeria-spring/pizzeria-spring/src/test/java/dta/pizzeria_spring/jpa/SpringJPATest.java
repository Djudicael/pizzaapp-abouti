package dta.pizzeria_spring.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.pizzeria_spring.repository.IPizzaRepository;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringJPAConfig.class)
public class SpringJPATest {
	
	@Autowired IPizzaRepository pizzaRepo;

    @Test
    public void test() {
        Pizza p = new  Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
        pizzaRepo.save(p);
        //pizzaRepo.save(p);
    }

	
	

}
