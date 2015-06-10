package jsf2;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	private int siteID;
	private String siteNom;
	private String siteAdresse;
	
	private int articleID;
	private String articleNom;
	private String articleDescription;
	private int articleSousFamilleId;
	
	
	
	
	
	
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
}
