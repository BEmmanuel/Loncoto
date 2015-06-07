package beans;

import java.util.ArrayList;
import java.util.List;

public class Site {
	private int id;
	private String nom;
	private String adresse;
	private List<Client> clients;
	private List<Batiment> batiments;
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
	public List<Client> getClients() {
		if(clients == null)
			clients = new ArrayList<Client>();
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Batiment> getBatiments() {
		if(batiments == null)
			batiments = new ArrayList<Batiment>();
		return batiments;
	}
	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}
	public Site(int id, String nom, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	public Site() {
		this(0, "", "");
	}
	
	
}
