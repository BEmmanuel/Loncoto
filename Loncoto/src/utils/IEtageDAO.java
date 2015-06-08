package utils;

import java.util.List;

import beans.Etage;

public interface IEtageDAO {

	public List<Etage> findAll();
	public List<Etage> findByID(int id);
	public Etage save(Etage etage);
}
