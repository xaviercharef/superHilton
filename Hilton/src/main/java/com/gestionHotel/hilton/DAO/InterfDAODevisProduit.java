package com.gestionHotel.hilton.DAO;

import java.util.List;

import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Produit;
import com.gestionHotel.hilton.entities.Reservation;

public interface InterfDAODevisProduit {

public List<Produit> getListProduit(); /* obtient la liste de produit */
public Produit getProduit(Long idProduit); /* obtient  le produit par id */
public void addProduit(Produit p); /* ajoute un produit p */
public void deleteProduit(Long idProduit); /* delete un produit */
public List<Devis> getListDevis(); /* obtient la liste des devis*/
public Devis getDevis(Long idDevis); /* obtient le devis avec l'id */

public void deleteDevis(Long idDevis); /* delete un Devis */
public List<Produit> getListProduitParDevis(Long idDevis); /* obtient la liste des produit par devis*/
public Reservation getReservationParDevis(Long idDevis); /* obtient le devis par réservation*/
public void addDevisReservationProduit(Devis d, Long idReservation, List<Long> idProduit);/* ajoute une reservation avec ses associations */
}
