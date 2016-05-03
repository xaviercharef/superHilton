/**
 * 
 */
package com.gestionHotel.hilton.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Xavier Charef
 * projet Hilton
 * version 1
 * package com.gestionHotel.hilton.entities
 *associations: Employe employe, List<Client> listeClient, List<Chambre> listeChambre,
 */
@Entity
public class Reservation implements Serializable{

	
	/** Attributs **/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idReservation;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateDebut;
	private Date dateFin;
	private String etatReservation;
	
	
	/** Associations **/
	
	@ManyToMany
	@JoinTable(name="Reservation_Chambre",joinColumns=@JoinColumn(name="id_Reservation"), inverseJoinColumns=@JoinColumn(name="id_Chambre"))
	private List<Chambre> listeChambre= new ArrayList<Chambre>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_Resevation")
	private Client client;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_Reservation")
	private Employe employe;
	
	
	/** Constructors **/
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date dateDebut, Date dateFin, String etatReservation) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatReservation = etatReservation;
	}




	/** Getters and Setters **/
	


	public Long getIdReservation() {
		return idReservation;
	}




	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}




	public Date getDateDebut() {
		return dateDebut;
	}




	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}




	public Date getDateFin() {
		return dateFin;
	}




	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}




	public String getEtatReservation() {
		return etatReservation;
	}




	public void setEtatReservation(String etatReservation) {
		this.etatReservation = etatReservation;
	}




	public List<Chambre> getListeChambre() {
		return listeChambre;
	}




	public void setListeChambre(List<Chambre> listeChambre) {
		this.listeChambre = listeChambre;
	}




	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}




	public Employe getEmploye() {
		return employe;
	}




	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
}
