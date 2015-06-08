package utils;

import java.util.List;

import beans.Groupe;

public interface IGroupeDAO {

	public List<Groupe> findAll();
	public Groupe findByID(int id);
	public Groupe save(Groupe groupe);
}
