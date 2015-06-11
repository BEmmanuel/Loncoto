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
public class MaterielRest {
	
	private IMaterielDAO materielDAO;
	
	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}

	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}

	@RequestMapping("/materiels")
	public @ResponseBody List<Materiel> getContents() {
		System.out.println("dans rest -> getContents");
		return getMaterielDAO().findAll();
	}
	
	

	@RequestMapping("/materiels2")
	public @ResponseBody Materiel findContent2(@RequestParam(value="cid", defaultValue="1") int id) {
		return getMaterielDAO().findByID(id);
	}
	
	@RequestMapping("/materiels/{interventionId}")
	public @ResponseBody Materiel findContent(@PathVariable("interventionId") int id) {
		return getMaterielDAO().findByID(id);
	}
	
	@RequestMapping("/materiels/client/{interventionId}")
	public @ResponseBody List<Materiel> findClientContent(@PathVariable("interventionId") int id) {
		return getMaterielDAO().findByClientId(id);
	}
	
}
