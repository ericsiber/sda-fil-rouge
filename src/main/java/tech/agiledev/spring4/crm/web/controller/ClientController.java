package tech.agiledev.spring4.crm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String afficherClient(@RequestParam("id") Long idClient, Model model) {
		Client client = clientService.findById(idClient);
		model.addAttribute("client", client);
		return "client";
	}

}
