package beans;


import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="2")
public class Intervenant extends Utilisateur {
	private Set<Intervention> interventions;
	private List<Groupe> groupes;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="intervenant_has_groupe",
		joinColumns={@JoinColumn(name="intervenant_id")},
		inverseJoinColumns={@JoinColumn(name="groupe_id")})
	public List<Groupe> getGroupes() {
		if(groupes == null)
			groupes = new ArrayList<Groupe>();
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	@OneToMany(mappedBy = "intervenant")
	public Set<Intervention> getInterventions() {
		if(interventions == null)
			interventions =  new HashSet<Intervention>();
		return interventions;
	}
	
	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	public void addIntervention(Intervention intervention) {
		if (intervention != null && !getInterventions().contains(intervention))
		{
			intervention.setIntervenant(this);
			getInterventions().contains(intervention);
		}
	}
}
