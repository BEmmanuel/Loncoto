package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervenant;

public class IntervenantDAO implements IIntervenantDAO {
	
	private EntityManager em;
	
	
	public EntityManager getEm() {
		return em;
	}
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public List<Intervenant> findAll() {
		return em.createQuery("from Intervenant",Intervenant.class).getResultList();
	}

	@Override
	@Transactional
	public Intervenant findByID(int id) {
		return em.find(Intervenant.class,id);
	}

	@Override
	@Transactional
	public Intervenant save(Intervenant intervenant) {
		if (intervenant == null)
			return intervenant;
	
		if (intervenant.getId() == 0)
		{
			em.persist(intervenant);
		}
		else
		{
			intervenant = em.merge(intervenant);
		}
		return intervenant;
	}

}
