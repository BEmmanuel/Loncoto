package utils;

import java.util.List;

import beans.Intervenant;
import beans.Utilisateur;

public interface IIntervenantDAO {

	public List<Intervenant> findAll();
	public Intervenant findByID(int id);
	public Utilisateur findByUsernameAndPassword(String login, String password);
	public Utilisateur save(Utilisateur intervenant);
	public List<Intervenant> findAllWitchIntervention();
	Utilisateur findUtilisateurByID(int id);
	List<Utilisateur> findAllUtilisateur();
}
