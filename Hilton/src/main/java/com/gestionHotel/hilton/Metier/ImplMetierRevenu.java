package com.gestionHotel.hilton.Metier;

import com.gestionHotel.hilton.DAO.InterfDAODevisProduit;
import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Revenu;

public class ImplMetierRevenu implements InterfMetierRevenu{
	
	InterfDAODevisProduit daoRev;
	InterfMetierDevisProduit metierRev;
	
	
	/**Mettre tous les devis dans revenu d'un cout**/
	@Override
	public void initListDevisOfRevenu(){
		Revenu.setListeDevis(daoRev.getListDevis());
	}
	
	/**Ajouter un devis au revenu**/
	@Override
	public void addDevisToRevenu(Devis d) {
		Revenu.getListeDevis().add(d);
	}

	/**Supprimer un devis au revenu
	 * @throws Exception **/
	@Override
	public void removeDevisToRevenu(Long idDevis) throws Exception {
		Devis d = daoRev.getDevis(idDevis);
		Revenu.getListeDevis().remove(d);
	}

	/**Mettre a jour un devis au revenu**/
	@Override
	public void updateDevisToRevenus(Devis d) {
		for (Devis d1 : Revenu.getListeDevis()){
			if(d1.getIdDevis()==d.getIdDevis()){
				Revenu.getListeDevis().remove(d1);
				Revenu.getListeDevis().add(d);
			}
		}
	}

	
	/**Calcul le revenu total des reservation de l hotel
	 * @throws Exception **/
	@Override
	public Double revenuTotalReservation() throws Exception {
		Double revenu=0d;
		for(Devis d : Revenu.getListeDevis())
		{
			Long idDevis = d.getIdDevis();
			revenu=revenu+ metierRev.coutReservationParDevis(idDevis);
		}
		return revenu;
	}

	/**Calcul le revenu total des produit de l hotel
	 * @throws Exception **/
	@Override
	public Double revenuTotalProduit() throws Exception {
		Double revenu = 0d;
		for (Devis d : Revenu.getListeDevis()){
			Long idDevis = d.getIdDevis();
			revenu=revenu+metierRev.coutProduitParDevis(idDevis);
		}
		return revenu;
	}

	/**Calcul le revenu total de l hotel
	 * @throws Exception **/
	@Override
	public Double revenuTotal() throws Exception {
		Double revenu = revenuTotalProduit()+revenuTotalReservation();
		return revenu;
	}

	/**Calcul le revenu total des reservation durant une annee
	 * @throws Exception **/
	@Override
	public Double revenuTotalReservationParAnnee(Integer annee) throws Exception {
		Double revenu = 0d;
		for(Devis d : Revenu.getListeDevis()){
			if(d.getReservation().getDateDebut().getTime()> annee*1000*3600*24*365.25 && d.getReservation().getDateFin().getTime()< (annee+1)*1000*3600*24*365.25){
				Long idDevis = d.getIdDevis();
				revenu=revenu+ metierRev.coutReservationParDevis(idDevis);
			}
		}
		return revenu;
	}

	/**Calcul le revenu total des produit durant une annee
	 * @throws Exception **/
	@Override
	public Double revenuTotalProduitParAnnee(Integer annee) throws Exception {
		Double revenu = 0d;
		for(Devis d : Revenu.getListeDevis()){
			if(d.getReservation().getDateDebut().getTime()> annee*1000*3600*24*365.25 && d.getReservation().getDateFin().getTime()< (annee+1)*1000*3600*24*365.25){
				Long idDevis = d.getIdDevis();
				revenu=revenu+metierRev.coutProduitParDevis(idDevis);
			}
		}
		return revenu;
	}

	/**Calcul le revenu total durant une annee
	 * @throws Exception **/
	@Override
	public Double revenuTotalParAnnee(Integer annee) throws Exception {
		Double revenu = revenuTotalReservationParAnnee(annee)+ revenuTotalProduitParAnnee(annee);
		return revenu;
	}

	
	/**Getter et Setter**/
	public InterfDAODevisProduit getDaoRev() {
		return daoRev;
	}

	public void setDaoRev(InterfDAODevisProduit daoRev) {
		this.daoRev = daoRev;
	}

	public InterfMetierDevisProduit getMetierRev() {
		return metierRev;
	}

	public void setMetierRev(InterfMetierDevisProduit metierRev) {
		this.metierRev = metierRev;
	}

}
