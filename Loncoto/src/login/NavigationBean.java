package login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}
	
	public String toLogin() {
		return "/login.xhtml";
	}
	
	public String redirectToWelcome() {
		return "/secured/index.xhtml?faces-redirect=true";
	}
	
	public String toWelcome() {
		return "/secured/index.xhtml";
	}
	
	public String redirectToWelcomeAdmin() {
		return "/secured/adminAccueil.xhtml?faces-redirect=true";
	}
	
	public String toWelcomeAdmin() {
		return "/secured/adminAccueil.xhtml";
	}
	
	public String toAddUser() {
		return "/secured/addUser.xhtml";
	}

	
}
