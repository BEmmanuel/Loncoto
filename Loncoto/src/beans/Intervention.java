package beans;

import java.util.Date;

public class Intervention {
	private int id;
	private String numeroUnique;
	private Date datePlanifie;
	private Date dateRealisation;
	private String statut;
	private String commentaire;
	private Double duree;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroUnique() {
		return numeroUnique;
	}
	public void setNumeroUnique(String numeroUnique) {
		this.numeroUnique = numeroUnique;
	}
	public Date getDatePlanifie() {
		return datePlanifie;
	}
	public void setDatePlanifie(Date datePlanifie) {
		this.datePlanifie = datePlanifie;
	}
	public Date getDateRealisation() {
		return dateRealisation;
	}
	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Double getDuree() {
		return duree;
	}
	public void setDuree(Double duree) {
		this.duree = duree;
	}
	
	
	public Intervention() {this(0, "", new Date(), new Date(), "", "", 0.0);}
	public Intervention(int id, String numeroUnique, Date datePlanifie,
			Date dateRealisation, String statut, String commentaire,
			Double duree) {
		super();
		this.id = id;
		this.numeroUnique = numeroUnique;
		this.datePlanifie = datePlanifie;
		this.dateRealisation = dateRealisation;
		this.statut = statut;
		this.commentaire = commentaire;
		this.duree = duree;
	}
	
	
	@Override
	public String toString() {
		return "Intervention [id=" + id + ", numeroUnique=" + numeroUnique
				+ ", datePlanifie=" + datePlanifie + ", dateRealisation="
				+ dateRealisation + ", statut=" + statut + ", commentaire="
				+ commentaire + ", duree=" + duree + "]";
	}
	
}
