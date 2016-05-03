package com.gestionHotel.hilton.Metier;

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






import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.DAO.InterfDAOChambre;
import com.gestionHotel.hilton.entities.Chambre;

@Transactional
public class ImplMetierChambre implements InterfMetierChambre  {
private InterfDAOChambre daoChambre ;

 public void setDaoChambre(InterfDAOChambre daoChambre) {
 this.daoChambre = daoChambre;
}


 @Override
 public Long addChambre(Chambre c) {
  // TODO Auto-generated method stub
  return daoChambre.addChambre(c);
 }

 @Override
 public void deleteChambre(Long idChambre) {
  // TODO Auto-generated method stub
	 daoChambre.deleteChambre(idChambre);
 }

 @Override
 public void updateChambre(Chambre c) {
  // TODO Auto-generated method stub
	 daoChambre.updateChambre(c);
 }

 @Override
 public Chambre getChambre(Long idChambre) {
  // TODO Auto-generated method stub
  return daoChambre.getChambre(idChambre);
 }

 @Override
 public List<Chambre> ListChambre() {
  // TODO Auto-generated method stub
  return daoChambre.ListChambre();
 }

}