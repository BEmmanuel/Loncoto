package utils;

import java.util.List;

import beans.Client;
import beans.Intervenant;

public interface IClientDAO {
	
	public List<Client> findAll();
	public Client findByID(int id);
	public Client save(Client client);
	public List<Client> findAllWitchIntervention();
}
