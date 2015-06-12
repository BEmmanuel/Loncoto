
package beans;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Etage {
	
	private int id;
	private int numeroEtage;
	private Batiment batiment_id;
	private List<Salle> salles;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroEtage() {
		return numeroEtage;
	}
	public void setNumeroEtage(int numeroEtage) {
		this.numeroEtage = numeroEtage;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="batiment_id")
	public Batiment getBatiment_id() {
		return batiment_id;
	}
	public void setBatiment_id(Batiment batiment_id) {
		this.batiment_id = batiment_id;
	}
	
	
	public Etage() {this(0, 0);}
	public Etage(int id, int numeroEtage) {
		super();
		this.id = id;
		this.numeroEtage = numeroEtage;
	}
	
	
	@Override
	public String toString() {
		return "Etage [id=" + id + ", numeroEtage=" + numeroEtage + "]";
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="etage_id")
	public List<Salle> getSalles() {
		return salles;
	}
	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
}
