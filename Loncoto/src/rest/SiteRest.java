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
public class SiteRest {
	
	private ISiteDAO siteDAO;
	
	public ISiteDAO getSiteDAO() {
		return siteDAO;
	}

	public void setSiteDAO(ISiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}

	@RequestMapping("/sites")
	public @ResponseBody List<Site> getContents() {
		System.out.println("dans rest -> getContents");
		return getSiteDAO().findAll();
	}

	@RequestMapping("/sites2")
	public @ResponseBody Site findContent2(@RequestParam(value="cid", defaultValue="1") int id) {
		return getSiteDAO().findByID(id);
	}
	
	@RequestMapping("/sites/{interventionId}")
	public @ResponseBody Site findContent(@PathVariable("interventionId") int id) {
		return getSiteDAO().findByID(id);
	}
	
	@RequestMapping("/site/{clientId}")
	public @ResponseBody List<Site> getContents(@PathVariable("clientId") int id) {
		System.out.println("dans rest -> getContents");
		return getSiteDAO().findByClientId(id);
	}
}
