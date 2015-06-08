package beans;

public class Salle {

	private int id;
	private int numeroSalle;
	private Etage etage_id;
	
	
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
	
}
