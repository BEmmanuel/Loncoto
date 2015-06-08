package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Salle;

public class SalleDAO implements ISalleDAO {

	EntityManager em;
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	@Transactional
	public List<Salle> findAll() {
		
		return em.createQuery("from Salle", Salle.class).getResultList();
	}

	@Transactional
	public Salle findByID(int id) {
		return em.find(Salle.class, id);
	}

	@Transactional
	public Salle save(Salle salle) {
		if(salle.getId()>0) {
			em.merge(salle);
		} else {
			em.persist(salle);
		}
		return salle;
	}

}
