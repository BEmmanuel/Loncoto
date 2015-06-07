package beans;

public class Site {

	private int id;
	private String nom;
	private String adresse;
	
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public Site() {this(0, "", "");}
	public Site(int id, String nom, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	
	
	@Override
	public String toString() {
		return "Site [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}	
	
}
