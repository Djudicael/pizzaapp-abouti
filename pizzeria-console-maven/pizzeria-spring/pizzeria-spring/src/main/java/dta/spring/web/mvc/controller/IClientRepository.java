package dta.spring.web.mvc.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Client;

public interface IClientRepository  extends JpaRepository<Client, Integer>{

}
