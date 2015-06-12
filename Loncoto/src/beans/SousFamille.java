package beans;

import java.util.*;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class SousFamille {
	
	private int id;
	private String nom;
	private Famille famille;
	private List<Article> articles;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@ManyToOne
	@JoinColumn(name="famille_id")
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public SousFamille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public SousFamille() {
		this(0, "");
	}
	@Override
	public String toString() {
		return "SousFamille [id=" + id + ", nom=" + nom + ", famille="
				+ famille + "]";
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="sousfamille")
	public List<Article> getArticles() {
		if(articles == null)
			articles = new ArrayList<Article>();
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
