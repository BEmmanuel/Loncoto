package beans;
import java.util.*;

import javax.persistence.*;

@Entity
public class Groupe {

	private int id;
	private String nom;
	private Set<Intervenant> intervenants;
	
	@ManyToMany(mappedBy = "groupes")
	public Set<Intervenant> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(Set<Intervenant> intervenants) {
		this.intervenants = intervenants;
	}
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
