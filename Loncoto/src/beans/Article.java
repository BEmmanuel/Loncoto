package beans;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Article {

	private int id;
	private String nom;
	private String description;
	private SousFamille sousfamille;
	private List<Materiel> materiels;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne
	@JoinColumn(name="sousfamille_id")
	public SousFamille getSousfamille() {
		return sousfamille;
	}
	public void setSousfamille(SousFamille sousfamille) {
		this.sousfamille = sousfamille;
	}


	public Article() {this(0, "", "");}
	public Article(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description="
				+ description + ", sousfamille=" + sousfamille + "]";
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="article_id")
	public List<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
}
