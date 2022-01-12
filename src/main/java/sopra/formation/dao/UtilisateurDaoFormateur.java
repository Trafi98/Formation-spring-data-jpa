package sopra.formation.dao;

import java.util.List;

import sopra.formation.model.Stagiaire;

public interface UtilisateurDaoFormateur {
	
	Stagiaire findByNom(String nom, String prenom);

}
