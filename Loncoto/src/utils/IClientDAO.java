package utils;

import java.util.List;

import beans.Client;

public interface IClientDAO {
	
	public List<Client> findAll();
	public List<Client> findByID(int id);
	public Client save(Client client);
}
