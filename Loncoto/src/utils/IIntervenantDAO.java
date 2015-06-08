package utils;

import java.util.List;

import beans.Intervenant;

public interface IIntervenantDAO {

	public List<Intervenant> findAll();
	public List<Intervenant> findByID(int id);
	public Intervenant save(Intervenant intervenant);
}
