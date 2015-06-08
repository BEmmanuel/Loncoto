package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Etage;

public class EtageDAO implements IEtageDAO {

	EntityManager em;
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	@Transactional
	public List<Etage> findAll() {
		return em.createQuery("from Etage", Etage.class).getResultList();
	}

	@Transactional
	public Etage findByID(int id) {
		return em.find(Etage.class, id);
	}

	@Transactional
	public Etage save(Etage etage) {
		if(etage.getId()>0){
			em.merge(etage);
		} else {
			em.persist(etage);
		}
		return etage;
	}

}
