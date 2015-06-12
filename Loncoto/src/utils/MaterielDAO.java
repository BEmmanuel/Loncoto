package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervenant;
import beans.Materiel;

public class MaterielDAO implements IMaterielDAO {

	EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Materiel> findAll() {
		return em.createQuery("from Materiel", Materiel.class).getResultList();
	}

	@Transactional
	public Materiel findByID(int id) {
		return em.find(Materiel.class, id);
	}

	@Transactional
	public Materiel save(Materiel materiel) {
		if(materiel.getId() > 0) {
			em.merge(materiel);
		} else {
			em.persist(materiel);
		}
		return materiel;
	}

	@Override
	@Transactional
	public List<Materiel> findAllWithIntervention() {
		return em.createQuery("select DISTINCT mat from Materiel as mat , IN(mat.interventions) as interventions where interventions.size > 0 ", Materiel.class).getResultList();
	}

	@Override
	public List<Materiel> findByClientId(int id) {
		Query q = em.createQuery("select mat from Materiel as mat, IN(mat.clients) as clients where clients.id = :id");
		q.setParameter("id", id);
		return q.getResultList();
	}
}
