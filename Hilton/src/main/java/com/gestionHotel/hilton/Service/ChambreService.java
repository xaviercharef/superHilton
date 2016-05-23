package com.gestionHotel.hilton.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionHotel.hilton.Metier.InterfMetierChambre;
import com.gestionHotel.hilton.Metier.ReservationInterfMetier;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Reservation;

@RestController
public class ChambreService {
@Autowired
InterfMetierChambre chambre;

@Autowired
ReservationInterfMetier metierR;

  @RequestMapping(value="/addChambre",method=RequestMethod.POST)
public Long addChambre(@RequestBody Chambre c) {
	  return chambre.addChambre(c);
}
  @RequestMapping(value="/deleteChambre/{idChambre}",method=RequestMethod.DELETE)
  public void deleteChambre(@PathVariable Long idChambre) {
	  chambre.deleteChambre(idChambre);
	 }

  @RequestMapping(value="/updateChambre", method=RequestMethod.PUT)
	public void updateClient(Chambre c){
		chambre.updateChambre(c);
	}

  @RequestMapping(value="/getChambre",method=RequestMethod.GET)
	public List<Chambre> getChambre(){
		return chambre.getAllChambre();
	}
  @RequestMapping(value="/getDateDebut/{idReservation}",method=RequestMethod.GET)
  public Date getDatedebut(@PathVariable Long idReservation) throws Exception {
	 	  
	  Reservation r = metierR.getReservation(idReservation);
	  if(r==null)throw new Exception("id incorrect");
	  return r.getDateDebut();
	 	
	 }

  @RequestMapping(value="/getDateFin/{idReservation}",method=RequestMethod.GET)
	 public Date getDateFin(@PathVariable Long idReservation) throws Exception {
	  	Reservation r = metierR.getReservation(idReservation);
		if(r==null)throw new Exception("id incorrect");
		return r.getDateFin();
	 }
  
  
  
  
  
  
  @RequestMapping(value="/getListChambreLibre/{Date debut, Date fin}",method=RequestMethod.GET)// A VERIFIER
  public List<Chambre> getListChambreLibre(Date debut, Date fin) throws Exception {
	 /*	List<Chambre> chambLibre=new ArrayList<Chambre>();
	 	for(Chambre c:chambre.getAllChambre()){
	 		if(c.getListReservation().size()==0){
	 			chambLibre.add(c);
	 		}
	 		else{int i=0;
	 			for(Reservation r:c.getListReservation()){
	 			if(debut.getTime()>chambre.getDatedebut(r.getIdReservation()).getTime() & debut.getTime()<chambre.getDateFin(r.getIdReservation()).getTime()
	 					|| fin.getTime()>chambre.getDatedebut(r.getIdReservation()).getTime() & fin.getTime()<chambre.getDateFin(r.getIdReservation()).getTime()){
	 				i=1;
	 			}
	 			if(i==1) break;
	 			}
	 			if(i==0){
	 				chambLibre.add(c);
	 			}
	 		}
	 	}
	 	return chambLibre; */
	  List<Chambre> list= new ArrayList<Chambre>();
		list = chambre.getListChambreLibreSurPeriode(debut, fin);
		if(list == null)throw new Exception("id incorrect");
	  return list;
	
	 }


}