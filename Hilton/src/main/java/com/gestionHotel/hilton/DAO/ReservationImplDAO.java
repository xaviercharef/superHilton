/**
 * 
 */
package com.gestionHotel.hilton.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import javax.persistence.Query;

import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Reservation;

/**
* @author Xavier Charef
* projet Hilton
* version 1
* package com.gestionHotel.hilton.DAO
* classe reservationImplDAO
* date: 02/05/2016
 */

public class ReservationImplDAO implements ReservationInterfDAO{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addReservation(Reservation r) {
		em.persist(r);
	}
	
	@Override
	public void addReservationParClientParEmploye(Long idClient,
			List<Long> listIdChambre, Date debut, Date fin, String etat,
			Long idEmploye) {
		Reservation r= new Reservation();
		Client c=em.find(Client.class, idClient);
		Employe e=em.find(Employe.class, idEmploye);
		List<Chambre> list= new ArrayList<Chambre>();
		for(Long l:listIdChambre){
			Chambre ch=em.find(Chambre.class, l);
			list.add(ch);
		}
		r.setClient(c);
		c.getListResa().add(r);
		r.setEmploye(e);
		e.getListResa().add(r);
		r.setListeChambre(list);
		for(Chambre cha :list){  cha.getListReservation().add(r);}
		r.setDateDebut(debut);
		r.setDateFin(fin);
		r.setEtatReservation(etat);
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public List<Reservation> getListReservation() {
		Query query = em.createQuery("From Reservation r");
		return query.getResultList();
	}

	@Override
	public Reservation getReservation(Long idReservation) {
		Reservation r=em.find(Reservation.class, idReservation);
		return r;
	}

	@Override
	public void suppReservation(Long idReservation) {
		Reservation r=em.find(Reservation.class,idReservation);
		em.remove(r);
	}

	@Override
	public List<Reservation> getReservationParEmploye(Long idEmploye) {
		Query query= em.createQuery("select r from Reservation r where r.employe.idEmploye=idEmploye");
		return query.getResultList();
	}

	@Override
	public List<Reservation> getReservationParClient(Long idClient) {
		Query query= em.createQuery("select r from Reservation r where r.client.idClient=idClient");
		return query.getResultList();
	}

	@Override
	public List<Reservation> getReservationParChambre(Long idChambre) {
		Chambre ch= em.find(Chambre.class, idChambre);
		List<Reservation> list= ch.getListReservation();
		return list;
	}

	@Override
	public Employe getEmployeParReservation(Long idReservation) {
		Reservation r= em.find(Reservation.class, idReservation);
		Employe e=  r.getEmploye();
		return e;
	}

	@Override
	public Client getClientParReservation(Long idReservation) {
		Reservation r= em.find(Reservation.class, idReservation);
		Client c=  r.getClient();
		return c;
	}

	@Override
	public List<Chambre> getChambresParReservation(Long idReservation) {
		Reservation r= em.find(Reservation.class, idReservation);
		List<Chambre> list= r.getListeChambre();
		return list;
	}

	@Override
	public void setReservation(Long idReservation,Long idClient, List<Long> listIdChambre,Date debut,Date fin,String etat,Long idEmploye) {
		Reservation r= em.find(Reservation.class, idReservation);
		Client c=em.find(Client.class, idClient);
		Employe e=em.find(Employe.class, idEmploye);
		List<Chambre> list= new ArrayList<Chambre>();
		for(Long l:listIdChambre){
			Chambre ch=em.find(Chambre.class, l);
			list.add(ch);
		}
		r.setClient(c);
		c.getListResa().add(r);
		r.setEmploye(e);
		e.getListResa().add(r);
		r.setListeChambre(list);
		for(Chambre cha :list){  cha.getListReservation().add(r);}
		r.setDateDebut(debut);
		r.setDateFin(fin);
	}

	
	

}
