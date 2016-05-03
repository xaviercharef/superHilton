package com.gestionHotel.hilton.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Auteur:Loic Loichot
 * nom Projet:Team2be3
 *date:26/04/2016
 *Package:com.gestionhotel.hilton.entities
 *Class:Produit
 *version:1.
 
 * 
 * */
@Entity
public class Produit implements Serializable{
	/* Attribus */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	private String nomProduit;
	private Double prix;
	private String descriptif;
/* construtor*/
	public Produit(String nomProduit, Double prix, String descriptif) {
		super();
		this.nomProduit = nomProduit;
		this.prix = prix;
		this.descriptif = descriptif;
	}
public Produit() {
	super();
}
/* getter and setter */
public Long getIdProduit() {
	return idProduit;
}
public void setIdProduit(Long idProduit) {
	this.idProduit = idProduit;
}
public String getNomProduit() {
	return nomProduit;
}
public void setNomProduit(String nomProduit) {
	this.nomProduit = nomProduit;
}
public Double getPrix() {
	return prix;
}
public void setPrix(Double prix) {
	this.prix = prix;
}
public String getDescriptif() {
	return descriptif;
}
public void setDescriptif(String descriptif) {
	this.descriptif = descriptif;
}
	
	
}
