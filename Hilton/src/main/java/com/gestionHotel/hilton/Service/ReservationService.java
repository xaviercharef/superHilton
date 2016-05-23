package com.gestionHotel.hilton.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionHotel.hilton.Metier.ReservationInterfMetier;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Reservation;

@RestController
public class ReservationService {
	@Autowired
	ReservationInterfMetier reservation ;
	
	
	 @RequestMapping(value="/addReservation",method=RequestMethod.POST)
	 public void addReservation(@RequestBody Reservation r) {
	 	   reservation.addReservation(r);
	 }
	 @RequestMapping(value="/addReservationParClientParEmploye/{Long idClient,Long idChambre,Reservation r, Long idEmploye}",method=RequestMethod.POST)
	 public void addReservationParClientParEmploye(@PathVariable Long idClient,Long idChambre,Reservation r, Long idEmploye){
			reservation.addReservationParClientParEmploye(idClient, idChambre, r, idEmploye);
			
		}
     @RequestMapping(value="/getListReservation",method=RequestMethod.GET)
	 public List<Reservation> getListReservation() {
			return reservation.getListReservation();
		}

     @RequestMapping(value="/suppReservation/{idResrvation}",method=RequestMethod.DELETE)
 	public void suppReservation(@PathVariable Long idReservation) {
 		reservation.suppReservation(idReservation);
 		
 	}
     @RequestMapping(value="/getListReservationParEmploye/{idEmploye}",method=RequestMethod.GET)
 	public List<Reservation> getReservationParEmploye(@PathVariable Long idEmploye) throws Exception {

			return reservation.getReservationParEmploye(idEmploye);
		
 	}

     @RequestMapping(value="/getListReservationParClient/{idClient}",method=RequestMethod.GET)
 	public List<Reservation> getReservationParClient(@PathVariable Long idClient) throws Exception {
 
			return reservation.getReservationParClient(idClient);
		
 	}

     @RequestMapping(value="/getListReservationParChambre/{idChambre}",method=RequestMethod.GET)
 	public List<Reservation> getReservationParChambre(@PathVariable Long idChambre) throws Exception {
 
			return reservation.getReservationParChambre(idChambre);
		
 	}

     @RequestMapping(value="/getEmployeParReservation/{idReservation}",method=RequestMethod.GET)
 	public Employe getEmployeParReservation(@PathVariable Long idReservation) {
 		try {
			return reservation.getEmployeParReservation(idReservation);
		} catch (Exception e) {
			Employe exc= new Employe();
			exc.setException(e.getMessage());
			return exc;
		}
 	}

     @RequestMapping(value="/getClientParReservation/{idReservation}",method=RequestMethod.GET)
 	public Client getClientParReservation(@PathVariable Long idReservation) {
 		try {
			return reservation.getClientParReservation(idReservation);
		} catch (Exception e) {
			Client exc= new Client();
			exc.setException(e.getMessage());
			return exc;
		}
 	}

     @RequestMapping(value="/getChambreParReservation/{idReservation}",method=RequestMethod.GET)
 	public List<Chambre> getChambresParReservation(@PathVariable Long idReservation) throws Exception {

			return reservation.getChambresParReservation(idReservation);
	
 	}

}