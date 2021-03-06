package utils;

import java.util.List;

import beans.Salle;

public interface ISalleDAO {

	public List<Salle> findAll();
	public Salle findByID(int id);
	public Salle save(Salle salle);
}
