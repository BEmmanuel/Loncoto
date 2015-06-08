package beans;

public class Batiment {

	private int id;
	private String nom;
	private Site site_id;
	
	
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
	public Site getSite_id() {
		return site_id;
	}
	public void setSite_id(Site site_id) {
		this.site_id = site_id;
	}
	
	
	public Batiment() {this(0, "");}
	public Batiment(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	
	@Override
	public String toString() {
		return "Batiment [id=" + id + ", nom=" + nom + "]";
	}
	
}
