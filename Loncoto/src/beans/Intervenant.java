package beans;

public class Intervenant {

	private int id;
	private String nom;
	
	
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
	
	
	public Intervenant() {this(0, "");}
	public Intervenant(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	@Override
	public String toString() {
		return "Intervenant [id=" + id + ", nom=" + nom + "]";
	}
	
}
