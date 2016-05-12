package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import org.springframework.format.annotation.DateTimeFormat;

/**
 *  @author Jean-Daniel
 *  Nom projet : Hilton
 *  Date : 02/05/2016
 *  Package : com.gestionHotel.hilton.entities
 *  Class : Personne
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 
 *  Association : null
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypePersonne",discriminatorType=DiscriminatorType.STRING)
public abstract class Personne implements Serializable {
	
	/**Attribut**/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long idPersonne;
	
	protected String nom;
	protected String prenom;
	protected String sexe;
	protected String type;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	protected Date dateDeNaissance;
	protected String adresse;
	protected String tel;
	protected String mail;
	
	
	/**Getter et Setter**/
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**Constructor**/
	public Personne(String nom, String prenom, String sexe,
			Date dateDeNaissance, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
	}
	
	public Personne() {
		super();
	}
	
	
	

}
