package dta.spring.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dta.spring.web.PizzeriaSpringWebConfig;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.CreditException;
import fr.pizzeria.model.DebitException;

@CrossOrigin
@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired private IClientRepository clientRepo;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Client> clientList() {
		return clientRepo.findAll();
	}
	
	@RequestMapping(value="/{id}/solde", method = RequestMethod.POST)
	public AfterOperation clientsolde(@PathVariable("id") Integer id, @RequestBody ClientSolde money)  {
		double solde = money.getSolde();
		AfterOperation ope = new AfterOperation();
		Client client = clientRepo.findOne(id);
		
		
		try {
			if(money.getTypedOperation().equals(Operation.CREDIT)){
				client.crediterCompte(solde);
				clientRepo.save(client);
				ope.setSucess(true);
				ope.setMontant(client.getSolde());
			}else{
				client.debiterCompte(solde);
				clientRepo.save(client);
				ope.setSucess(true);
				ope.setMontant(client.getSolde());
				
			}
			
		} catch (DebitException | CreditException e ) {
			ope.setSucess(false);
			ope.setMsg("debit impossible");
		}
		
		return ope;
		
		
       
	
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Client client(@PathVariable("id") Integer id, @RequestBody Client aClient)  {
		Client clientModif = clientRepo.findOne(id);
		aClient.setId(clientModif.getId());
		clientRepo.save(aClient);
		
		return aClient;
		
		
       
	
	}

}
