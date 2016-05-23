package com.gestionHotel.hilton.Metier;

import com.gestionHotel.hilton.entities.Devis;

/**
 *  @author Jean-Daniel
 *  Nom projet : Hilton
 *  Date : 02/05/2016
 *  Package : com.gestionHotel.hilton.Metier
 *  Class : InterfMetierRevenu
 *  Version : 1
 *  Ref-UML : 1
 *  Sprint : 1
 *  ref-UserStory : 1
 *  Association : IpmlMetierRevenu
 */
public interface InterfMetierRevenu {

	/**Mettre tous les devis dans revenu d'un cout**/
	public void initListDevisOfRevenu();
	/**Ajouter un devis au revenu**/
	public void addDevisToRevenu(Devis d);
	/**Supprimer un devis au revenu**/
	public void removeDevisToRevenu(Long idDevis)throws Exception;
	/**Mettre a jour un devis au revenu**/
	public void updateDevisToRevenus(Devis d);
	
	/**Calcul le revenu total des reservation de l hotel**/
	public Double revenuTotalReservation()throws Exception;
	/**Calcul le revenu total des produit de l hotel**/
	public Double revenuTotalProduit()throws Exception;
	/**Calcul le revenu total de l hotel**/
	public Double revenuTotal()throws Exception;
	/**Calcul le revenu total des reservation durant une annee**/
	public Double revenuTotalReservationParAnnee( Integer Annee)throws Exception;
	/**Calcul le revenu total des produit durant une annee**/
	public Double revenuTotalProduitParAnnee( Integer Annee)throws Exception;
	/**Calcul le revenu total durant une annee**/
	public Double revenuTotalParAnnee( Integer Annee)throws Exception;
}
