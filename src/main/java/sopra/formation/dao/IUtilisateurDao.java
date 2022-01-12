package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formateur;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Long> {
	
	@Query("select f from Formateur f where f.email = :email")
	Formateur findByEmail(@Param("email") String email);
	
//	@Query("select m from Matiere m join m.competence mc where mc.formateur mcf where mcf.date = :date")
//	@Query("select f  from Formateur f join f.absence fa where fa.date = :date && join f.competence fc where fc.")
//	Formateur findFormateurDispo(@Param("nom, date") String nom, String date);
	
	@Query("select s from Stagiaire s where s.nom = :nom  and s.prenom = :prenom")
	Stagiaire findByNomPrenom(@Param("nom, prenom") String nom, String prenom);
	
	@Query("select s from Stagiaire s where s.nom = :nom  or s.prenom = :prenom")
	Stagiaire findByNomOuPrenom(@Param("nom, prenom") String nom, String prenom);

	@Query("select s from Stagiaire s left join fetch s.cursus sc")
	List<Stagiaire> findAllCursus();
	
	@Query("select f from Formateur f left join fetch f.cours fc ")
	List<Formateur> findAllCoursMatiere();
}
