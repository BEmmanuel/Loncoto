package utils;

import java.util.List;

import beans.Materiel;

public interface IMaterielDAO {

	public List<Materiel> findAll();
	public Materiel findByID(int id);
	public Materiel save(Materiel materiel);
	public List<Materiel> findAllWithIntervention();
	public List<Materiel> findByClientId(int id);
}
