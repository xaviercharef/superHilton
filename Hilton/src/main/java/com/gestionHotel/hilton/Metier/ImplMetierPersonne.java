package com.gestionHotel.hilton.Metier;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.DAO.InterfDAOPersonne;
import com.gestionHotel.hilton.DAO.IpmlDAOPersonne;
import com.gestionHotel.hilton.entities.Personne;

/**
*  @author Jean-Daniel
*  Nom projet : Hilton
*  Date : 02/05/2016
*  Package : com.gestionHotel.hilton.Metier
*  Class : IpmlMetierPersonneInterfMetierPersonne
*  Version : 1
*  Ref-UML : 1
*  Sprint : 1
*  ref-UserStory : 1
*  Association : InterfMetierPersonne, IpmlDAOPersonne
*/

@Transactional
public class ImplMetierPersonne {

	/**Association**/
	InterfDAOPersonne dao = new IpmlDAOPersonne();
	
	/**Ajouter une personne a la base**/
	public void addPersonne(Personne p) {
		dao.addPersonne(p);;
	}

	/**Supprimer une personne de la base avec son Id**/
	public void deletePersonne(Long idPersonne) {
		dao.deletePersonne(idPersonne);
	}

	/**Mettre a jour une personne de la base avec son Id**/
	public void updatePersonne(Long idPersonne) {
		dao.updatePersonne(idPersonne);
	}

	/**Obtenir une personne de la base avec son Id**/
	public Personne getPersonne(Long idPersonne) {
		return dao.getPersonne(idPersonne);
	}

	/**Obtenir toute les personnes possédant dans leur nom ou prenom le mot cle tapez**/
	public List<Personne> searchPersonne(String mc) {
		return dao.searchPersonne(mc);
	}

}
