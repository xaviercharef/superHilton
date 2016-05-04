package com.gestionHotel.hilton.DAO;

import java.util.List;

import com.gestionHotel.hilton.entities.Personne;

/**
 *  @author Jean-Daniel
 *  Nom projet : Hilton
 *  Date : 02/05/2016
 *  Package : com.gestionHotel.hilton.DAO
 *  Class : InterfDAOPersonne
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 1
 *  Association : IpmlMetierPersonne
 */
public interface InterfDAOPersonne {
	
	/**Ajouter une personne a la base**/
	public void addPersonne(Personne p);
	
	/**Supprimer une personne de la base avec son Id**/
	public void deletePersonne (Long idPersonne);
	
	/**Mettre a jour une personne de la base avec son Id**/
	public void updatePersonne (Personne p);
	
	/**Obtenir une personne de la base avec son Id**/
	public Personne getPersonne (Long idPersonne);
	
	/**Obtenir toute les persone entre dans la bases**/
	public List<Personne> getAllPersonne ();
	
	/**Obtenir toute les personnes possédant dans leur nom ou prenom le mot cle tapez**/
	public List<Personne> searchPersonne (String mc);
}
