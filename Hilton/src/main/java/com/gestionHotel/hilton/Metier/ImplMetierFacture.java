package com.gestionHotel.hilton.Metier;

import java.util.List;

import com.gestionHotel.hilton.DAO.InterfDAOFacture;
import com.gestionHotel.hilton.entities.Facture;

public class ImplMetierFacture implements InterfMetierFacture{

	private InterfDAOFacture daoFac ;
	 public void setDaoFac(InterfDAOFacture daoFac) {
	 this.daoFac = daoFac;
	}

	 @Override
	 public void addFacture(Facture f) {
		 daoFac.addFacture(f);
	 }

	 @Override
	 public void deleteFacture(Long idFacture) {
		 daoFac.deleteFacture(idFacture);
	 }

	 @Override
	 public void updateFacture(Facture f) {
		 daoFac.updateFacture(f);
	 }

	 @Override
	 public Facture getFacture(Long idFacture) {
	  return daoFac.getFature(idFacture);
	 }

	 @Override
	 public List<Facture> getListFacture() {
	  return daoFac.listFacture();
	 }

}
