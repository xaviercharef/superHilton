package com.gestionHotel.hilton.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionHotel.hilton.Metier.InterfMetierDevisProduit;
import com.gestionHotel.hilton.Metier.InterfMetierRevenu;
import com.gestionHotel.hilton.entities.Devis;
import com.gestionHotel.hilton.entities.Facture;
import com.gestionHotel.hilton.entities.Revenu;

public class TestRevenu {

	private static ClassPathXmlApplicationContext context;
	private static InterfMetierRevenu metierRev;
	private static InterfMetierDevisProduit metierDev;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metierRev = (InterfMetierRevenu) context.getBean("metierRev");//Pas sure?
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testInitListDevisOfRevenu(){
		metierRev.initListDevisOfRevenu();
		List<Devis> liste = Revenu.getListeDevis();
		assertNotNull(liste.size());
	}
	
	@Test
	public void testAddDevisToRevenu() {
		Devis d = new Devis();
		metierRev.addDevisToRevenu(d);
		List<Devis> liste = Revenu.getListeDevis();
		assertNotNull(liste.size());
	}

	@Test
	public void testRemoveDevisToRevenu() {
		List<Devis> liste1 = Revenu.getListeDevis();
		metierRev.removeDevisToRevenu(1l);
		List<Devis> liste2 = Revenu.getListeDevis();
		assertTrue(liste1.size()==liste2.size()+1);
	}

	@Test
	public void testUpdateDevisToRevenus() {
		List<Devis> liste = Revenu.getListeDevis();
		Devis d = liste.get(1);
		d.setFacture(new Facture(new Date(), "CB"));
		assertTrue(d.getFacture().getTypePaiment()=="CB");
	}

	@Test
	public void testRevenuTotalReservation() {
		assertNotNull(metierRev.revenuTotalReservation());
		//fail("Not yet implemented");
	}

	@Test
	public void testRevenuTotalProduit() {
		assertNotNull(metierRev.revenuTotalProduit());
		//fail("Not yet implemented");
	}

	@Test
	public void testRevenuTotal() {
		assertNotNull(metierRev.revenuTotal());
		//fail("Not yet implemented");
	}

	@Test
	public void testRevenuTotalReservationParAnnee() {
		assertNotNull(metierRev.revenuTotalReservationParAnnee(2015));
		//fail("Not yet implemented");
	}

	@Test
	public void testRevenuTotalProduitParAnnee() {
		assertNotNull(metierRev.revenuTotalProduitParAnnee(2015));
		//fail("Not yet implemented");
	}

	@Test
	public void testRevenuTotalParAnnee() {
		assertNotNull(metierRev.revenuTotalParAnnee(2015));
		//fail("Not yet implemented");
	}

}
