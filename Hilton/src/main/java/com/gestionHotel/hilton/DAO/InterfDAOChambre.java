/**Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: DAO
 *iNTERFACE: 
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 
 * 
 * */

package com.gestionHotel.hilton.DAO;

import java.util.Date;
import java.util.List;

import com.gestionHotel.hilton.entities.Chambre;

public interface InterfDAOChambre {
    
    public Long addChambre(Chambre c);
    public void deleteChambre(Long idChambre);
    public void updateChambre(Chambre c);
    public Chambre getChambre(Long idChambre);
    public List<Chambre> ListChambre();
    public Date getDatedebut(Long idReservation);
    public Date getDateFin(Long idReservation);
        
    
}