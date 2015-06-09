package jsf2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Component;

import beans.*;

import java.util.*;

import utils.IIntervenantDAO;
import utils.IInterventionDAO;
import utils.IMaterielDAO;


@Component
@ManagedBean
public class ListeBean {
	private int materielID;
	private int intervenantID;
	private Date datePlan;
	private Date dateFin;
	private String commentaire;
	private List<Materiel> materiels;
	private List<Intervenant> intervenants;
	
	private IInterventionDAO interventionDAO;
	private IIntervenantDAO intervenantDAO;
	private IMaterielDAO materielDAO;
	private List<Intervention> interventions;
	
	
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}

	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}

	public int getMaterielID() {
		return materielID;
	}

	public void setMaterielID(int materielID) {
		this.materielID = materielID;
	}

	public int getIntervenantID() {
		return intervenantID;
	}

	public void setIntervenantID(int intervenantID) {
		this.intervenantID = intervenantID;
	}

	

	public Date getDatePlan() {
		return datePlan;
	}

	public void setDatePlan(Date datePlan) {
		this.datePlan = datePlan;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<Materiel> getMateriels() {
		
		return getMaterielDAO().findAll();
	}

	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}

	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		this.intervenantDAO = intervenantDAO;
	}

	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}

	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public List<Intervenant> getIntervenants() {
		return getIntervenantDAO().findAll();
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}

	public List<Intervention> getInterventons() {
		return getInterventionDAO().findAll();
	}

	public void setInterventons(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	public String saveIntervention(){
		
		Intervenant intervenant = getIntervenantDAO().findByID(getIntervenantID());
		Materiel materiel = getMaterielDAO().findByID(getMaterielID());
		Intervention inter = new Intervention();
		inter.setIntervenant(intervenant);
		inter.setMateriel(materiel);
		inter.setDatePlanifie(getDatePlan());
		inter.setCommentaire(getCommentaire());
		getInterventionDAO().save(inter);
		return "save";
	}
	
	
	
	

}
