package com.gestionHotel.hilton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionHotel.hilton.Metier.InterfMetierPersonne;
import com.gestionHotel.hilton.entities.Personne;

public class DriverPers {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context;
		InterfMetierPersonne metierP;
		
			context=new ClassPathXmlApplicationContext("applicationContext.xml");
			metierP = (InterfMetierPersonne) context.getBean("metierP");
			
			try {
				for (Personne p : metierP.searchPersonne("o")){
					System.out.println(p.getNom() + " " + p.getPrenom());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}

}
