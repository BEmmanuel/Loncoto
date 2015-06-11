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
public class BatimentRest {
	
	private IBatimentDAO batimentDAO;
	
	public IBatimentDAO getBatimentDAO() {
		return batimentDAO;
	}

	public void setBatimentDAO(IBatimentDAO batimentDAO) {
		this.batimentDAO = batimentDAO;
	}

	@RequestMapping("/batiments")
	public @ResponseBody List<Batiment> getContents() {
		System.out.println("dans rest -> getContents");
		return getBatimentDAO().findAll();
	}

	@RequestMapping("/Batiments2")
	public @ResponseBody Batiment findContent2(@RequestParam(value="cid", defaultValue="1") int id) {
		return getBatimentDAO().findByID(id);
	}
	
	@RequestMapping("/batiments/{interventionId}")
	public @ResponseBody Batiment findContent(@PathVariable("interventionId") int id) {
		return getBatimentDAO().findByID(id);
	}
	
	@RequestMapping("/site/{clientId}/batiments")
	public @ResponseBody List<Batiment> getContents(@PathVariable("clientId") int id) {
		System.out.println("dans rest -> getContents");
		return getBatimentDAO().findBySiteId(id);
	}
}
