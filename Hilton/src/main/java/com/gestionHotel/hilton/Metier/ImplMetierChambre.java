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






import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.gestionHotel.hilton.DAO.InterfDAOChambre;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Reservation;

@Transactional
public class ImplMetierChambre implements InterfMetierChambre  {
	
private InterfDAOChambre daoChambre ;
private final Logger LOG=Logger.getLogger("ImplMetierChambre");

/**Setter**/
 public void setDaoChambre(InterfDAOChambre daoChambre) {
 this.daoChambre = daoChambre;
 LOG.info("bean daoChambre realise");
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
 
 @Override
 public Date getDatedebut(Long idReservation) {
 	// TODO Auto-generated method stub
 	return daoChambre.getDatedebut(idReservation);
 }

 @Override
 public Date getDateFin(Long idReservation) {
 	// TODO Auto-generated method stub
 	return daoChambre.getDateFin(idReservation);
 }

 @Override
 public List<Chambre> getListChambreLibre(Date debut, Date fin) {
 	List<Chambre> chamli=new ArrayList<Chambre>();
 	for(Chambre c:daoChambre.ListChambre()){
 		if(c.getListReservation().size()==0){
 			chamli.add(c);
 		}
 		else{int i=0;
 			for(Reservation r:c.getListReservation()){
 			if(debut.getTime()>daoChambre.getDatedebut(r.getIdReservation()).getTime() & debut.getTime()<daoChambre.getDateFin(r.getIdReservation()).getTime()
 					|| fin.getTime()>daoChambre.getDatedebut(r.getIdReservation()).getTime() & fin.getTime()<daoChambre.getDateFin(r.getIdReservation()).getTime()){
 				i=1;
 			}
 			if(i==1) break;
 			}
 			if(i==0){
 				chamli.add(c);
 			}
 		}
 	}
 	return chamli; 
 }


@Override
public List<Chambre> getAllChambre() {
	return daoChambre.getAllChambre();
}
 
 

}