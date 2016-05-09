package com.gestionHotel.hilton.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Personne;


@RestController
public class ClientService {
    
	@Autowired
	InterfMetierPersonne metier;
	
	@RequestMapping(value="/saveClient",method=RequestMethod.POST)
	public void addClient(@RequestBody Client c){
		metier.addPersonne(c);
	}
	@RequestMapping(value="/getClient",method=RequestMethod.GET)
	public List<Personne> getClient(){
		return metier.getAllPersonne();
	}
}
