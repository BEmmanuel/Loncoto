package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Site;

public class SiteDAO implements ISiteDAO {
	
	private EntityManager em;
	
	
	public EntityManager getEm() {
		return em;
	}
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Site> findAll() {
		return em.createQuery("from Site",Site.class).getResultList();
	}

	@Override
	public Site findByID(int id) {
		return em.find(Site.class,id);
	}

	@Override
	public Site save(Site site) {
		if (site == null)
			return site;
		if (site.getId() == 0)
		{
			em.persist(site);
		}
		else
		{
			site = em.merge(site);
		}
		return site;
	}

}
