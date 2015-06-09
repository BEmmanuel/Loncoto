package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import beans.Intervenant;
import beans.Intervention;
import beans.Materiel;

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
		System.out.println("ini de findALL");
		System.out.println("-------------------------------------------------------");
		
		return em.createQuery("from Intervention",Intervention.class).getResultList();
	}
	
	@Override
	@Transactional
	public List<Intervention> find(int intervenantID, int materielID, int clientID){
		String ejbstring = "select DISTINCT i from Intervention as i ";
		Query q;
		int compteur = 0;
		if(intervenantID != 0)
			ejbstring += ", IN(i.intervenant) as iv";
		if(materielID != 0)
			ejbstring += ", IN(i.materiel) as ma";
		if(clientID != 0){
			if(materielID != 0)
				ejbstring += ", IN(ma.client_id) as client";
			else
				ejbstring += ", IN(i.materiel) as ma, IN(ma.client_id) as client";
		}
		
		ejbstring += " where ";
		if(intervenantID != 0){
			ejbstring += "iv.id =:ivid";
			compteur++;
		}
		if(materielID != 0){
			if(compteur != 0)
				ejbstring += " AND ma.id =:maid";
			else
				ejbstring += "ma.id =:maid";
			compteur++;
		}
		
		
		if(clientID != 0){
			if(compteur != 0)
				ejbstring += " AND client.id = :clid";
			else
				ejbstring += "client.id = :clid";
		}
		
		
		q = em.createQuery(ejbstring);
		if(intervenantID != 0)
			q.setParameter("ivid", intervenantID);
		if(materielID != 0)
			q.setParameter("maid", materielID);
		if(clientID != 0)
			q.setParameter("clid", clientID);
		
		return q.getResultList();
		
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
	
	public List<Intervention> findByIntervenant(int intervenantId) {
		Query q = em.createQuery("select inter from Intervention as inter where inter.intervenant_id=:intervenant"
				, Intervenant.class);
		q.setParameter("intervenant", intervenantId);
		return q.getResultList();
	}

}

