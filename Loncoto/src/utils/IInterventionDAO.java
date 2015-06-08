package utils;

import java.util.List;

import beans.Intervention;

public interface IInterventionDAO {

	public List<Intervention> findAll();
	public List<Intervention> findByID(int id);
	public Intervention save(Intervention intervention);
}
