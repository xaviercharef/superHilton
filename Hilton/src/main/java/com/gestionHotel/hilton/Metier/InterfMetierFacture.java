package com.gestionHotel.hilton.Metier;

import java.util.List;

import com.gestionHotel.hilton.entities.Facture;

public interface InterfMetierFacture {
	 public void addFacture(Facture f);
     public void deleteFacture(Long idFacture);
     public void updateFacture(Facture f);
     public Facture getFacture(Long idFacture)throws Exception;
     public List<Facture> getListFacture();
}
