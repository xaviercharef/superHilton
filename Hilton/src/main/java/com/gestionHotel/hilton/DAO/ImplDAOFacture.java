/**Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: DAO
 *iNTERFACE: InterfDAOFacture
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 
 * 
 * */
package com.gestionHotel.hilton.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.entities.Facture;

@Transactional
public class ImplDAOFacture implements InterfDAOFacture{
	@PersistenceContext
	private EntityManager em ;

	
	
	
	@Override
	 public Long addFacture(Facture f) {
	  em.persist(f);
	  return f.getIdFature();
	 }

	 @Override
	 public void deleteFacture(Long idFacture) {
	  Facture f = em.find(Facture.class, idFacture);
	  em.remove(f);
	  
	 }

	 @Override
	 public void updateFacture(Facture f) {
	  em.merge(f);
	  
	 }

	 @Override
	 public Facture getFature(Long idFacture) {
	  // TODO Auto-generated method stub
	  return em.find(Facture.class, idFacture) ;
	 }

	 @Override
	 public List<Facture> listFacture() {
	  Query req =em.createQuery("Select f from Facture f ");
	  return req.getResultList();
	 }
	
	
}
