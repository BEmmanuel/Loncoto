package utils;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
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
	
	public List<Intervention> find(int intervenantID, int materielID, int clientID) {
		return find(intervenantID, materielID, clientID, new GregorianCalendar().get(GregorianCalendar.WEEK_OF_YEAR), new GregorianCalendar().get(GregorianCalendar.YEAR));
	}
	
	@Override
	@Transactional
	public List<Intervention> find(int intervenantID, int materielID, int clientID, int weekNo , int yearNo ){
		System.out.println("valeur de intervenantID :"+ intervenantID + " materieID: " + materielID + " clientID :" + clientID);
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
		
		if(weekNo != 0 && yearNo != 0){
			if(compteur != 0) {
				ejbstring += " AND i.datePlanifie >= :datemin AND i.datePlanifie <= :datemax";
			} else {
				ejbstring += "i.datePlanifie >= :datemin AND i.datePlanifie <= :datemax";
			}
			
			
		}
		
		q = em.createQuery(ejbstring);
		if(intervenantID != 0)
			q.setParameter("ivid", intervenantID);
		if(materielID != 0)
			q.setParameter("maid", materielID);
		if(clientID != 0)
			q.setParameter("clid", clientID);
		
		if(weekNo != 0 && yearNo != 0){
			GregorianCalendar gc = new GregorianCalendar();
			gc.set(GregorianCalendar.WEEK_OF_YEAR, weekNo);
			gc.set(GregorianCalendar.YEAR, yearNo);
			gc.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.MONDAY);
			GregorianCalendar gc2 = new GregorianCalendar();
			gc2.set(GregorianCalendar.WEEK_OF_YEAR, weekNo);
			gc2.set(GregorianCalendar.YEAR, yearNo);
			gc2.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.SATURDAY);
			Date d1 = gc.getTime();
			Date d2 = gc.getTime();
			q.setParameter("datemin", d1);
			q.setParameter("datemax", d2);
		}
			
		
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
	
	@Override
	@Transactional
	public List<Intervention> findByIntervenant(int intervenantId) {
		Query q = em.createQuery("select inter from Intervention as inter where inter.intervenant.id =:intervenant"
				, Intervention.class);
		q.setParameter("intervenant", intervenantId);
		return q.getResultList();
	}
	
	@Override
	@Transactional
	public List<Intervention> findByGroup(int intervenantId) {
		Query q = em.createQuery("select distinct inter from Intervention as inter, in (inter.intervenant) as iv where iv.groupe = (select ive.groupe from intervenant as ive where ive.id = :id)"
				, Intervention.class);
		q.setParameter("id", intervenantId);
		return q.getResultList();
	}
	
	
	@Override
	@Transactional
	public List<Intervention> findByIntervenantAndGroup(int intervenantId){
		Query q = em.createQuery("select distinct inter from Intervention as inter, "
				+ "in (inter.intervenant) as iv where iv.groupes = (select ive.groupes from intervenant as ive "
				+ "where ive.id = :id) OR iv.id = :intervenant"
				, Intervention.class);
		q.setParameter("id", intervenantId);
		q.setParameter("intervenant", intervenantId);
		return q.getResultList();
	}
}

