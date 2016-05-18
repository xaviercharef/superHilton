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
 public Chambre getChambre(Long idChambre) throws Exception{
  return daoChambre.getChambre(idChambre);
 }

 
 @Override
 public List<Chambre> getListChambreLibreSurPeriode(Date periodeDebut, Date periodeFin) throws Exception{
	 
	if( periodeDebut.getTime() < periodeFin.getTime() ) throw new Exception("Incorrect: La date de fin est plus petite que la date de debut");
	
 	List<Chambre> chamlib = new ArrayList<Chambre>();
 	for( Chambre c : daoChambre.ListChambre() ){
 		if( c.getListReservation().size() == 0 ){
 			chamlib.add(c);
 		}
 		else{
 			boolean reservDejaPresente=false;
 			for(Reservation r : c.getListReservation()){
 			if( ( ( r.getDateDebut().getTime() > periodeDebut.getTime() )
 					&& ( r.getDateDebut().getTime() < periodeFin.getTime() ) )
 				|| ( ( r.getDateFin().getTime() > periodeDebut.getTime() ) 
 					&& ( r.getDateFin().getTime() < periodeFin.getTime() ) ) 
 				|| ( ( r.getDateDebut().getTime() < periodeDebut.getTime() ) 
 					&& ( r.getDateFin().getTime() > periodeFin.getTime() ) ) ){
 				reservDejaPresente=true;
 			}
 			if(reservDejaPresente==true) break;
 			}
 			if(reservDejaPresente==false){
 				chamlib.add(c);
 			}
 		}
 	}
 	if(chamlib.isEmpty()) throw new Exception("Il n'y a pas de chambre disponible");
 	return chamlib; 
 }


@Override
public List<Chambre> getAllChambre() {
	return daoChambre.getAllChambre();
}
 
 

}