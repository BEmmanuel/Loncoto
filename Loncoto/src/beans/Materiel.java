package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Materiel {

	private int id;
	private String type;
	private String numeroSerie;
	private Client client_id;
	private Salle salle_id;
	private Article article_id;
	private List<Intervention> interventions;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getNumeroSerie() {
		return numeroSerie;
	}
	
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	@ManyToOne
	@JoinColumn(name="client_id")
	public Client getClient_id() {
		return client_id;
	}
	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	@ManyToOne
	@JoinColumn(name="salle_id")
	public Salle getSalle_id() {
		return salle_id;
	}
	public void setSalle_id(Salle salle_id) {
		this.salle_id = salle_id;
	}
	@ManyToOne
	@JoinColumn(name="article_id")
	public Article getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Article article_id) {
		this.article_id = article_id;
	}
	
	
	public Materiel() {this(0, "", "");}
	public Materiel(int id, String type, String numeroSerie) {
		super();
		this.id = id;
		this.type = type;
		this.numeroSerie = numeroSerie;
	}
	
	@OneToMany(mappedBy="materiel")
	public List<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	
	
}
