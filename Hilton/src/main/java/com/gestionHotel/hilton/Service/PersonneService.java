package com.gestionHotel.hilton.Service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Personne;


@RestController
public class PersonneService {
	@Autowired
	InterfMetierPersonne metier;
	
	@RequestMapping(value="/saveClient",method=RequestMethod.POST)
	public void addClient(@RequestBody Client c){
		metier.addPersonne(c);
	}
	
	@RequestMapping(value="/saveEmploye",method=RequestMethod.POST)
	public void addEmploye(@RequestBody Employe e){
		metier.addPersonne(e);
	}
	
	@RequestMapping(value="/getPersonne",method=RequestMethod.GET)
	public List<Personne> getPersonne(){
		return metier.getAllPersonne();
	}
	
	@RequestMapping(value="/getClient",method=RequestMethod.GET)
	public List<Personne> getClient(){
		return metier.getAllClient();
	}
	
	@RequestMapping(value="/getEmploye", method=RequestMethod.GET)
	public List<Personne> getEmploye (){
		return metier.getAllEmploye();
	}
		
	@RequestMapping(value="/searchPersByName/{mc}", method=RequestMethod.GET) //A verifier (execption?)
	public List<Personne> searchClientEmploye(@PathVariable String mc){
		try{
			List<Personne> listResultat = metier.searchPersonne(mc);
			return listResultat;
		} catch (Exception e){
			List<Personne> listResultat = null;
			Personne p = new Client();
			p.setException(e.getMessage());
			return listResultat;
		}
	}
	
	@RequestMapping(value="/getPersonneById/{id}", method=RequestMethod.GET)	//A verifier (sans execption?)	
	public Personne getPersonne(@PathVariable Long id) throws Exception{
		return metier.getPersonne(id);
	}
		
	@RequestMapping(value="/delPersonne/{id}", method=RequestMethod.DELETE)
	public void delPersonne(@PathVariable Long id){
		metier.deletePersonne(id);
	}
	
	@RequestMapping(value="/updateClient", method=RequestMethod.PUT)
	public void updateClient(Client c){
		metier.updatePersonne(c);
	}
	
	@RequestMapping(value="/updateEmploye", method=RequestMethod.PUT)
	public void updateEmploye(Employe e){
		metier.updatePersonne(e);
	}
}