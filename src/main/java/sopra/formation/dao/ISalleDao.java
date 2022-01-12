package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sopra.formation.model.Salle;

public interface ISalleDao extends JpaRepository<Salle, Long> {
	
	@Query("select s from Salle s join s.adresse a where a.ville = :ville")
	List<Salle> findAllByCity(@Param("ville") String ville);
	
	
	


}
