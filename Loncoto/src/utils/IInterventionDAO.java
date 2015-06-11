
package utils;

import java.util.List;

import beans.Intervention;

public interface IInterventionDAO {

	public List<Intervention> findAll();
	public Intervention findByID(int id);
	public Intervention save(Intervention intervention);

	public List<Intervention> find(int intervenantID, int materielID, int clientID);
	List<Intervention> findByIntervenant(int intervenantId);
	List<Intervention> findByGroup(int intervenantId);

}
