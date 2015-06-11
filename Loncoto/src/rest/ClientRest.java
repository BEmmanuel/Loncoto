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
public class ClientRest {
	
	private IClientDAO clientDAO;
	
	public IClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@RequestMapping("/clients")
	public @ResponseBody List<Client> getContents() {
		System.out.println("dans rest -> getContents");
		return getClientDAO().findAll();
	}
	
	

	@RequestMapping("/clients2")
	public @ResponseBody Client findContent2(@RequestParam(value="cid", defaultValue="1") int id) {
		return getClientDAO().findByID(id);
	}
	
	@RequestMapping("/clients/{interventionId}")
	public @ResponseBody Client findContent(@PathVariable("interventionId") int id) {
		return getClientDAO().findByID(id);
	}
	
}
