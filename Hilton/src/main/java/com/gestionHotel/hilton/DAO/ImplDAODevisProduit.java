package com.gestionHotel.hilton.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Produit;
import com.gestionHotel.hilton.entities.Reservation;

public class ImplDAODevisProduit implements InterfDAODevisProduit{

	@PersistenceContext
    private EntityManager em;
	
	
	@Override
	public List<Produit> getListProduit() {
		Query req=(Query) em.createQuery("from Produit");
		return req.getResultList();	
	}

	@Override
	public void addProduit(Produit p) {
		em.persist(p);
	}

	@Override
	public void deleteProduit(Long idProduit) {
		Produit p=em.find(Produit.class, idProduit);
		em.remove(p);
	}

	@Override
	public List<Devis> getListDevis() {
		Query req=(Query) em.createQuery("from Devis");
		return req.getResultList();
	}

	
	@Override
	public void addDevisReservationProduit(Devis d, Long idReservation, List<Long> listidProduit){
		Reservation r=em.find(Reservation.class, idReservation);
		for(Long idProduit:listidProduit){
			Produit p=em.find(Produit.class, idProduit);
			d.getTabProduit().add(p);
		}
		d.setReservation(r);
		em.persist(d);
	}

	@Override
	public void deleteDevis(Long idDevis) {
		Devis d=em.find(Devis.class, idDevis);
		em.remove(d);
		
	}

	@Override
	public List<Produit> getListProduitParDevis(Long idDevis) throws Exception{
		List<Produit> list= new ArrayList<Produit>();
		Query req=(Query) em.createQuery("select d.tabProduit from Devis d where d.idDevis = :x");
		req.setParameter("x", idDevis);
		list = req.getResultList();
		if (list.isEmpty()) throw new Exception ("Pas de produit trouvé");
		return list;
	}

	@Override
	public Produit getProduit(Long idProduit) throws Exception{
		Produit p=em.find(Produit.class,idProduit);
		if(p == null) throw new Exception("Pas de produit trouve");
		return p;	
	}

	@Override
	public Devis getDevis(Long idDevis) throws Exception{
		Devis d=em.find(Devis.class, idDevis);
		if(d == null) throw new Exception("Pas de devis trouve");
		return d;
	}

	@Override
	public Reservation getReservationParDevis(Long idDevis) throws Exception{
		Devis d=em.find(Devis.class, idDevis);
		Reservation r = d.getReservation();
		if(r == null) throw new Exception("Pas de reservation trouvee");
		return r;
	}
}