package jsf2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Component;

import beans.Intervention;
import utils.IInterventionDAO;


@Component
@ManagedBean
public class ListeBean {
	
	private IInterventionDAO interventionDAO;
	private List<Intervention> interventons;
	
	
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}

	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	
	

}
