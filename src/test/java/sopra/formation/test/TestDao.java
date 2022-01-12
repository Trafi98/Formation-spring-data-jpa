package sopra.formation.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IUtilisateurDao;

import sopra.formation.model.Salle;
import sopra.formation.model.Utilisateur;

public class TestDao {

	@Test
	public void testApplicationContextXml() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		ISalleDao salleDao = context.getBean(ISalleDao.class);
		
		IUtilisateurDao clientDao = context.getBean(IUtilisateurDao.class); 
				
		Utilisateur utilisateur = new Utilisateur();

		Salle salle = new Salle("Liberte");
		salle = salleDao.save(salle);
		
		context.close();
	}

}
