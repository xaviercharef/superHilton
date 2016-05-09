package com.gestionHotel.hilton.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionHotel.hilton.DAO.InterfDAOChambre;
import com.gestionHotel.hilton.Metier.InterfMetierChambre;
import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.Metier.ReservationInterfMetier;
import com.gestionHotel.hilton.entities.Chambre;
import com.gestionHotel.hilton.entities.Client;
import com.gestionHotel.hilton.entities.Employe;
import com.gestionHotel.hilton.entities.Reservation;

public class ReservationTest {
	
	private static ClassPathXmlApplicationContext context;
	private static ReservationInterfMetier metierR;
	private static InterfMetierPersonne metierP;
	private static InterfMetierChambre metierCh;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metierR = (ReservationInterfMetier) context.getBean("metierR");
		metierP = (InterfMetierPersonne) context.getBean("metierP");
		metierCh = (InterfMetierChambre) context.getBean("metierCh");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddReservation() {
		Reservation r= new Reservation();
		metierR.addReservation(r);
		assertNotNull(metierR.getListReservation());
	}

	@Test
	public void testAddReservationParClientParEmploye() {
		Client c= new Client();
		metierP.addPersonne(c);
		
		Chambre ch1= new Chambre();
		metierCh.addChambre(ch1);
		
		Employe e= new Employe();
		metierP.addPersonne(e);
		
		Reservation r= new Reservation();
		metierR.addReservationParClientParEmploye(c.getIdPersonne(), ch1.getIdChambre() ,r , e.getIdPersonne());
		List<Reservation> list=metierR.getListReservation();
			if(list.get(list.size()-1)!=null){
		assertTrue(true);
			}
		
		
	}

	@Test
	public void testGetListReservation() {
		List<Reservation> list= metierR.getListReservation();
		assertNotNull(list);
	}

	@Test
	public void testGetReservation() {
		Reservation r=metierR.getReservation(2L);
		assertNotNull(r);
	}

	@Test
	public void testSuppReservation() {
		
		metierR.suppReservation(2L);
		assertTrue(true);
	}

	@Test
	public void testGetReservationParEmploye() {
	List<Reservation> list= metierR.getReservationParEmploye(2L);
	assertNotNull(list);
	}

	@Test
	public void testGetReservationParClient() {
		List<Reservation> list= metierR.getReservationParClient(1L);
		assertNotNull(list);
	}

	@Test
	public void testGetReservationParChambre() {
		List<Reservation> list= metierR.getReservationParChambre(1L);
		assertNotNull(list);
	}

	@Test
	public void testGetEmployeParReservation() {
		Employe e= metierR.getEmployeParReservation(3L);
		assertNotNull(e);
	}

	@Test
	public void testGetClientParReservation() {
		Client c= metierR.getClientParReservation(3L);
		assertNotNull(c);
	}

	@Test
	public void testGetChambresParReservation() {
		List<Chambre> list= metierR.getChambresParReservation(3L);
		assertNotNull(list);
	}

	@Test
	public void testSetReservation() {
		List<Long> list= new ArrayList<Long>();
		list.add(1L);
		metierR.setReservation(5L, 1L, list, new Date(), new Date(), "lololo", 2L);
		assertTrue(true);
	}

}
