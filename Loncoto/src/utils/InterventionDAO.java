package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervention;

public class InterventionDAO implements IInterventionDAO {
	
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	@Transactional
	public List<Intervention> findAll() {
		return em.createQuery("from Intervention",Intervention.class).getResultList();
	}

	@Override
	@Transactional
	public Intervention findByID(int id) {
		return em.find(Intervention.class, id);
	}

	@Override
	@Transactional
	public Intervention save(Intervention intervention) {
		if (intervention == null)
			return intervention;
	
		if (intervention.getId() == 0)
		{
			em.persist(intervention);
		}
		else
		{
			intervention = em.merge(intervention);
		}
		return intervention;
		
	}

}
