package login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final String[] users = {"root:1234"};
	
	private String username;
	private String password;
	
	private boolean connect;

	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;
	
	
	public String doLogin() {
		
		for (String user: users) {
			String dbUsername = user.split(":")[0];
			String dbPassword = user.split(":")[1];
			
			if (dbUsername.equals(username) && dbPassword.equals(password)) {
				connect = true;
				return navigationBean.redirectToWelcome();
			}
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
		this.navigationBean = navigationBean;
	}
	
}
