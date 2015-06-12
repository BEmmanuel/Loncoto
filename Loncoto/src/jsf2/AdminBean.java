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
	private List<Materiel> materiels2;
	private List<Intervention> interventions;
	private List<Intervenant> intervenants;
	private List<Intervenant> intervenants2;
	private List<Client> clients;
	private List<Client> clients2;
	private List<Site> sites;
	private List<Article> articles;
	private IIntervenantDAO intervenantDAO;
	private IInterventionDAO interventionDAO;
	private IMaterielDAO materielDAO;
	private IClientDAO clientDAO;
	private ISiteDAO siteDAO;
	private IArticleDAO articleDAO;
	private int intervenantID;
	private int materielID;
	private int clientID;
	
	
	
	
	public List<Intervenant> getIntervenants2() {
		return getIntervenantDAO().findAll();
	}

	public void setIntervenants2(List<Intervenant> intervenants2) {
		this.intervenants2 = intervenants2;
	}

	public List<Materiel> getMateriels2() {
		return getMaterielDAO().findAll();
	}

	public void setMateriels2(List<Materiel> materiels2) {
		this.materiels2 = materiels2;
	}

	public List<Client> getClients2() {
		return getClientDAO().findAll();
	}

	public void setClients2(List<Client> clients2) {
		this.clients2 = clients2;
	}

	public List<Article> getArticles() {
		return getArticleDAO().findAll();
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public ISiteDAO getSiteDAO() {
		return siteDAO;
	}

	public void setSiteDAO(ISiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}

	public List<Site> getSites() {
		return getSiteDAO().findAll();
	}
	
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
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
		System.out.println("injection de materielID" + materielID);
		System.out.println("-----------------------------");
		this.materielID = materielID;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		System.out.println("injection de ClientID" + clientID);
		System.out.println("-----------------------------");
		this.clientID = clientID;
	}
	public int getIntervenantID() {
		return intervenantID;
	}
	public void setIntervenantID(int intervenantID) {
		System.out.println("injection de ClientID" + intervenantID);
		System.out.println("-----------------------------");
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
			return getInterventionDAO().find(getIntervenantID(),getMaterielID(),getClientID(),0,0);
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	public List<Intervenant> getIntervenants() {
		
		return getIntervenantDAO().findAllWitchIntervention();
	}
	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		System.out.println("injection de intervenantDAO dans AdminBean");
		System.out.println("---------------------------------------------------");
		this.intervenantDAO = intervenantDAO;
	}
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		System.out.println("injection de interventionDAO dans AdminBean");
		System.out.println("---------------------------------------------------");
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
