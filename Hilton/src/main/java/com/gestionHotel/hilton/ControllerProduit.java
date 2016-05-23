package com.gestionHotel.hilton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestionHotel.hilton.Metier.InterfMetierDevisProduit;
import com.gestionHotel.hilton.entities.Produit;

@Controller
public class ControllerProduit {

	@Autowired
	private InterfMetierDevisProduit metierPro;
	
	@RequestMapping(value="/Produit")
	public String pageProduit (Model model){
		model.addAttribute("allPro", metierPro.getListProduit());
		return "Produit";
	}
	
	@RequestMapping(value="/getProduit")
	public String getPersonne(Model model, Long id){
		model.addAttribute("allPro", metierPro.getProduit(id));
		return "Produit";
	}
	
	@RequestMapping(value="/formAddPro")
	public String formAddChambre (Model model){
		model.addAttribute("formPro", true);
		return "Produit";
	}
	
	@RequestMapping(value="/addProduit")	
	public String addClient(Model model, String nomProduit, Double prix, String descriptif) {
		Produit p = new Produit(nomProduit, prix, descriptif);
		metierPro.addProduit(p);
		/*model.addAttribute("allPro", metierPro.getListProduit());*/
		return "Produit";
	}
	
	@RequestMapping(value="/delProduit")
	public String delClient(Model model, Long id){
		metierPro.deleteProduit(id);
		model.addAttribute("allPro", metierPro.getListProduit());
		return "Produit";
	}
	
	@RequestMapping(value="/getToUpdateProduit")				//Exception?
	public String getToUpdatePers(Model model, Long id){
		model.addAttribute("getUpdatePro", metierPro.getProduit(id));
		/*try {
		} catch (Exception e){
			Chambre c = new Chambre();
			c.setException(e.getMessage());
			model.addAttribute("ExcepChambre", c);
		}*/
		return "Produit";
	}
	
	@RequestMapping(value="/updateProduit")
	public String addClient(Model model, Long idProduit, String nomProduit, Double prix, String descriptif) {	//Exception?
		Produit p = metierPro.getProduit(idProduit);
		p.setNomProduit(nomProduit);
		p.setPrix(prix);
		p.setDescriptif(descriptif);
		model.addAttribute("allPro", metierPro.getListProduit());
		return "Produit";
	}
}
