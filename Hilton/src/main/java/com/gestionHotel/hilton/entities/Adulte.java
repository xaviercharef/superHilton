package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
*  @author Jean-Daniel
*  Nom projet : Hilton
*  Date : 02/05/2016
*  Package : com.gestionHotel.hilton.entities
*  Class : Adulte
*  Version : 1
*  Ref-UML : 1
*  Sprint : 1
*  ref-UserStory : 
*  Association : null
*/

@Entity
@DiscriminatorValue("Client Adulte")
public class Adulte extends Client implements Serializable {

	public Adulte() {
		super();
		this.type = "Adulte";
	}

	public Adulte(String nom, String prenom, String sexe, Date dateDeNaissance,
			String adresse) {
		super(nom, prenom, sexe, dateDeNaissance, adresse);
		this.type = "Adulte";
	}

	
}
