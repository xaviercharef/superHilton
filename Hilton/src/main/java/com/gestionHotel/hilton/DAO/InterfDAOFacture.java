package com.gestionHotel.hilton.DAO;

/**Auteur: Aghiles Rahli
 * nom Projet: Projet01-groupe02
 *date : 03/05/2016
 *Package: DAO
 *iNTERFACE: InterfDAOFacture
 *version:1.0
 *ref-UML: Groupe
 *sprint:1
 *ref-userStories: 4
 
 * 
 * */
import java.util.List;

import com.gestionHotel.hilton.entities.Facture;

public interface InterfDAOFacture {

	public Long addFacture(Facture f);
    public void deleteFacture(Long idFacture);
    public void updateFacture(Facture f);
    public Facture getFature(Long idFacture);
    public List<Facture> listFacture();
}
