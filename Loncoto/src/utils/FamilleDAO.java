package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Famille;

public class FamilleDAO implements IFamilleDAO {

	EntityManager em;
	

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<Famille> findAll() {
		return em.createQuery("from Famille", Famille.class).getResultList();
	}

	@Transactional
	public Famille findByID(int id) {
		return em.find(Famille.class, id);
	}

	@Transactional
	public Famille save(Famille famille) {
		if(famille.getId()>0) {
			em.merge(famille);
		} else {
			em.persist(famille);
		}
		return famille;
	}

}
