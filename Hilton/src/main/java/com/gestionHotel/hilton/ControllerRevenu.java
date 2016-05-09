package com.gestionHotel.hilton;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierRevenu;

@org.springframework.stereotype.Controller
public class ControllerRevenu {
	@Autowired
	InterfMetierRevenu metierRev;
	
	@RequestMapping(value="/Revenu")
	public String pagePersonne(Model model){
		return "Revenu";
	}
	
	@RequestMapping(value="/choixAction")
	public String choixAction(Model model, String typeTableRevenu){
		if (typeTableRevenu=="allRevenu"){
			model.addAttribute("revResa", metierRev.revenuTotalReservation());
			model.addAttribute("revProd", metierRev.revenuTotalProduit());		
			model.addAttribute("revTotal", metierRev.revenuTotal());
		}
		else if (typeTableRevenu=="revenuEnCours"){
			Integer annee = (int) ((int)new Date().getTime()/(1000*3600*24*365.25));
			model.addAttribute("revResa", metierRev.revenuTotalReservationParAnnee(annee));
			model.addAttribute("revProd", metierRev.revenuTotalProduitParAnnee(annee));		
			model.addAttribute("revTotal", metierRev.revenuTotalParAnnee(annee));
		}
		String type = typeTableRevenu;
		model.addAttribute("action", type);
		return "Revenu";
	}
	
	@RequestMapping(value="revenuParAnne")
	public String revenuParAnne(Model model, Integer annee){
		model.addAttribute("revResa", metierRev.revenuTotalReservationParAnnee(annee));
		model.addAttribute("revProd", metierRev.revenuTotalProduitParAnnee(annee));		
		model.addAttribute("revTotal", metierRev.revenuTotalParAnnee(annee));
		return "Revenu";
	}
}
