package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import beans.Client;

public class ClientDAO implements IClientDAO {
	
	private EntityManager em;
	
	
	public EntityManager getEm() {
		return em;
	}
	
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public List<Client> findAll() {
		return em.createQuery("from Client",Client.class).getResultList();
	}

	@Override
	@Transactional
	public Client findByID(int id) {
		return em.find(Client.class, id);
	}

	@Override
	@Transactional
	public Client save(Client client) {
		if (client == null)
			return client;
		if (client.getId() == 0)
		{
			em.persist(client);
		}
		else
		{
			client = em.merge(client);
		}
		return client;
	}

}
