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
import com.gestionHotel.hilton.entities.Personne;
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
	public List<Reservation> getListReservation() {
		Query query = em.createQuery("From Reservation r");
		return query.getResultList();
	}

	@Override
	public Reservation getReservation(Long idReservation) throws Exception {
		Reservation r = null;
		r = em.find(Reservation.class, idReservation);
		if(r == null) throw new Exception("Pas de reservations trouvees");
		return r;
	}

	@Override
	public void suppReservation(Long idReservation) {
		Reservation r=em.find(Reservation.class,idReservation);
		em.remove(r);
	}

	@Override
	public List<Reservation> getReservationParEmploye(Long idEmploye) throws Exception{
		List<Reservation> list= new ArrayList<Reservation>();
		Query query= em.createQuery("select r from Reservation r where r.employe.idPersonne= :x");
		query.setParameter("x", idEmploye);
		list= query.getResultList();
		if(list.isEmpty())throw new Exception("Pas de reservations trouvees");
		return list;
	}

	@Override
	public List<Reservation> getReservationParClient(Long idClient) throws Exception{
		List<Reservation> list= new ArrayList<Reservation>();
		Query query= em.createQuery("select r from Reservation r where r.client.idPersonne=:x");
		query.setParameter("x", idClient);
		list= query.getResultList();
		if(list.isEmpty())throw new Exception("Pas de reservations trouvees");
		return list;
	}

	@Override
	public List<Reservation> getReservationParChambre(Long idChambre) throws Exception{
		Chambre ch= em.find(Chambre.class, idChambre);
		List<Reservation> list= ch.getListReservation();
		if(list.size()==0)throw new Exception("Pas de reservations trouvees");
		return list;
	}

	@Override
	public Employe getEmployeParReservation(Long idReservation) throws Exception{
		Employe e=null;
		Reservation r= em.find(Reservation.class, idReservation);
		e=  r.getEmploye();
		if(e==null) throw new Exception("pas d'employe trouve");
		return e;
	}

	@Override
	public Client getClientParReservation(Long idReservation) throws Exception{
		Client c= null;
		Reservation r= em.find(Reservation.class, idReservation);
		c=  r.getClient();
		if(c==null) throw new Exception("pas de client trouve");
		return c;
	}

	@Override
	public List<Chambre> getChambresParReservation(Long idReservation) throws Exception{
		List<Chambre> list= new ArrayList<Chambre>();
		Reservation r= em.find(Reservation.class, idReservation);
		list= r.getListeChambre();
		if(list.isEmpty())throw new Exception("Pas de chambres trouvees");
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
		for(Chambre cha :list){
			cha.getListReservation().add(r);
		}
		
		r.setDateDebut(debut);
		r.setDateFin(fin);
		
		r.setEtatReservation(etat);
		
		em.persist(r);
		em.merge(c);
		em.merge(e);
	}

	@Override
	public void addReservationParClientParEmploye(Long idPersonne,Long idChambre,Reservation r, Long idEmploye) {
	
		Chambre ch=em.find(Chambre.class, idChambre);
		Client c=em.find(Client.class, idPersonne);
		Employe e=em.find(Employe.class, idEmploye);
		r.setClient(c);
		c.getListResa().add(r);
		
		r.setEmploye(e);
		e.getListResa().add(r);

		r.getListeChambre().add(ch);
		ch.getListReservation().add(r);
		
		em.persist(r);
		em.merge(c);
		em.merge(e);
		
	}

	
	

}
