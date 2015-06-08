package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

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

}
