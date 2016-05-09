package com.gestionHotel.hilton;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Personne;

@org.springframework.stereotype.Controller
public class ControllerPersonne {
	@Autowired
	private InterfMetierPersonne metierP;
	
	@RequestMapping(value="/Personne")
	public String pagePersonne(Model model){
		model.addAttribute("allPers", metierP.getAllPersonne());
		return "Personne";
	}
	
	@RequestMapping(value="/typeOperation")
	public String typeOperation(Model model, String typeOperation){
		if (typeOperation=="AffAll"){
			model.addAttribute("allPers", metierP.getAllPersonne());
		}
		else if (typeOperation=="AffClient"){
			model.addAttribute("allCli", metierP.getAllClient());
		}
		else if (typeOperation=="AffEmploye"){
			model.addAttribute("allEmpl", metierP.getAllEmploye());
		}
		String type = typeOperation;
		model.addAttribute("typeOpe", type);
		return "Personne";
	}
	
	/*@RequestMapping(value="/typeOperation")
	public String affAll(Model model, String typeOperation){
		if (typeOperation=="AffAll"){
			model.addAttribute("allPers", metierP.getAllPersonne());
		}
		return "Personne";
	}
	
	@RequestMapping(value="/typeOperation")
	public String affClient(Model model, String typeOperation){
		if (typeOperation=="AffClient"){
			model.addAttribute("allCli", metierP.getAllClient());
		}
		return "Personne";
	}
	
	@RequestMapping(value="/typeOperation")
	public String affEmploye(Model model, String typeOperation){
		if (typeOperation=="AffEmploye"){
			model.addAttribute("allEmpl", metierP.getAllEmploye());
		}
		return "Personne";
	}*/
	
	@RequestMapping(value="/searchClientEmploye")
	public String searchClientEmploye(Model model, String mc){
			model.addAttribute("AffAll", metierP.searchPersonne(mc));
		return "Personne";
	}
	
	@RequestMapping(value="/getPersonne")
	public String getPersonne(Model model, Long id){
			model.addAttribute("AffAll", metierP.getPersonne(id));
		return "Personne";
	}
	
	@RequestMapping(value="/addClient")
	public String addClient(Model model, String nom, String prenom, String sexe, Date dateDeNaissance, String adresse, String tel, String mail){
		Client client = new Client(nom, prenom,sexe,dateDeNaissance,adresse);
		metierP.addPersonne(client);
		if(tel.length()>1){
			client.setTel(tel);
		}
		if(tel.length()>1){
			client.setMail(mail);
		}
		model.addAttribute("allCli", metierP.getAllClient());
		return "Personne";
	}
	
	@RequestMapping(value="/delClient")
	public String delClient(Model model, Long id){
		metierP.deletePersonne(id);
		model.addAttribute("allCli", metierP.getAllClient());
		return "Personne";
	}
	
	@RequestMapping(value="/updateClient")
	public String updateClient(Model model, Long id, String nom, String prenom, String sexe, Date dateDeNaissance, String adresse, String tel, String mail){
		Personne client = metierP.getPersonne(id);
		if(nom.length()>1){
			client.setNom(nom);
		}
		if(prenom.length()>1){
			client.setPrenom(prenom);
		}
		if(sexe.length()>1){
			client.setSexe(sexe);
		}
		if(dateDeNaissance.getTime()>1l){
			client.setDateDeNaissance(dateDeNaissance);
		}
		if(adresse.length()>1){
			client.setAdresse(adresse);
		}
		if(tel.length()>1){
			client.setTel(tel);
		}
		if(tel.length()>1){
			client.setMail(mail);
		}
		metierP.updatePersonne(client);
		model.addAttribute("allCli", metierP.getAllClient());
		return "Personne";
	}
	
	@RequestMapping(value="/addEmploye")
	public String addEmploye(Model model, String nom, String prenom, String sexe, Date dateDeNaissance, String adresse, String tel, String mail){
		Employe employe = new Employe(nom, prenom,sexe,dateDeNaissance,adresse);
		metierP.addPersonne(employe);
		if(tel.length()>1){
			employe.setTel(tel);
		}
		if(tel.length()>1){
			employe.setMail(mail);
		}
		model.addAttribute("allEmpl", metierP.getAllEmploye());
		return "Personne";
	}
	
	@RequestMapping(value="/delEmploye")
	public String delEmploye(Model model, Long id){
		metierP.deletePersonne(id);
		model.addAttribute("allEmpl", metierP.getAllEmploye());
		return "Personne";
	}
	
	@RequestMapping(value="/updateEmploye")
	public String updateEmploye(Model model, Long id, String nom, String prenom, String sexe, Date dateDeNaissance, String adresse, String tel, String mail){
		Personne employe = metierP.getPersonne(id);
		if(nom.length()>1){
			employe.setNom(nom);
		}
		if(prenom.length()>1){
			employe.setPrenom(prenom);
		}
		if(sexe.length()>1){
			employe.setSexe(sexe);
		}
		if(dateDeNaissance.getTime()>1l){
			employe.setDateDeNaissance(dateDeNaissance);
		}
		if(adresse.length()>1){
			employe.setAdresse(adresse);
		}
		if(tel.length()>1){
			employe.setTel(tel);
		}
		if(tel.length()>1){
			employe.setMail(mail);
		}
		metierP.updatePersonne(employe);
		model.addAttribute("allEmpl", metierP.getAllEmploye());
		return "Personne";
	}
	
}
