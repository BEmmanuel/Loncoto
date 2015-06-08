package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.SousFamille;

public class SousFamilleDAO implements ISousFamilleDAO {

	EntityManager em;
	

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public List<SousFamille> findAll() {
		return em.createQuery("from SousFamille", SousFamille.class).getResultList();
	}

	@Override
	public SousFamille findByID(int id) {
		return em.find(SousFamille.class, id);
	}

	@Override
	public SousFamille save(SousFamille sousfamille) {
		if(sousfamille.getId()>0) {
			em.merge(sousfamille);
		} else {
			em.persist(sousfamille);
		}
		return sousfamille;
	}

}
