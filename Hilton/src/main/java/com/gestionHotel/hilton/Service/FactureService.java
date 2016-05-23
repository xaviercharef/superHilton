package com.gestionHotel.hilton.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestionHotel.hilton.Metier.InterfMetierFacture;
import com.gestionHotel.hilton.entities.Facture;
@RestController
public class FactureService {
	@Autowired
	InterfMetierFacture facture;

	  @RequestMapping(value="/addFacture",method=RequestMethod.POST)
	public void addFacture(@RequestBody Facture f) {
		  facture.addFacture(f);;
	}
	  @RequestMapping(value="/deleteFacture/{idFacture}",method=RequestMethod.DELETE)
	  public void delete(@PathVariable Long idFacture) {
		  facture.deleteFacture(idFacture);
		 }

	  @RequestMapping(value="/updateFacture", method=RequestMethod.PUT)
		public void updateFacture(Facture f){
			facture.addFacture(f);
		}
      @RequestMapping(value="/getListFacture",method=RequestMethod.GET)
	  public List<Facture> getListFacture() {
		  return facture.getListFacture();
		 }
      @RequestMapping(value="/getFature,{idFacture}",method=RequestMethod.GET)
      public Facture getFacture(@PathVariable Long idFacture) {
    	  return facture.getFacture(idFacture);
}
}
