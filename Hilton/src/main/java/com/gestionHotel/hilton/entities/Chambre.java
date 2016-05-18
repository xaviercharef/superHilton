/*Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: Entities
 *Class: Chambre
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 *association: manytomany avec Reservation
 * 
 * */



package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table

public class Chambre implements Serializable {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long idChambre ;
   private Integer capacite ;
   private Double prix ;
   private String description ; 
   
   private String exception ;
   

@ManyToMany(mappedBy="listeChambre", fetch=FetchType.EAGER)
   List<Reservation> listReservation= new ArrayList<Reservation>();

   /** Constructeurs **/
public Chambre(Integer capacite, Double prix, String description) {
 super();
 this.capacite = capacite;
 this.prix = prix;
 this.description = description;
}
public Chambre() {
 super();
}


/** Getters et Setters **/


public List<Reservation> getListReservation() {
	return listReservation;
}
public void setListReservation(List<Reservation> listReservation) {
	this.listReservation = listReservation;
}
public Long getIdChambre() {
	 return idChambre;
	}
public void setIdChambre(Long idChambre) {
 this.idChambre = idChambre;
}
public Integer getCapacite() {
 return capacite;
}
public void setCapacite(Integer capacite) {
 this.capacite = capacite;
}
public Double getPrix() {
 return prix;
}
public void setPrix(Double prix) {
 this.prix = prix;
}
public String getDescription() {
 return description;
}
public void setDescription(String description) {
 this.description = description;
}
public String getException() {
	return exception;
}
public void setException(String exception) {
	this.exception = exception;
}

}