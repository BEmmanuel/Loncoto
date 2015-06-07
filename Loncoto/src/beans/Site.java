package beans;

import java.io.Serializable;

import javax.persistence.*;
import java.util.*;

public class Site implements Serializable {

	private int id;
	private String nom;
	private String adresse;
	private Set<Client> clients;
	
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public Set<Client> getClients() {return clients;}
	public void setUsers(Set<Client> clients) {this.clients = clients;}
	
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
