/**Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: DAO
 *iMPLEMENTATION: 
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 
 * 
 * */

package com.gestionHotel.hilton.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Facture;
import com.gestionHotel.hilton.entities.Reservation;


public class ImplDAOChambre implements InterfDAOChambre{
@PersistenceContext
private EntityManager em ;

 @Override
 public Long addChambre(Chambre c) {
  em.persist(c);
  return c.getIdChambre();
 }

 @Override
 public void deleteChambre(Long idChambre) {
  Chambre c = em.find(Chambre.class, idChambre);
  em.remove(c);
  
 }

 @Override
 public void updateChambre(Chambre c) {
  em.merge(c);
  
 }

 @Override
 public Chambre getChambre(Long idChambre) {
  
  return em.find(Chambre.class, idChambre);
 }

 @Override
 public List<Chambre> ListChambre() {
  Query req =em.createQuery("Select c from Chambre c ");
  return req.getResultList();
 }
 
 @Override
 public Date getDatedebut(Long idReservation) {
 	Reservation r=em.find(Reservation.class, idReservation);
 	return r.getDateDebut();
 }

 @Override
 public Date getDateFin(Long idReservation) {
 	Reservation r=em.find(Reservation.class, idReservation);
 	return r.getDateFin();
 }

@Override
public List<Chambre> getAllChambre() {
	Query req =em.createQuery("from Chambre c");
	return req.getResultList();
}

}