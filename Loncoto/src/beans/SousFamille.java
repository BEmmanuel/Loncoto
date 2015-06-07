package beans;

public class SousFamille {
	
	private int id;
	private String nom;
	private Famille famille_id;
	
	
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
	public Famille getFamille_id() {
		return famille_id;
	}
	public void setFamille_id(Famille famille_id) {
		this.famille_id = famille_id;
	}
	
	
	public SousFamille() {this(0, "");}
	public SousFamille(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	
	@Override
	public String toString() {
		return "SousFamille [id=" + id + ", nom=" + nom + ", famille_id="
				+ famille_id + "]";}
	
	
}
