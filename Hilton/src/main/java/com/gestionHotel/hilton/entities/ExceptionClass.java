package com.gestionHotel.hilton.entities;

public class ExceptionClass {

	private String chambreException;	
	private String devisException;		
	private String factureException;
	private String personneException;
	private String produitException;
	private String reservationException;
	private String revenuException;
	

	/**Construtor**/
	public ExceptionClass() {
		super();
	}
	
	/**Getter and setter**/
	public String getChambreException() {
		return chambreException;
	}
	public void setChambreException(String chambreException) {
		this.chambreException = chambreException;
	}
	public String getDevisException() {
		return devisException;
	}
	public void setDevisException(String devisException) {
		this.devisException = devisException;
	}
	public String getFactureException() {
		return factureException;
	}
	public void setFactureException(String factureException) {
		this.factureException = factureException;
	}
	public String getPersonneException() {
		return personneException;
	}
	public void setPersonneException(String personneException) {
		this.personneException = personneException;
	}
	public String getProduitException() {
		return produitException;
	}
	public void setProduitException(String produitException) {
		this.produitException = produitException;
	}
	public String getReservationException() {
		return reservationException;
	}
	public void setReservationException(String reservationException) {
		this.reservationException = reservationException;
	}
	public String getRevenuException() {
		return revenuException;
	}
	public void setRevenuException(String revenuException) {
		this.revenuException = revenuException;
	}	
}
