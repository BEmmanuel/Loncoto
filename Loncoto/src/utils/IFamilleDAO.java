package utils;

import java.util.List;

import beans.Famille;

public interface IFamilleDAO {

	public List<Famille> findAll();
	public Famille findByID(int id);
	public Famille save(Famille famille);
}
