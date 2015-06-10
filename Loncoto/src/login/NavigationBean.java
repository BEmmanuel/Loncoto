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
	
}