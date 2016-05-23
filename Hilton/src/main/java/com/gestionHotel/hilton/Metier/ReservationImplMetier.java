/**
 * 
 */
package com.gestionHotel.hilton.Metier;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.DAO.ReservationInterfDAO;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Reservation;
import com.gestionHotel.hilton.entities.Chambre;
/**
* @author Xavier Charef
* projet Hilton
* version 1
* package com.gestionHotel.hilton.Metier
* classe: ReservationImplMetier
* date: 02/05/2016
 */

@Transactional
public class ReservationImplMetier implements ReservationInterfMetier {

	private ReservationInterfDAO daoReserv;
	private final Logger LOG= Logger.getLogger("ReservationImplMetier");
	/** Setter **/

	public void setDaoReserv(ReservationInterfDAO daoReserv) {
		this.daoReserv = daoReserv;
		LOG.info("bean realise");
	}

	/** methodes **/
	
	@Override
	public void addReservation(Reservation r) {
		daoReserv.addReservation(r);
		
	}

	@Override
	public void addReservationParClientParEmploye(Long idClient,Long idChambre,Reservation r, Long idEmploye){
		daoReserv.addReservationParClientParEmploye(idClient, idChambre, r, idEmploye);
		
	}

	@Override
	public List<Reservation> getListReservation() {
		return daoReserv.getListReservation();
	}

	@Override
	public Reservation getReservation(Long idReservation) throws Exception {
		return daoReserv.getReservation(idReservation);
	}

	@Override
	public void suppReservation(Long idReservation){
		daoReserv.suppReservation(idReservation);
		
	}

	@Override
	public List<Reservation> getReservationParEmploye(Long idEmploye) throws Exception{
		return daoReserv.getReservationParEmploye(idEmploye);
	}

	@Override
	public List<Reservation> getReservationParClient(Long idClient) throws Exception{
		return daoReserv.getReservationParClient(idClient);
	}

	@Override
	public List<Reservation> getReservationParChambre(Long idChambre) throws Exception{
		return daoReserv.getReservationParChambre(idChambre);
	}

	@Override
	public Employe getEmployeParReservation(Long idReservation) throws Exception{
		return daoReserv.getEmployeParReservation(idReservation);
	}

	@Override
	public Client getClientParReservation(Long idReservation) throws Exception{
		return daoReserv.getClientParReservation(idReservation);
	}

	@Override
	public List<Chambre> getChambresParReservation(Long idReservation) throws Exception{
		return daoReserv.getChambresParReservation(idReservation);
	}

	@Override
	public void setReservation(Long idReservation, Long idClient,
			List<Long> listIdChambre, Date debut, Date fin, String etat,
			Long idEmploye) {
		daoReserv.setReservation(idReservation, idClient, listIdChambre, debut, fin, etat, idEmploye);
	}

}