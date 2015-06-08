package utils;

import java.util.List;

import beans.SousFamille;

public interface ISousFamilleDAO {

	public List<SousFamille> findAll();
	public SousFamille findByID(int id);
	public SousFamille save(SousFamille sousfamille);
}
