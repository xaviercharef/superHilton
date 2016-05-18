package com.gestionHotel.hilton.Metier;

import java.util.Date;
import java.util.List;

import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Reservation;

/**
* @author Xavier Charef
* projet Hilton
* version 1
* package com.gestionHotel.hilton.Metier
* classe: ReservationInterfMetier
* date: 02/05/2016
 */
public interface ReservationInterfMetier {
	public void addReservation(Reservation r);
	public void addReservationParClientParEmploye(Long idClient,Long idChambre,Reservation r, Long idEmploye);
	public List<Reservation> getListReservation();
	public Reservation getReservation(Long idReservation) throws Exception;
	public void suppReservation(Long idReservation);
	public List<Reservation> getReservationParEmploye(Long idEmploye) throws Exception;
	public List<Reservation> getReservationParClient(Long idClient) throws Exception;
	public List<Reservation> getReservationParChambre(Long idChambre) throws Exception;
	public Employe getEmployeParReservation(Long idReservation) throws Exception;
	public Client getClientParReservation(Long idReservation) throws Exception;
	public List<Chambre> getChambresParReservation(Long idReservation) throws Exception;
	public void setReservation(Long idReservation,Long idClient, List<Long> listIdChambre,Date debut,Date fin,String etat,Long idEmploye);
	
}
