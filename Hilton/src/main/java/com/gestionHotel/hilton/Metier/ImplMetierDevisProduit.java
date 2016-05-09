package com.gestionHotel.hilton.Metier;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.DAO.InterfDAODevisProduit;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Produit;
import com.gestionHotel.hilton.entities.Reservation;


@Transactional
public class ImplMetierDevisProduit implements InterfMetierDevisProduit {
	private final Logger LOG=Logger.getLogger("ImplMetierDevisProduit");
	private InterfDAODevisProduit daoDev;
	
	public void setDaoDev(InterfDAODevisProduit daoDev) {
		this.daoDev = daoDev;
		LOG.info("daoDev MetierDevisProduit injected");
	}

	@Override
	public List<Produit> getListProduit() {
		// TODO Auto-generated method stub
		return daoDev.getListProduit();
	}

	@Override
	public Produit getProduit(Long idProduit) {
		// TODO Auto-generated method stub
		return daoDev.getProduit(idProduit);
	}

	@Override
	public void addProduit(Produit p) {
		daoDev.addProduit(p);

	}

	@Override
	public void deleteProduit(Long idProduit) {
		daoDev.deleteProduit(idProduit);

	}

	@Override
	public List<Devis> getListDevis() {
		
		return daoDev.getListDevis();
	}

	@Override
	public Devis getDevis(Long idDevis) {
		
		return daoDev.getDevis(idDevis);
	}

	@Override
	public void addDevisReservationProduit(Devis d, Long idReservation, List<Long> listidProduit) {
		daoDev.addDevisReservationProduit(d, idReservation, listidProduit);

	}

	@Override
	public void deleteDevis(Long idDevis) {
		daoDev.deleteDevis(idDevis);
	}

	@Override
	public List<Produit> getListProduitParDevis(Long idDevis) {
		
		return daoDev.getListProduitParDevis(idDevis);
	}

	@Override
	public Double coutReservationParDevis(Long idDevis) {
		Reservation r=daoDev.getReservationParDevis(idDevis);
		Double cout=0.d;   /* ************************************* */
		for(Chambre c: r.getListeChambre()){
			cout=cout+c.getPrix()*(r.getDateFin().getTime()-r.getDateDebut().getTime())/(24*3600*1000);
		}
		
		return cout;
	}

	

	@Override
	public Double coutProduitParDevis(Long idDevis) {
		List<Produit> tabp=daoDev.getListProduitParDevis(idDevis);
		Double cout=0.d;
		for(Produit p:tabp){
			cout=cout+p.getPrix();
		}
		return cout;
	}

	@Override
	public Double coutProduittotal() {
		List<Produit> tabp=daoDev.getListProduit();
		Double cout=0.d;
		for(Produit p:tabp){
			cout=cout+p.getPrix();
		}
		return cout;
	}

	@Override
	public Reservation getReservationParDevis(Long idDevis) {
		// TODO Auto-generated method stub
		return daoDev.getReservationParDevis(idDevis);
	}

}
