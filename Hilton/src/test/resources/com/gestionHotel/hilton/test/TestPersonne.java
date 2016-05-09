package com.gestionHotel.hilton.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Personne;

public class TestPersonne {

	private static ClassPathXmlApplicationContext context;
	private static InterfMetierPersonne metierP;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metierP = (InterfMetierPersonne) context.getBean("metierP");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddPersonne() {
		Personne p = new Client("TestNom","TestPrenom", "TestSexe", new Date(), "TestAdresse");
		metierP.addPersonne(p);
		assertNotNull(p.getIdPersonne());
	}

	@Test
	public void testDeletePersonne() {
		List<Personne> list1 = metierP.getAllPersonne();
		metierP.deletePersonne(2l);
		List<Personne> list2 = metierP.getAllPersonne();
		assertTrue(list1.size()==(list2.size()+1));
	}

	@Test
	public void testUpdatePersonne() {
		Personne p = metierP.getPersonne(3l);
		p.setPrenom("nouveau Prenom");
		p.setNom("Nouveau Nom");
		metierP.updatePersonne(p);
		assertTrue(p.getPrenom()=="nouveau Prenom");
	}

	@Test
	public void testGetPersonne() {
		Personne p = metierP.getPersonne(3l);
		assertNotNull(p.getIdPersonne());
	}

	@Test
	public void testGetAllPersonne(){
		List<Personne> listPers = metierP.getAllPersonne();
		assertNotNull(listPers);
	}
	
	@Test
	public void testSearchPersonne() {
		List<Personne> listPers = metierP.searchPersonne("no");
		assertNotNull(listPers);
	}

}
