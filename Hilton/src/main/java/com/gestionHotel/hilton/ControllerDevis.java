package com.gestionHotel.hilton;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierDevisProduit;
import com.gestionHotel.hilton.Metier.ReservationInterfMetier;
import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Produit;
import com.gestionHotel.hilton.entities.Reservation;

@Controller
public class ControllerDevis {

	@Autowired
	InterfMetierDevisProduit metierDev;
	@Autowired
	ReservationInterfMetier metierReserv;
	
	@RequestMapping(value="/Devis")
	public String pageDevis(Model model){
		model.addAttribute("allDevis", metierDev.getListDevis());
		return "Devis";
	}
	
	@RequestMapping(value="/formAddDevis1")
	public String formAddDevis1(Model model){
		model.addAttribute("formAdd1",true);
		model.addAttribute("listResa", metierReserv.getListReservation());
		return "Devis";
	}
	
	@RequestMapping(value="/formAddDevis2")
	public String formAddDevis2(Model model, long idResa){
		Reservation r= new Reservation();
		List<Produit> listProduit = null;
		model.addAttribute("formAdd2",true);
		model.addAttribute("listProd", metierDev.getListProduit());
		model.addAttribute("listProdAchete", listProduit);
		try {
			r = metierReserv.getReservation(idResa);
			model.addAttribute("selectResa", r);
			
		} catch (Exception e) {
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		return "Devis";
	}
	
	@RequestMapping(value="/addProduitToList")
	public String addProduitToList (Model model, Long idProduit, List<Produit> listProduit, Long idResa){
		Produit p = metierDev.getProduit(idProduit);
		listProduit.add(p);
		Reservation r= new Reservation();
		model.addAttribute("formAdd2",true);
		model.addAttribute("listProd", metierDev.getListProduit());
		model.addAttribute("listProdAchete", listProduit);
		try {
			r = metierReserv.getReservation(idResa);
			model.addAttribute("selectResa", r);
		} catch (Exception e) {
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}
		return "Devis";
	}
		
	@RequestMapping(value="/addDevis")
	public String addDevis (Model model, Long idReservation, List<Produit> listidProduit){
		Devis d = new Devis();
		Reservation r;
		try {
			r = metierReserv.getReservation(idReservation);
			d.setReservation(r);
			for (Produit p : listidProduit){
			d.getTabProduit().add(p);
			}
			model.addAttribute("allDevis", metierDev.getListDevis());
		} catch (Exception e) {
			Reservation exc= new Reservation();
			exc.setException(e.getMessage());
			model.addAttribute("exc", exc);
		}

		return "Devis";
	}
	
	@RequestMapping(value="/delDevis")
	public String delDevis (Model model, Long idDevis){
		metierDev.deleteDevis(idDevis);
		model.addAttribute("allDevis", metierDev.getListDevis());
		
		return "Devis";
	}
	
	@RequestMapping(value="/afficherListProduit")
	public String afficherListProduit (Model model, Long idDevis){
		Devis d = metierDev.getDevis(idDevis);
		List<Produit> listProduit = d.getTabProduit();
		model.addAttribute("listProdOfResa", listProduit);
		model.addAttribute("allDevis", metierDev.getListDevis());
		return "Devis";
	}
	
	/*	
	public Double coutReservationParDevis(Long idDevis);
	
	public Double coutProduitParDevis(Long idDevis);
	public Double coutProduittotal();*/
	
	
}
