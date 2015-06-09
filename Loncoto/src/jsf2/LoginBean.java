package jsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import beans.Intervenant;
import utils.IIntervenantDAO;


@Component
@ManagedBean
public class LoginBean {
	private String email;
	private String password;
	
	private IIntervenantDAO intervenantDAO;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public String login(){
		Intervenant u = getIntervenantDAO().findByUsernameAndPassword(getEmail(), getPassword());
		if(u != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", u);
			return "index";
		} else {
			return "";
		}
	}
}
