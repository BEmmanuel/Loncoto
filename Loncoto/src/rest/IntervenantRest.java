package rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class IntervenantRest {
	
	private IIntervenantDAO intervenantDAO;
	
	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}

	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		this.intervenantDAO = intervenantDAO;
	}

	@RequestMapping("/intervenants")
	public @ResponseBody List<Intervenant> getContents() {
		System.out.println("dans rest -> getContents");
		return getIntervenantDAO().findAll();
	}

	@RequestMapping("/intervenants2")
	public @ResponseBody Intervenant findContent2(@RequestParam(value="cid", defaultValue="1") int id) {
		return getIntervenantDAO().findByID(id);
	}
	
	@RequestMapping("/intervenants/{intervenantId}")
	public @ResponseBody Intervenant findContent(@PathVariable("intervenantId") int id) {
		return getIntervenantDAO().findByID(id);
	}
	
}
