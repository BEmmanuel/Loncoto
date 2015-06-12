package beans;
import java.util.*;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Groupe {

	private int id;
	private String nom;
	private List<Intervenant> intervenants;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "groupes")
	public List<Intervenant> getIntervenants() {
		if(intervenants == null)
			intervenants = new ArrayList<Intervenant>();
		return intervenants;
	}
	public void setIntervenants(List<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
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
	
	
	public Groupe() {this(0, "");}
	public Groupe(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + "]";
	}
	
}
