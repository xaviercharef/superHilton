/**
 * 
 */
package com.gestionHotel.hilton.DAO;

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
* package com.gestionHotel.hilton.DAO
* classe reservationInterfDAO
* date: 02/05/2016
 */
public interface ReservationInterfDAO {

	public void addReservation(Reservation r);
	public void addReservationParClientParEmploye(Long idClient, Long idChambre,Reservation r,Long idEmploye);
	public List<Reservation> getListReservation();
	public Reservation getReservation(Long idReservation);
	public void suppReservation(Long idReservation);
	public List<Reservation> getReservationParEmploye(Long idEmploye);
	public List<Reservation> getReservationParClient(Long idClient);
	public List<Reservation> getReservationParChambre(Long idChambre);
	public Employe getEmployeParReservation(Long idReservation);
	public Client getClientParReservation(Long idReservation);
	public List<Chambre> getChambresParReservation(Long idReservation);
	public void setReservation(Long idReservation,Long idClient, List<Long> listIdChambre,Date debut,Date fin,String etat,Long idEmploye);
	
}
