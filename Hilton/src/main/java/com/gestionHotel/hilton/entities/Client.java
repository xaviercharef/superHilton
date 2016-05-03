package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *  @author Jean-Daniel
 *  Nom projet : Hilton
 *  Date : 02/05/2016
 *  Package : com.gestionHotel.hilton.entities
 *  Class : Client
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 
 *  Association : Reservation
 */

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne implements Serializable {

	
	/**Association**/
	@OneToMany
	private List<Reservation> listResa;
	
	/**Constructor**/
	public Client() {
		super();
		this.type = "Client";
	}

	public Client(String nom, String prenom, String sexe, Date dateDeNaissance,
			String adresse) {
		super(nom, prenom, sexe, dateDeNaissance, adresse);
		this.type = "Client";
	}

	
	/**Getter et Setter**/
	public List<Reservation> getListResa() {
		return listResa;
	}
	public void setListResa(List<Reservation> listResa) {
		this.listResa = listResa;
	}
}
