package com.gestionHotel.hilton.Metier;

import java.util.List;
import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Produit;
import com.gestionHotel.hilton.entities.Reservation;

public interface InterfMetierDevisProduit {

	public List<Produit> getListProduit(); /* obtient la liste de produit */
	public Produit getProduit(Long idProduit)throws Exception; /* obtient  le produit par id */
	public void addProduit(Produit p); /* ajoute un produit p */
	public void deleteProduit(Long idProduit); /* delete un produit */
	public List<Devis> getListDevis(); /* obtient la liste des devis*/
	public Devis getDevis(Long idDevis)throws Exception; /* obtient le devis avec l'id */
	public void addDevisReservationProduit(Devis d, Long idReservation, List<Long> listidProduit); /* ajoute une reservation avec ses associations */
	public void deleteDevis(Long idDevis); /* delete un Devis */
	public List<Produit> getListProduitParDevis(Long idDevis)throws Exception; /* obtient la liste des produit par devis*/
	public Reservation getReservationParDevis(Long idDevis)throws Exception; /* obtient le devis par réservation*/
	
	
	public Double coutReservationParDevis(Long idDevis)throws Exception;
	
	public Double coutProduitParDevis(Long idDevis)throws Exception;
	public Double coutProduittotal()throws Exception;
}


