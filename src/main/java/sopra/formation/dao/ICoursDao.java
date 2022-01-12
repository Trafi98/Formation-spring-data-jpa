package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Cours;
import sopra.formation.model.Filiere;

public interface ICoursDao extends JpaRepository<Cours, Long> {
	
	@Query("select f from filiere f join f.cours fc where fc.duree != fc.matiere.duree")
	List<Cours> findCoursByFiliere(@Param("duree") int duree);

}
