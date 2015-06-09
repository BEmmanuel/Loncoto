package jsf2;
import beans.*;

import java.util.*; 

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Component;

import utils.*;

@Component
@ManagedBean
@RequestScoped
public class AdminBean {
	private List<Materiel> materiels;
	private List<Intervention> interventions;
	private List<Intervenant> intervenants;
	private IIntervenantDAO intervenantDAO;
	private IInterventionDAO interventionDAO;
	private IMaterielDAO materielDAO;
	private int intervenantID;
	private int materielID;
	private int clientID;
	
	
	
	public int getMaterielID() {
		return materielID;
	}
	public void setMaterielID(int materielID) {
		this.materielID = materielID;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public int getIntervenantID() {
		return intervenantID;
	}
	public void setIntervenantID(int intervenantID) {
		this.intervenantID = intervenantID;
	}
	public List<Materiel> getMateriels() {
		return getMaterielDAO().findAll();
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	public List<Intervention> getInterventions() {
		if(getIntervenantID()==0 && getMaterielID()==0 && getClientID()==0 )
			return getInterventionDAO().findAll();
		else
			return getInterventionDAO().find(getIntervenantID(),getMaterielID(),getClientID());
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	public List<Intervenant> getIntervenants() {
		return getIntervenantDAO().findAll();
	}
	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		this.intervenantDAO = intervenantDAO;
	}
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}
	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}
	
	public String filterInt(AjaxBehaviorEvent evt){
		
		return "";
	}
}
