package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Groupe;

public class GroupeDAO implements IGroupeDAO {
	
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
	public List<Groupe> findAll() {
		return em.createQuery("from Groups",Groupe.class).getResultList();
	}

	@Override
	@Transactional
	public Groupe findByID(int id) {
		return em.find(Groupe.class, id);
	}

	@Override
	@Transactional
	public Groupe save(Groupe groupe) {
		if (groupe == null)
			return groupe;
	
		if (groupe.getId() == 0)
		{
			em.persist(groupe);
		}
		else
		{
			groupe = em.merge(groupe);
		}
		return groupe;
	}

}
