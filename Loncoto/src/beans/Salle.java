package beans;

import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Salle {

	private int id;
	private int numeroSalle;
	private Etage etage_id;
	private List<Materiel> materiels;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroSalle() {
		return numeroSalle;
	}
	public void setNumeroSalle(int numeroSalle) {
		this.numeroSalle = numeroSalle;
	}
	@ManyToOne
	@JoinColumn(name="etage_id")
	public Etage getEtage_id() {
		return etage_id;
	}
	public void setEtage_id(Etage etage_id) {
		this.etage_id = etage_id;
	}
	
	
	public Salle() {this(0, 0);}
	public Salle(int id, int numeroSalle) {
		super();
		this.id = id;
		this.numeroSalle = numeroSalle;
	}
	
	
	@Override
	public String toString() {
		return "Salle [id=" + id + ", numeroSalle=" + numeroSalle + "]";
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="salle_id")
	public List<Materiel> getMateriels() {
		return materiels;
	}
	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}
	
}
