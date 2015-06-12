package jsf2;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import utils.IIntervenantDAO;
import beans.*;

import java.util.*;

@Component
@ManagedBean
@SessionScoped
public class SessionBean {
	
	private Intervenant intervenant;
	private IIntervenantDAO intervenantDAO;
	private String login;
	private String password;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}

	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		this.intervenantDAO = intervenantDAO;
	}

	public Intervenant getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}
	
	

}
