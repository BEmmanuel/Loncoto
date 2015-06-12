package jsf2;
import java.util.*;

import beans.*;
import utils.*;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;


@Component
@ManagedBean
@RequestScoped
public class IntervenantBean {
	private List<Intervention> interventions;
	private IInterventionDAO interventionDAO;
	
	
	public List<Intervention> getInterventions() {
		return getInterventionDAO().findByIntervenant(((Intervenant) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("user")).getId());
	}
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	
	
	
}
