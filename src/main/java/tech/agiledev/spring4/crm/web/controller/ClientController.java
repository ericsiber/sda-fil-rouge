package tech.agiledev.spring4.crm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

import tech.agiledev.spring4.crm.modele.Client;
import tech.agiledev.spring4.crm.service.ClientService;

@Controller
public class ClientController {

	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public View afficherClient(HttpServletRequest req) {
		String idStr = req.getParameter("id");
		Client client = clientService.findById(new Long(idStr));
		req.setAttribute("client", client);
		return new JstlView("/WEB-INF/pages/client.jsp");
	}

}
