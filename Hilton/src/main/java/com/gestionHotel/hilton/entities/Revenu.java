package com.gestionHotel.hilton.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.transaction.annotation.Transactional;

/**
 *  @author Jean-Daniel
 *  Nom projet : Hilton
 *  Date : 02/05/2016
 *  Package : com.gestionHotel.hilton.entities
 *  Class : Revenu
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 
 *  Association : Devis
 */

public class Revenu {

	/**Association**/
	private static List<Devis> listeDevis;

	
	/**Construceur**/
	public Revenu() {
		super();
	}


	
	/**Getter et setter**/
	public static List<Devis> getListeDevis() {
		return listeDevis;
	}
	public static void setListeDevis(List<Devis> listeDevis) {
		Revenu.listeDevis = listeDevis;
	}

	
	
	
}
