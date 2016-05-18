package com.gestionHotel.hilton.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Personne;

/**
 *  @author Jean-Daniel
 *  Nom projet : Hilton
 *  Date : 02/05/2016
 *  Package : com.gestionHotel.hilton.DAO
 *  Class : IpmlDAOPersonne
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 1
 *  Association : InterfDAOPersonne
 */

public class IpmlDAOPersonne implements InterfDAOPersonne{

	@PersistenceContext
	EntityManager em;
	
	
	/**Ajouter une personne a la base**/
	@Override
	public void addPersonne(Personne p) {
		em.persist(p);
		
	}
	/**surchage version client**/
	public void addPersonne(Client p) {
		em.persist(p);
		
	}
	
	/**surchage version employe**/
	public void addPersonne(Employe p) {
		em.persist(p);
		
	}
	
	/**Supprimer une personne de la base avec son Id**/
	@Override
	public void deletePersonne(Long idPersonne) {
		Personne p = em.find(Personne.class, idPersonne);
		em.remove(p);
		
	}

	/**Mettre a jour une personne de la base avec son Id**/
	@Override
	public void updatePersonne(Personne p) {
		em.merge(p);
		
	}

	/**Obtenir une personne de la base avec son Id
	 * @throws Exception **/
	@Override
	public Personne getPersonne(Long idPersonne) throws Exception {
		Personne p = em.find(Personne.class, idPersonne);
		if (p==null) throw new Exception ("Personne introuvable");
		return p;
	}

	/**Obtenir toute les persone entre dans la bases**/
	@Override
	public List<Personne> getAllPersonne() {
		Query req = em.createQuery("SELECT p FROM Personne p");
		return req.getResultList();
	}
	
	/**Obtenir toute les clients entre dans la bases**/
	@Override
	public List<Personne>  getAllClient() {
		Query req = em.createQuery("SELECT p FROM Personne p WHERE p.type='Client' OR p.type='Adulte' OR p.type='Enfant' OR p.type='Bebe'");
		return  req.getResultList();
	}

	/**Obtenir toute les employes entre dans la bases**/
	@Override
	public List<Personne> getAllEmploye() {
		Query req=em.createQuery("SELECT p FROM Personne p WHERE p.type='Employe'");
		return req.getResultList();
	}
	
	
	/**Obtenir toute les personnes possédant dans leur nom ou prenom le mot cle tapez**/
	@Override
	public List<Personne> searchPersonne(String mc) {
		Query req = em.createQuery("FROM Personne p WHERE p.nom=:x OR p.prenom=:y");
		req.setParameter("x", "%"+mc+"%");
		req.setParameter("y", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public Long getIdPersonne(String nomPersonne) {
		Query req= em.createQuery("From Personne p where p.nom=:x");
		req.setParameter(1, nomPersonne);
		Personne p=(Personne) req.getResultList().get(0);
		return p.getIdPersonne();
	}

	

}
