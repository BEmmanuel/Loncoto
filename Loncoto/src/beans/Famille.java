package beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Famille {
	private int id;
	private String nom;
	private List<SousFamille> sousfamilles;
	
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
	

	public Famille() {this(0, "");}
	public Famille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Famille [id=" + id + ", nom=" + nom + "]";
	}
	
	@OneToMany(mappedBy="famille")
	public List<SousFamille> getSousfamilles() {
		return sousfamilles;
	}
	public void setSousfamilles(List<SousFamille> sousfamilles) {
		this.sousfamilles = sousfamilles;
	}
	
	
	
	
}
