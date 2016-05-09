/**Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: Entities
 *Class: Facture
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 *association: onetoone avec Devis
 * 
 * */



package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table
public class Facture implements Serializable {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long idFature ;
  private Date datePaiement ;
  private String typePaiment ;
  
  @OneToOne
  @PrimaryKeyJoinColumn(name="idDevis")
  private Devis devis ;
  
 /** getters et setters **/ 
public Long getIdFature() {
 return idFature;
}
public void setIdFature(Long idFature) {
 this.idFature = idFature;
}
public Date getDatePaiement() {
 return datePaiement;
}
public void setDatePaiement(Date datePaiement) {
 this.datePaiement = datePaiement;
}
public String getTypePaiment() {
 return typePaiment;
}
public void setTypePaiment(String typePaiment) {
 this.typePaiment = typePaiment;
}
public Devis getDevis() {
 return devis;
}
public void setDevis(Devis devis) {
 this.devis = devis;
}

/** Constructeurs**/
public Facture() {
 super();
}
public Facture(Date datePaiement, String typePaiment) {
 super();
 this.datePaiement = datePaiement;
 this.typePaiment = typePaiment;
}
}