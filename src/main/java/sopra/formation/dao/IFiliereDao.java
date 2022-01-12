package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;

public interface IFiliereDao extends JpaRepository<Filiere, Long> {

	@Query("select f from Filiere f join f.salle s where s.ville = :ville ")
	List<Filiere> findAllByCity(@Param("ville") String ville);

	@Query("select cf from Cours c right join fetch c.filiere cf where cf.id = :id  ")
	Filiere findByIdWithCours(@Param("id") Long id);

}
