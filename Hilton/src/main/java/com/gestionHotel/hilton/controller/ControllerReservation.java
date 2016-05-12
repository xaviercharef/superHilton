package com.gestionHotel.hilton.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="/modifierReservation")
	public String modifierReservation(Model model,Long idReservation, Long idClient,Date dateDebut, Date dateFin, List<Long> listIdChambre, String etat, Long idEmploye){
		metierR.setReservation( idReservation, idClient,listIdChambre, dateDebut, dateFin, etat, idEmploye);
		model.addAttribute("allRes", metierR.getListReservation());
		return "Reservation";
	}
	
	@RequestMapping(value="/typeMC")
	public String enregistrerReservation(Model model,String  MC){
		String type = MC;
		model.addAttribute("typMC", type);
		model.addAttribute("allRes", metierR.getListReservation());
		return "Reservation";
	}
	
	@RequestMapping(value="/rechercherReservationParClient")
	public String rechercherReservationParClient(Model model,Long  idClient){
		model.addAttribute("allRes", metierR.getReservationParClient(idClient));
		return "Reservation";
	}
	
	@RequestMapping(value="/rechercherReservationParChambre")
	public String rechercherReservationParChambre(Model model,Long  idChambre){
		model.addAttribute("allRes", metierR.getReservationParChambre(idChambre));
		return "Reservation";
	}
	
	@RequestMapping(value="/rechercherReservationParEmploye")
	public String rechercherReservationParEmploye(Model model,Long  idEmploye){
		model.addAttribute("allRes", metierR.getReservationParEmploye(idEmploye));
		return "Reservation";
	}
}
