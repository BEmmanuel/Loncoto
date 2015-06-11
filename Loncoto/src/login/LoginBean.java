package login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import beans.Administrateur;
import beans.Utilisateur;
import utils.IIntervenantDAO;

@Component
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private String username;
	private String password;
	private IIntervenantDAO intervenantDAO;
	private boolean connect;
	private NavigationBean navigationBean;
	
	
	public String doLogin() {
		System.out.println("doLogin()");
		Utilisateur inter = getIntervenantDAO().findByUsernameAndPassword(username, password);
		System.out.println(inter);
		
		if (inter != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
			System.out.println("session dans dologin est : " + session);
			session.setAttribute("user", inter);
			connect = true;
			if(inter instanceof Administrateur)
				return navigationBean.toWelcomeAdmin();
			else
				return navigationBean.toWelcome();
		}
		
		FacesMessage msg = new FacesMessage("Login ou mot de passe incorrecte !", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return navigationBean.toLogin();
		
	}
	
	
	public String doLogout() {
		connect = false;
		return navigationBean.redirectToLogin();
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isConnect() {
		return connect;
	}

	public void setConnect(boolean connect) {
		this.connect = connect;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		System.out.println("navigationBean");
		this.navigationBean = navigationBean;
	}
	
	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}
	
	@Autowired
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		System.out.println("injection DAO");
		this.intervenantDAO = intervenantDAO;
	}

}
