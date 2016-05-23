package com.gestionHotel.hilton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierChambre;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Reservation;

@Controller
public class ControllerChambre {
	
	@Autowired
	private InterfMetierChambre metierCha;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping(value="/Chambre")
	public String pageChambre (Model model){
		model.addAttribute("allCha", metierCha.getAllChambre());
		return "Chambre";
	}
	
	@RequestMapping(value="/getChambre")
	public String getPersonne(Model model, Long id){
			try {
			model.addAttribute("allCha", metierCha.getChambre(id));
			} catch (Exception e){
				Chambre c = new Chambre();
				c.setException(e.getMessage());
				model.addAttribute("ExcepChambre", c);
			}
		return "Chambre";
	}
	
	@RequestMapping(value="/formAddChambre")
	public String formAddChambre (Model model){
		model.addAttribute("formAdd", true);
		return "Chambre";
	}
	
	@RequestMapping(value="/addChambre")	
	public String addClient(Model model, /*Long idChambre, */ Integer capacite, Double prix, String description) {
		Chambre c = new Chambre(capacite, prix, description);
		metierCha.addChambre(c);
		model.addAttribute("allCha", metierCha.getAllChambre());
		return "Chambre";
	}
	
	@RequestMapping(value="/delChambre")
	public String delClient(Model model, Long id){
		metierCha.deleteChambre(id);
		model.addAttribute("allCha", metierCha.getAllChambre());
		return "Chambre";
	}
	
	@RequestMapping(value="/getToUpdateChambre")				//Exception?
	public String getToUpdatePers(Model model, Long id){
		
		try {
			model.addAttribute("getUpdateCha", metierCha.getChambre(id));
		} catch (Exception e){
			Chambre c = new Chambre();
			c.setException(e.getMessage());
			model.addAttribute("ExcepChambre", c);
		}
		return "Chambre";
	}
	
	@RequestMapping(value="/updateChambre")
	public String addClient(Model model, Long idChambre, Integer capacite, Double prix, String description) {	//Exception?
		Chambre c= new Chambre();
		
		try {
			c = metierCha.getChambre(idChambre);
			c.setCapacite(capacite);
			c.setPrix(prix);
			c.setDescription(description);
			metierCha.updateChambre(c);
			model.addAttribute("allCha", metierCha.getAllChambre());
		} catch (Exception e) {
			Chambre exc= new Chambre();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		
		return "Chambre";
	}
	
	@RequestMapping (value="/listeChambreLibre")
	public String chambreLibre (Model model,String dateDebut, String dateFin) throws ParseException{
		Date dDebut = dateFormat.parse(dateDebut);
		Date dFin = dateFormat.parse(dateFin);
		List<Chambre> listChambreLibre= new ArrayList<Chambre>();
		try {
			listChambreLibre = metierCha.getListChambreLibreSurPeriode(dDebut, dFin);
			model.addAttribute("allCha", listChambreLibre);
		} catch (Exception e) {
			Chambre exc= new Chambre();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		
		return "Chambre";
	}
	
}
