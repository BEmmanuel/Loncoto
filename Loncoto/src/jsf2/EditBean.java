package jsf2;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.springframework.stereotype.Component;

import utils.*;
import beans.*;

import com.sun.faces.facelets.tag.jstl.core.SetHandler;

@Component
@ManagedBean
@RequestScoped
public class EditBean {
	IInterventionDAO interventionDAO;
	IIntervenantDAO intervenantDAO;
	IMaterielDAO materielDAO;
	IArticleDAO articleDAO;
	ISiteDAO siteDAO;
	IClientDAO clientDAO;
	IGroupeDAO groupeDAO;
	ISousFamilleDAO sousFamilleDAO;
	private int interventionID;
	private String interventionCommentaire;
	private Date datePlanification;
	private Date dateRealisation;
	private double interventionDuree;
	private String interventionStatus;
	private int intervenantID;
	private int materielID;
	
	
	private List<Intervenant> intervenants;
	private List<Materiel> materiels;
	private List<SousFamille> sousFamilles;
	private List<Client> clients;
	private List<Article> articles;
	private List<Groupe> groupes2;
	private int siteID;
	private String siteNom;
	private String siteAdresse;
	
	private int articleID;
	private String articleNom;
	private String articleDescription;
	private int articleSousFamilleId;
	
	private int materielID2;
	private String materielNumeroSerie;
	private int materielClientID;
	private int materielArticleID;
	
	private int clientID;
	private String clientNom;
	private String clientNumeroTelephone;
	
	private int intervenantID2;
	private String intervenantNom;
	private String intervenantPrenom2;
	private String intervenantEmail;

	private int[] groupeIDS;
	private String intervenantPrenom;
	private String intervenantPassword;
	private List<Groupe> groupes;
	
	
	

	public List<Groupe> getGroupes2() {
		return getGroupeDAO().findAll();
	}

	public void setGroupes2(List<Groupe> groupes2) {
		this.groupes2 = groupes2;
	}

	public String getIntervenantPrenom2() {
		return intervenantPrenom2;
	}

	public void setIntervenantPrenom2(String intervenantPrenom2) {
		this.intervenantPrenom2 = intervenantPrenom2;
	}

	

	public int[] getGroupeIDS() {
		return groupeIDS;
	}

	public void setGroupeIDS(int[] groupeIDS) {
		this.groupeIDS = groupeIDS;
	}

	public IGroupeDAO getGroupeDAO() {
		return groupeDAO;
	}

	public void setGroupeDAO(IGroupeDAO groupeDAO) {
		this.groupeDAO = groupeDAO;
	}

	public int getIntervenantID2() {
		return intervenantID2;
	}

	public void setIntervenantID2(int intervenantID2) {
		this.intervenantID2 = intervenantID2;
	}

	

	public String getIntervenantNom() {
		return intervenantNom;
	}

	public void setIntervenantNom(String intervenantNom) {
		this.intervenantNom = intervenantNom;
	}

	public String getIntervenantEmail() {
		return intervenantEmail;
	}

	public void setIntervenantEmail(String intervenantEmail) {
		this.intervenantEmail = intervenantEmail;
	}

	public String getIntervenantPrenom() {
		return intervenantPrenom;
	}

	public void setIntervenantPrenom(String intervenantPrenom) {
		this.intervenantPrenom = intervenantPrenom;
	}

	public String getIntervenantPassword() {
		return intervenantPassword;
	}

	public void setIntervenantPassword(String intervenantPassword) {
		this.intervenantPassword = intervenantPassword;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public List<Article> getArticles() {
		return getArticleDAO().findAll();
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Client> getClients() {
		return getClientDAO().findAll();
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public int getMaterielClientID() {
		return materielClientID;
	}

	public void setMaterielClientID(int materielClientID) {
		this.materielClientID = materielClientID;
	}

	public int getMaterielArticleID() {
		return materielArticleID;
	}

	public void setMaterielArticleID(int materielArticleID) {
		this.materielArticleID = materielArticleID;
	}

	public int getMaterielID2() {
		return materielID2;
	}

	public void setMaterielID2(int materielID2) {
		this.materielID2 = materielID2;
	}

	public String getMaterielNumeroSerie() {
		return materielNumeroSerie;
	}

	public void setMaterielNumeroSerie(String materielNumeroSerie) {
		this.materielNumeroSerie = materielNumeroSerie;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	

	public String getClientNom() {
		return clientNom;
	}

	public void setClientNom(String clientNom) {
		this.clientNom = clientNom;
	}

	

	public String getClientNumeroTelephone() {
		return clientNumeroTelephone;
	}

	public void setClientNumeroTelephone(String clientNumeroTelephone) {
		this.clientNumeroTelephone = clientNumeroTelephone;
	}

	public ISousFamilleDAO getSousFamilleDAO() {
		return sousFamilleDAO;
	}

	public void setSousFamilleDAO(ISousFamilleDAO sousFamilleDAO) {
		this.sousFamilleDAO = sousFamilleDAO;
	}

	public List<SousFamille> getSousFamilles() {
		return getSousFamilleDAO().findAll();
	}

	public void setSousFamilles(List<SousFamille> sousFamilles) {
		this.sousFamilles = sousFamilles;
	}

	public int getArticleSousFamilleId() {
		return articleSousFamilleId;
	}

	public void setArticleSousFamilleId(int articleSousFamilleId) {
		this.articleSousFamilleId = articleSousFamilleId;
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getArticleNom() {
		return articleNom;
	}

	public void setArticleNom(String articleNom) {
		this.articleNom = articleNom;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public IClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public int getSiteID() {
		return siteID;
	}

	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	public String getSiteNom() {
		return siteNom;
	}

	public void setSiteNom(String siteNom) {
		this.siteNom = siteNom;
	}

	public String getSiteAdresse() {
		return siteAdresse;
	}

	public void setSiteAdresse(String siteAdresse) {
		this.siteAdresse = siteAdresse;
	}

	public ISiteDAO getSiteDAO() {
		return siteDAO;
	}

	public void setSiteDAO(ISiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}

	public List<Intervenant> getIntervenants() {
		return getIntervenantDAO().findAll();
	}

	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}

	public List<Materiel> getMateriels() {
		return getMaterielDAO().findAll();
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
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

	public int getInterventionID() {
		return interventionID;
	}

	public void setInterventionID(int interventionID) {
		this.interventionID = interventionID;
	}

	public String getInterventionCommentaire() {
		return interventionCommentaire;
	}

	public void setInterventionCommentaire(String interventionCommentaire) {
		this.interventionCommentaire = interventionCommentaire;
	}

	public Date getDatePlanification() {
		return datePlanification;
	}

	public void setDatePlanification(Date datePlanification) {
		this.datePlanification = datePlanification;
	}

	public Date getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public double getInterventionDuree() {
		return interventionDuree;
	}

	public void setInterventionDuree(double interventionDuree) {
		this.interventionDuree = interventionDuree;
	}

	public String getInterventionStatus() {
		return interventionStatus;
	}

	public void setInterventionStatus(String interventionStatus) {
		this.interventionStatus = interventionStatus;
	}

	public int getIntervenantID() {
		return intervenantID;
	}

	public void setIntervenantID(int intervenantID) {
		this.intervenantID = intervenantID;
	}

	public int getMaterielID() {
		return materielID;
	}

	public void setMaterielID(int materielID) {
		this.materielID = materielID;
	}

	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}

	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	
	public String createIntervention(){
		setInterventionID(0);
		return "createIntervention.xhtml";
	}


	public String editIntervention(){
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("id"));
		
		Intervention intervention = getInterventionDAO().findByID(id);
		setInterventionID(id);
		setDatePlanification(intervention.getDatePlanifie());
		setDateRealisation(intervention.getDateRealisation());
		setInterventionDuree(intervention.getDuree());
		setInterventionCommentaire(intervention.getCommentaire());
		setInterventionStatus(intervention.getStatut());
		setIntervenantID(intervention.getIntervenant().getId());
		setMaterielID(intervention.getMateriel().getId());
		
		return "editIntervention.xhtml";
	}
	
	public String editInterventionByIntervenant(){
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("id"));
		
		Intervention intervention = getInterventionDAO().findByID(id);
		setInterventionID(id);
		setDatePlanification(intervention.getDatePlanifie());
		setDateRealisation(intervention.getDateRealisation());
		setInterventionDuree(intervention.getDuree());
		setInterventionCommentaire(intervention.getCommentaire());
		setMaterielID(intervention.getMateriel().getId());
		
		return "editInterventionByIntervenant.xhtml";
	}
	
	
	public String saveIntervention(){
		Intervention intervention = new Intervention();
		intervention.setId(getInterventionID());
		intervention.setDatePlanifie(getDatePlanification());
		intervention.setDateRealisation(getDateRealisation());
		intervention.setDuree(getInterventionDuree());
		intervention.setCommentaire(getInterventionCommentaire());
		intervention.setStatut(getInterventionStatus());
		
		Intervenant intervenant = getIntervenantDAO().findByID(getIntervenantID());
		Materiel materiel = getMaterielDAO().findByID(getMaterielID());
		intervention.setIntervenant(intervenant);
		intervention.setMateriel(materiel);
		getInterventionDAO().save(intervention);
		
		return "adminAccueil.xhtml?faces-redirect=true";
	}
	
	public String saveIntervention2(){
		Intervention intervention = new Intervention();
		intervention.setId(getInterventionID());
		intervention.setDatePlanifie(getDatePlanification());
		System.out.println("---------------------------------------");
		System.out.println("le suivant est le date planification quand on fait saveIntervention2");
		System.out.println(getDatePlanification());
		
		intervention.setCommentaire(getInterventionCommentaire());
		intervention.setDateRealisation(null);
		Intervenant intervenant = getIntervenantDAO().findByID(getIntervenantID());
		Materiel materiel = getMaterielDAO().findByID(getMaterielID());
		intervention.setIntervenant(intervenant);
		intervention.setMateriel(materiel);
		getInterventionDAO().save(intervention);
		
		return "adminAccueil.xhtml?faces-redirect=true";
	}
	
	
	public String saveInterventionByIntervenant(){
		Intervention intervention = new Intervention();
		intervention.setId(getInterventionID());
		intervention.setDatePlanifie(getDatePlanification());
		intervention.setDateRealisation(getDateRealisation());
		intervention.setDuree(getInterventionDuree());
		intervention.setCommentaire(getInterventionCommentaire());
		intervention.setStatut(getInterventionStatus());
		intervention.setIntervenant((Intervenant) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("user"));
		Materiel materiel = getMaterielDAO().findByID(getMaterielID());
		intervention.setMateriel(materiel);
		getInterventionDAO().save(intervention);
		
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editSite(){
		System.out.println("entre dans le methode editsite");
		System.out.println("--------------------------------------------------");
		
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("sid"));
		System.out.println("id : " + id);
		Site site = getSiteDAO().findByID(id);
		setSiteID(id);
		setSiteNom(site.getNom());
		setSiteAdresse(site.getAdresse());
		
		return "editSite.xhtml";
	}
	
	public String saveSite(){
		System.out.println("entre dans le methode savesite");
		System.out.println("--------------------------------------------------");
		System.out.println("attribut nom " + getSiteNom() + "attribut adresse " + getSiteAdresse() + "attribut id " +getSiteID());
		
		Site site = new Site();
		site.setId(getSiteID());
		site.setNom(getSiteNom());
		site.setAdresse(getSiteAdresse());
		
		System.out.println("attribut nom du site est" + site.getNom());
		getSiteDAO().save(site);
		
		return "adminAccueil.xhtml?faces-redirect=true";
	
	}
	
	
	public String editArticle(){
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("aid"));
		
		Article article = getArticleDAO().findByID(id);
		
		setArticleID(id);
		setArticleDescription(article.getDescription());
		setArticleNom(article.getNom());
		setArticleSousFamilleId(article.getSousfamille().getId());
		
		return "editArticle.xhtml";
	}
	
	public String saveArticle(){
		Article article = new Article();
		article.setId(getArticleID());
		article.setDescription(getArticleDescription());
		article.setNom(getArticleNom());
		SousFamille sousFamille = getSousFamilleDAO().findByID(getArticleSousFamilleId());
		article.setSousfamille(sousFamille);
		getArticleDAO().save(article);
		
		return "adminAccueil.xhtml?faces-redirect=true";
	}
	
	public String editMateriel(){
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("mid"));
		Materiel materiel = getMaterielDAO().findByID(id);
		setMaterielID2(id);
		setMaterielNumeroSerie(materiel.getNumeroSerie());
		setMaterielClientID(materiel.getClient_id().getId());
		setMaterielArticleID(materiel.getArticle_id().getId());
		
		return "editMateriel.xhtml";
	}
	
	public String saveMateriel(){
		Materiel materiel = new Materiel();
		materiel.setId(getMaterielID2());
		materiel.setNumeroSerie(getMaterielNumeroSerie());
		materiel.setClient_id(getClientDAO().findByID(getMaterielClientID()));
		materiel.setArticle_id(getArticleDAO().findByID(getMaterielArticleID()));
		
		getMaterielDAO().save(materiel);
		
		return "adminAccueil.xhtml?faces-redirect=true";
	}
	
	public String editClient(){
		int id = Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("clientId"));
		
		Client client = getClientDAO().findByID(id);
		setClientID(id);
		setClientNom(client.getNom());
		setClientNumeroTelephone(client.getNumeroTelephone());
		
		return "editClient.xhtml";
		
	}
	
	public String saveClient(){
		Client client = new Client();
		client.setId(getClientID());
		client.setNom(getClientNom());
		client.setNumeroTelephone(getClientNumeroTelephone());
		getClientDAO().save(client);
		return "adminAccueil.xhtml?faces-redirect=true";
	}
	
	public String editIntervenant(){
		int id =  Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("id"));
		
		Utilisateur intervenant = getIntervenantDAO().findByID(id);
		if(intervenant instanceof Intervenant) {
			setGroupes(((Intervenant) intervenant).getGroupes());
		} 
		
		setIntervenantID2(id);
		setIntervenantEmail(intervenant.getEmail());
		setIntervenantNom(intervenant.getNom());
		setIntervenantPrenom(intervenant.getPrenom());
		setIntervenantPassword(intervenant.getPassword());
		
		return "editIntervenant.xhtml";
		
	}
	
	
	public String editIntervenant2(){
		int id =  Integer.parseInt(FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("id"));
		
		Intervenant intervenant = getIntervenantDAO().findByID(id);
		
		setIntervenantID2(id);
		setIntervenantEmail(intervenant.getEmail());
		setIntervenantNom(intervenant.getNom());
		setIntervenantPrenom2(intervenant.getPrenom());
		List<Groupe> intervenantGroupes =  intervenant.getGroupes();
		int[] groupeIDS = new int[intervenantGroupes.size()];
		for(int i = 0; i<intervenantGroupes.size();i++){
			groupeIDS[i] = intervenantGroupes.get(i).getId();
		}
		setGroupeIDS(groupeIDS);

		
		return "editIntervenant2.xhtml";
	}
	
	
	public String createIntervenant(){
		
		
		Utilisateur intervenant = new Utilisateur();
		
		
		setIntervenantID2(intervenant.getId());
		setIntervenantEmail(intervenant.getEmail());
		setIntervenantNom(intervenant.getNom());
		setIntervenantPrenom(intervenant.getPrenom());
		setIntervenantPassword(intervenant.getPassword());
		
		return "editIntervenant.xhtml";
		
	}
	
	public String createIntervenant2(){
		
		
		Intervenant intervenant = new Intervenant();
		
		
		setIntervenantID2(intervenant.getId());
		setIntervenantEmail(intervenant.getEmail());
		setIntervenantNom(intervenant.getNom());
		setIntervenantPrenom(intervenant.getPrenom());
		setIntervenantPassword(intervenant.getPassword());
		
		return "editIntervenant.xhtml";
		
	}
	
	public String saveIntervenant(){
		Utilisateur utilisateur = new Utilisateur(getIntervenantID(), getIntervenantNom(), getIntervenantPrenom(), getIntervenantEmail(), getIntervenantPassword());
		getIntervenantDAO().save(utilisateur);
		return "index.xhtml";
	}
	
	public String saveIntervenant2(){
		Intervenant intervenant = new Intervenant();
		
		intervenant.setEmail(getIntervenantEmail());
		intervenant.setNom(getIntervenantNom());
		intervenant.setPrenom(getIntervenantPrenom2());
		intervenant.setId(getIntervenantID2());
		List<Groupe> groupes = new ArrayList<Groupe>();
		for(int i = 0;i<getGroupeIDS().length;i++){
			Groupe groupe = getGroupeDAO().findByID(getGroupeIDS()[i]);
			groupes.add(groupe);
		}
		
		intervenant.setGroupes(groupes);
		getIntervenantDAO().save(intervenant);
		return "adminAccueil.xhtml?faces-redirect=true";
	}
	
	
}
