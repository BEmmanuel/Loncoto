package jsf2;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import utils.IIntervenantDAO;

import com.sun.faces.facelets.tag.jstl.core.SetHandler;


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
		if(getIntervenantDAO().findByUsernameAndPassword(getEmail(), getPassword()) != null) {
			return "index";
		} else {
			return "";
		}
	}
}
