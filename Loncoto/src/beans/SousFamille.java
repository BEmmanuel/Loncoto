package beans;

public class SousFamille {
	
	private int id;
	private String nom;
	private Famille famille;
	
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
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	public SousFamille(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public SousFamille() {
		this(0, "");
	}
	@Override
	public String toString() {
		return "SousFamille [id=" + id + ", nom=" + nom + ", famille="
				+ famille + "]";
	}
	
	
	
}
