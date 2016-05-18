package com.gestionHotel.hilton.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierChambre;
import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.Metier.ReservationInterfMetier;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Reservation;

@org.springframework.stereotype.Controller
public class ControllerReservation {

	@Autowired
	private ReservationInterfMetier metierR;
	
	@Autowired
	private InterfMetierPersonne metierP;
	
	@Autowired
	private InterfMetierChambre metierCh;

	@RequestMapping(value="/")
	public String accueil(Model model){
		return "Reservation";
	}
	
	@RequestMapping(value="/Reservation")
	public String reservation(Model model){
		model.addAttribute("allClient",metierP.getAllClient());
		model.addAttribute("allEmploye",metierP.getAllEmploye());
		model.addAttribute("allRes", metierR.getListReservation());
		model.addAttribute("allCh", metierCh.getAllChambre());
		model.addAttribute("model", new Reservation());
		return "Reservation";
	}
	
	@RequestMapping(value="/enregistrerReservation")
	public String enregistrerReservation(Model model,Reservation r,Long idClient,Long idChambre, Long idEmploye){
		model.addAttribute("allClient", metierP.getAllClient());
		model.addAttribute("allEmploye",metierP.getAllEmploye());
		model.addAttribute("allCh", metierCh.getAllChambre());
	/*	Employe e=(Employe) metierP.getPersonne(idEmploye);
		Client c= (Client) metierP.getPersonne(idClient);
		Chambre ch=metierCh.getChambre(idChambre);*/
		metierR.addReservationParClientParEmploye(idClient, idChambre, r, idEmploye);
		model.addAttribute("allRes", metierR.getListReservation());
		/*Long idChambre= Long.parseLong(arg0)
		Reservation r = new Reservation();
		Long idClient=metierP.getIdPersonne(nomClient);
		Long idEmploye=metierP.getIdPersonne(nomEmploye);
		metierR.addReservationParClientParEmploye(idClient, idChambre, r, idEmploye);
		model.addAttribute("allRes", metierR.getListReservation());
		return "Reservation";*/
		return "Reservation";
	}
	
	@RequestMapping(value="/goToModifierReservation")
	public String goToModifierReservation(Model model,Long idReserv){
		try {
			model.addAttribute("allClient", metierP.getAllClient());
			model.addAttribute("allEmploye",metierP.getAllEmploye());
			model.addAttribute("allCh", metierCh.getAllChambre());
			model.addAttribute("ResaToUpdate", metierR.getReservation(idReserv));
		} catch (Exception e) {
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		return "Reservation";
	}
	

	
	@RequestMapping(value="/m")
	public String modifierReservation(@ModelAttribute("model") Reservation r, Model model, Long idReserv, Long idClient, Long idChambre, String etat, Long idEmploye) throws ParseException{
		/*SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sf.parse(dateDebut);
		Date d2 = sf.parse(dateFin);*/
		
		
		List<Long> listIdChambre=new ArrayList<Long>();
		List<Chambre> listChambreAnc=new ArrayList<Chambre>();
		try {
			Reservation reser = metierR.getReservation(idReserv);
			listChambreAnc= reser.getListeChambre();
			boolean present = false;
			for(Chambre c: reser.getListeChambre()){
				listIdChambre.add(c.getIdChambre());
			}
			for(Long id:listIdChambre){
			if(id==idChambre){
				present = true;
				}
			}
			if(present == false){
				listIdChambre.add(idChambre);
				}
			metierR.setReservation(idReserv, idClient,listIdChambre, r.getDateDebut(), r.getDateFin(), etat, idEmploye);
			
		} catch (Exception e) {
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		
		return "redirect:Reservation";
	}
	
	@RequestMapping(value="/typeMC")
	public String rechercherMotCleReservation(Model model,String  typeMC){
		model.addAttribute("allClient", metierP.getAllClient());
		model.addAttribute("allEmploye",metierP.getAllEmploye());
		model.addAttribute("allCh", metierCh.getAllChambre());
		String type = typeMC;
		model.addAttribute("typ", type);
		model.addAttribute("allRes", metierR.getListReservation());
		return "Reservation";
	}
	
	@RequestMapping(value="/rechercherReservationParClient")
	public String rechercherReservationParClient(Model model,Long  idClient) {
		try {
			model.addAttribute("allClient", metierP.getAllClient());
			model.addAttribute("allEmploye",metierP.getAllEmploye());
			model.addAttribute("allCh", metierCh.getAllChambre());
			model.addAttribute("allRes", metierR.getReservationParClient(idClient));
		} catch (Exception e) {
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		return "Reservation";
	}
	
	@RequestMapping(value="/rechercherReservationParChambre")
	public String rechercherReservationParChambre(Model model,Long  numeroChambre){
		try {
			model.addAttribute("allClient", metierP.getAllClient());
			model.addAttribute("allEmploye",metierP.getAllEmploye());
			model.addAttribute("allCh", metierCh.getAllChambre());
			model.addAttribute("allRes", metierR.getReservationParChambre(numeroChambre));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		return "Reservation";
	}
	
	@RequestMapping(value="/rechercherReservationParEmploye")
	public String rechercherReservationParEmploye(Model model,Long  idEmploye){
		try {
			model.addAttribute("allClient", metierP.getAllClient());
			model.addAttribute("allEmploye",metierP.getAllEmploye());
			model.addAttribute("allCh", metierCh.getAllChambre());
			model.addAttribute("allRes", metierR.getReservationParEmploye(idEmploye));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		return "Reservation";
	}
}
