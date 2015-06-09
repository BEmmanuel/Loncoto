package utils;

import java.util.List;

import beans.Intervenant;

public interface IIntervenantDAO {

	public List<Intervenant> findAll();
	public Intervenant findByID(int id);
	public Intervenant findByUsernameAndPassword(String login, String password);
	public Intervenant save(Intervenant intervenant);
	public List<Intervenant> findAllWitchIntervention();
}
