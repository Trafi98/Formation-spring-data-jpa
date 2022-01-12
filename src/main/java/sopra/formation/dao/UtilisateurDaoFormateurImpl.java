package sopra.formation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import sopra.formation.model.Stagiaire;

public abstract class UtilisateurDaoFormateurImpl implements UtilisateurDaoFormateur {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Stagiaire findByNom(String nom, String prenom) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Stagiaire> cq = cb.createQuery(Stagiaire.class);

		Root<Stagiaire> rootStagiaire = cq.from(Stagiaire.class);

		cq.select(rootStagiaire);

		Predicate predicatFinal = cb.equal(cb.literal(1), 1);

		if (prenom != null&& !nom.isBlank()) {
			predicatFinal = cb.and(predicatFinal, cb.equal(rootStagiaire.get("prenom"), prenom));
		}

		if (nom != null && !nom.isBlank()) {
			predicatFinal = cb.and(predicatFinal, cb.equal(rootStagiaire.get("nom"), nom));
		}

		cq.where(predicatFinal);

		TypedQuery<Stagiaire> query = em.createQuery(cq);

		return query.getSingleResult();
	}

}
