package com.gestionHotel.hilton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Personne;

@Controller
public class ControllerPersonne {
	@Autowired
	private InterfMetierPersonne metierP;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping(value="/Personne")
	public String pagePersonne(Model model){
		model.addAttribute("allPers", metierP.getAllPersonne());
		return "Personne";
	}
	
	@RequestMapping(value="/typeOperation")
	public String typeOperation(Model model, String typeOperation){
		String type = typeOperation;
		if (type.equals("AffAll")){
			model.addAttribute("allPers", metierP.getAllPersonne());
		}
		else if (type.equals("AffClient")){
			model.addAttribute("allCli", metierP.getAllClient());
		}
		else if (type.equals("AffEmploye")){
			model.addAttribute("allEmpl", metierP.getAllEmploye());
		}
		model.addAttribute("typeOpe", type);
		return "Personne";
	}
	
	
	@RequestMapping(value="/searchClientEmploye")
	public String searchClientEmploye(Model model, String mc){
		try{
			model.addAttribute("allPers", metierP.searchPersonne(mc));
		} catch (Exception e){
			Personne p = new Client();
			p.setException(e.getMessage());
			model.addAttribute("ExcepPersonne", p);
		}
		return "Personne";
	}
	
	@RequestMapping(value="/getPersonne")
	public String getPersonne(Model model, Long id){
			try {
			model.addAttribute("getPers", metierP.getPersonne(id));
			} catch (Exception e){
				Personne p = new Client();
				p.setException(e.getMessage());
				model.addAttribute("ExcepPersonne", p);
			}
		return "Personne";
	}
	
	@RequestMapping(value="/addClient")									/**OK avec temporaltype**/
	public String addClient(Model model, String nom, String prenom, String sexe, String dateDeNaissance, /*Date dateDeNaissance,*/ String adresse, String tel, String mail) throws ParseException{
		Date dateNaissance = dateFormat.parse(dateDeNaissance);
		Client client = new Client(nom, prenom, sexe, dateNaissance, adresse);
		metierP.addPersonne(client);
		if(tel.length()>1){
			client.setTel(tel);
		}
		if(mail.length()>1){
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
	
	@RequestMapping(value="/updateClient")								/**OK avec temporaltype**/
	public String updateClient(Model model, Long id, String nom, String prenom, String sexe, String dateDeNaissance, /*Date dateDeNaissance,*/ String adresse, String tel, String mail) throws ParseException{
		try {Personne client = metierP.getPersonne(id);
		if(nom.length()>1){
			client.setNom(nom);
		}
		if(prenom.length()>1){
			client.setPrenom(prenom);
		}
		if(sexe.length()>1){
			client.setSexe(sexe);
		}
		if(dateDeNaissance.length()>0){		
			Date dateNaissance = dateFormat.parse(dateDeNaissance);
			client.setDateDeNaissance(dateNaissance);
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
		}catch (Exception e){
			Personne p = new Client();
			p.setException(e.getMessage());
			model.addAttribute("ExcepPersonne", p);
		}
		return "Personne";
	}
	
	@RequestMapping(value="/addEmploye")									/**OK avec temporaltype**/
	public String addEmploye(Model model, String nom, String prenom, String sexe, String dateDeNaissance, /*Date dateDeNaissance,*/ String adresse, String tel, String mail) throws ParseException{
		Date dateNaissance = dateFormat.parse(dateDeNaissance);
		Employe employe = new Employe(nom, prenom,sexe,dateNaissance,adresse);
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
	
	@RequestMapping(value="/updateEmploye")										/**OK avec temporaltype**/
	public String updateEmploye(Model model, Long id, String nom, String prenom, String sexe, String dateDeNaissance, /*Date dateDeNaissance,*/ String adresse, String tel, String mail) throws ParseException{
		
		try {
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
		if(dateDeNaissance.length()>0){		
			Date dateNaissance = dateFormat.parse(dateDeNaissance);
			employe.setDateDeNaissance(dateNaissance);
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
		} catch (Exception e){
			Personne p = new Employe();
			p.setException(e.getMessage());
			model.addAttribute("ExcepPersonne", p);
		}
		return "Personne";
	}
	
	@RequestMapping(value="/getToUpdatePers")
	public String getToUpdatePers(Model model, Long idPers){
		try {
		model.addAttribute("getUpdatePers", metierP.getPersonne(idPers));
		} catch (Exception e){
			Personne p = new Client();
			p.setException(e.getMessage());
			model.addAttribute("ExcepPersonne", p);
		}
		
		return "Personne";
	}
}
