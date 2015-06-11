package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import beans.Batiment;

public class BatimentDAO implements IBatimentDAO {
	
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
	public List<Batiment> findAll() {
		return em.createQuery("from Batiment",Batiment.class).getResultList();
	}

	@Override
	@Transactional
	public Batiment findByID(int id) {
		return em.find(Batiment.class, id);
	}

	@Override
	@Transactional
	public Batiment save(Batiment batiment) {
		if (batiment == null)
			return batiment;
		if (batiment.getId() == 0)
		{
			em.persist(batiment);
		}
		else
		{
			batiment = em.merge(batiment);
		}
		return batiment;
	}

	@Override
	@Transactional
	public List<Batiment> findBySiteId(int id) {
		Query q = em.createQuery("select bat from Batiment as bat, IN(bat.sites) as sites, where sites.id = :id");
		q.setParameter("id", id);
		return q.getResultList();
	}

}
