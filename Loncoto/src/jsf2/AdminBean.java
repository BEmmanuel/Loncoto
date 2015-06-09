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
	private List<Client> clients;
	private IIntervenantDAO intervenantDAO;
	private IInterventionDAO interventionDAO;
	private IMaterielDAO materielDAO;
	private IClientDAO clientDAO;
	private int intervenantID;
	private int materielID;
	private int clientID;
	
	
	
	public IClientDAO getClientDAO() {
		return clientDAO;
	}
	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	public List<Client> getClients() {
		return getClientDAO().findAllWitchIntervention();
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
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
		return getMaterielDAO().findAllWithIntervention();
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	public List<Intervention> getInterventions() {
		System.out.println("entrer dans getInterventions---------------");
		System.out.println("valeur de clientID est " + getClientID());
		if(getIntervenantID()==0 && getMaterielID()==0 && getClientID()==0 ){
			System.out.println("appel de findALL");
			return getInterventionDAO().findAll();
		}
		else
			return getInterventionDAO().find(getIntervenantID(),getMaterielID(),getClientID());
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	public List<Intervenant> getIntervenants() {
		System.out.println("appel de getIntervenants");
		System.out.println("--------------------------");
		return getIntervenantDAO().findAllWitchIntervention();
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
	
	public void filterInt(AjaxBehaviorEvent evt){
		
	}
}
