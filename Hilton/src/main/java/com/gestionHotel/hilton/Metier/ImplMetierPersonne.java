package com.gestionHotel.hilton.Metier;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.DAO.InterfDAOPersonne;
import com.gestionHotel.hilton.DAO.IpmlDAOPersonne;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
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
public class ImplMetierPersonne implements InterfMetierPersonne{

	/**Association**/
	InterfDAOPersonne daoPers = new IpmlDAOPersonne();
	private final Logger LOG=Logger.getLogger("ImplMetierPersonne");
	
	/**Ajouter une personne a la base**/
	@Override
	public void addPersonne(Personne p) {
		daoPers.addPersonne(p);;
	}

	/**Supprimer une personne de la base avec son Id**/
	@Override
	public void deletePersonne(Long idPersonne) {
		daoPers.deletePersonne(idPersonne);
	}

	/**Mettre a jour une personne de la base avec son Id**/
	@Override
	public void updatePersonne(Personne p) {
		daoPers.updatePersonne(p);
	}

	/**Obtenir une personne de la base avec son Id
	 * @throws Exception **/
	@Override
	public Personne getPersonne(Long idPersonne) throws Exception {
		return daoPers.getPersonne(idPersonne);
	}

	/**Obtenir toute les persone entre dans la bases**/
	@Override
	public List<Personne> getAllPersonne (){
		return daoPers.getAllPersonne();
		
	}
	
	/**Obtenir toute les clients entre dans la bases**/
	@Override
	public List<Personne> getAllClient() {
		return daoPers.getAllClient();
	}

	/**Obtenir toute les employes entre dans la bases**/
	@Override
	public List<Personne> getAllEmploye() {
		return daoPers.getAllEmploye();
	}
	
	/**Obtenir toute les personnes possédant dans leur nom ou prenom le mot cle tapez
	 * @throws Exception **/
	@Override
	public List<Personne> searchPersonne(String mc) throws Exception {
		return daoPers.searchPersonne(mc);
	}

	
	
	/**Getter et Setter**/
	public InterfDAOPersonne getDaoPers() {
		return daoPers;
	}
	public void setDaoPers(InterfDAOPersonne daoPers) {
		this.daoPers = daoPers;
		LOG.info("daoPers realise");
	}

	@Override
	public Long getIdPersonne(String nomPersonne) throws Exception {
		return daoPers.getIdPersonne(nomPersonne);
	}

	/**surchage version client**/
	@Override
	public void addPersonne(Client p) {
		daoPers.addPersonne(p);	
	}
	
	/**surchage version employe**/
	@Override
	public void addPersonne(Employe p) {
		daoPers.addPersonne(p);
		}
	

}
