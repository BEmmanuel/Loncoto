package beans;
import javax.persistence.*;
import java.util.*;

@Entity
public class Intervenant {

	private int id;
	private String nom;
//	private String email;
//	private String password;
//	private String prenom;
	private Set<Intervention> interventions;
	private Set<Groupe> groupes;
	
	
//	public String getPrenom() {
//		return prenom;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}

	@ManyToMany
	@JoinTable(name="intervenant_has_groupe",
		joinColumns={@JoinColumn(name="intervenant_id")},
		inverseJoinColumns={@JoinColumn(name="groupe_id")})
	public Set<Groupe> getGroupes() {
		if(groupes == null)
			groupes = new HashSet<Groupe>();
		return groupes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	@OneToMany(mappedBy = "intervenant")
	public Set<Intervention> getInterventions() {
		if(interventions == null)
			interventions =  new HashSet<Intervention>();
		return interventions;
	}
	
	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	public void addIntervention(Intervention intervention) {
		if (intervention != null && !getInterventions().contains(intervention))
		{
			intervention.setIntervenant(this);
			getInterventions().contains(intervention);
		}
	}
	
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

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
}
