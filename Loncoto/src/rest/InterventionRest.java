package rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.*;
import beans.*;


@Controller
public class InterventionRest {
	
	private IInterventionDAO interventionDAO;
	
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}

	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}

	@RequestMapping("/interventions")
	public @ResponseBody List<Intervention> getInterventions() {
		System.out.println("dans rest -> getContents");
		return getInterventionDAO().findAll();
	}
	
	@RequestMapping("/myInterventions")
	public @ResponseBody List<Intervention> getMyContents() {
		System.out.println("dans rest -> getContents");
		return getInterventionDAO().findByIntervenant(((Intervenant) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("user")).getId());
	}
	
	@RequestMapping("/myGroupInterventions")
	public @ResponseBody List<Intervention> getMyGroupContents() {
		System.out.println("dans rest -> getContents");
		return getInterventionDAO().findByGroup(((Intervenant) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("user")).getId());
	}

	@RequestMapping("/interventions2")
	public @ResponseBody Intervention findContent2(@RequestParam(value="cid", defaultValue="1") int id) {
		return getInterventionDAO().findByID(id);
	}
	
	@RequestMapping("/interventions/{interventionId}")
	public @ResponseBody Intervention findContent(@PathVariable("interventionId") int id) {
		return getInterventionDAO().findByID(id);
	}
	
	
	@RequestMapping("/myAndGroupeInterventions")
	public @ResponseBody List<Intervention> getMyAndGroupeInterventions() {
		System.out.println("dans rest -> getContents");
		return getInterventionDAO().findByIntervenantAndGroup(((Intervenant) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getAttribute("user")).getId());
	}
	
}
