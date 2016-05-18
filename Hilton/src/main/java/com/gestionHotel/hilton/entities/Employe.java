package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
*  @author Jean-Daniel
*  Nom projet : Hilton
*  Date : 02/05/2016
*  Package : com.gestionHotel.hilton.entities
*  Class : Employe
*  Version : 1
*  Ref-UML : 1
*  Sprint : 1
*  ref-UserStory : 
*  Association : null
*/

@Entity
@DiscriminatorValue("Employe")
public class Employe extends Personne implements Serializable{

	/**Association**/
	@OneToMany(mappedBy="employe",fetch=FetchType.EAGER)
	private List<Reservation> listResa;
	
	/**Constructeur**/
	public Employe() {
		super();
		this.type = "Employe";
	}

	public Employe(String nom, String prenom, String sexe,
			Date dateDeNaissance, String adresse) {
		super(nom, prenom, sexe, dateDeNaissance, adresse);
		this.type = "Employe";
	}

	/**Getter et setter**/
	public List<Reservation> getListResa() {
		return listResa;
	}

	public void setListResa(List<Reservation> listResa) {
		this.listResa = listResa;
	}

	
}
