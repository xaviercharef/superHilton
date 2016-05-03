package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**Auteur:Loic Loichot
 * nom Projet:superhilton
 *date:26/04/2016
 *Package:com.gestionHotel.hilton.entities
 *Class:Devis.
 *version:1.
 *association:List<Produit>, Facture, reservation
 * 
 * */
import javax.persistence.OneToOne;


@Entity
public class Devis implements Serializable{
	/*  Attribus  */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idDevis;
	@OneToOne
private Facture facture;
	@OneToMany
	@JoinColumn(name="idProduit")
	private List<Produit> tabProduit=new ArrayList<Produit>();
	@OneToOne 
	private Reservation reservation;
	/*  Constructeur*/
	public Devis() {
		super();
	}
	/* getter and setter  */
	public Long getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(Long idDevis) {
		this.idDevis = idDevis;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public List<Produit> getTabProduit() {
		return tabProduit;
	}
	public void setTabProduit(List<Produit> tabProduit) {
		this.tabProduit = tabProduit;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
}
