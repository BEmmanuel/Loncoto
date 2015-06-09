
package utils;

import java.util.List;

import beans.Intervention;

public interface IInterventionDAO {

	public List<Intervention> findAll();
	public Intervention findByID(int id);
	public Intervention save(Intervention intervention);
	public List<Intervention> findByIntervenant(int intervenantId);
}
