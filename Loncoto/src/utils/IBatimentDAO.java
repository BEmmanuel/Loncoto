package utils;

import java.util.List;

import beans.Batiment;

public interface IBatimentDAO {
	
	public List<Batiment> findAll();
	public List<Batiment> findByID(int id);
	public Batiment save(Batiment batiment);
}
