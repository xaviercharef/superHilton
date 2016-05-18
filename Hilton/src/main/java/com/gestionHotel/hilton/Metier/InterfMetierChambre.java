/**Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: METIER
 *iNTERFACE: 
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 
 * 
 * */
package com.gestionHotel.hilton.Metier;

import java.util.Date;
import java.util.List;

import com.gestionHotel.hilton.entities.Chambre;




public interface InterfMetierChambre {
       
     public Long addChambre(Chambre c);
     public void deleteChambre(Long idChambre);
     public void updateChambre(Chambre c);
     public Chambre getChambre(Long idChambre) throws Exception;
     public List<Chambre> getAllChambre();
     public List<Chambre> getListChambreLibreSurPeriode(Date début, Date Fin) throws Exception;

}
