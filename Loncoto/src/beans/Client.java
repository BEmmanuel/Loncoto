package beans;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.*;

@Entity
public class Client {

	private int id;
	private String nom;
	private String numeroTelephone;
	private String adresse;
	private Set<Site> sites;
	private Set<Materiel> materiels;
	
	@JsonIgnore
	@OneToMany(mappedBy="client_id")
	public Set<Materiel> getMateriels() {
		if(materiels == null)
			materiels = new HashSet<Materiel>();
		return materiels;
	}
	public void setMateriels(Set<Materiel> materiels) {
		this.materiels = materiels;
	}
	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.PERSIST, mappedBy="clients")
	public Set<Site> getSites() {return sites;}
	public void setUsers(Set<Site> sites) {this.sites = sites;}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
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
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public Client() {this(0, "", "", "");}
	public Client(int id, String nom, String numeroTelephone, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.numeroTelephone = numeroTelephone;
		this.adresse = adresse;
	}
	
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", numeroTelephone="
				+ numeroTelephone + ", adresse=" + adresse + "]";
	}
	
}
