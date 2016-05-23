package com.gestionHotel.hilton.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionHotel.hilton.Metier.InterfMetierDevisProduit;
import com.gestionHotel.hilton.entities.Produit;

public class TestDevisProduit {

	private static ClassPathXmlApplicationContext context;
	private static InterfMetierDevisProduit metierD;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metierD = (InterfMetierDevisProduit) context.getBean("metierD");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testGetListProduit() {
		List<Produit> listProduit = metierD.getListProduit();
		assertNotNull(listProduit.size());
	}

	@Test
	public void testGetProduit() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddProduit() {
		Produit p = new Produit("TestNom", 70d,"TestDescriptif");
		metierD.addProduit(p);
		assertNotNull(p.getIdProduit());
	}

	@Test
	public void testDeleteProduit() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListDevis() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDevis() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDevisReservationProduit() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDevis() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListProduitParDevis() {
		fail("Not yet implemented");
	}

	@Test
	public void testCoutReservationParDevis() {
		fail("Not yet implemented");
	}

	@Test
	public void testCoutProduitParDevis() {
		fail("Not yet implemented");
	}

	@Test
	public void testCoutProduittotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReservationParDevis() {
		fail("Not yet implemented");
	}

}
