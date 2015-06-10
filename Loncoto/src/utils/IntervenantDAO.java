package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervenant;

import javax.persistence.*;

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
	public List<Intervenant> findAllWitchIntervention(){
		return em.createQuery("select inter from Intervenant as inter , IN(inter.interventions) as interventions where interventions.size > 0 ", Intervenant.class).getResultList();
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

	@Override
	@Transactional
	public Intervenant findByUsernameAndPassword(String login,
			String password) {
		Query q = em.createQuery("select inter from Intervenant as inter where inter.login.id=:login and inter.password =:password"
				, Intervenant.class);
		q.setParameter("login", login);
		q.setParameter("password", password);
		List<Intervenant> inter = q.getResultList();
		if(inter.size()==0)
			return null;
		else if (inter.size()==1) {
			return inter.get(0);
		}else{
			return null;
		}
		
	}

}
