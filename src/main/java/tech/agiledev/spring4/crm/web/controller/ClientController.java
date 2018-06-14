package tech.agiledev.spring4.crm.web.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.agiledev.spring4.crm.modele.Client;
import tech.agiledev.spring4.crm.service.ClientService;

@Controller
public class ClientController {

	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@RequestMapping("/client")
	public void afficherClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String idStr = req.getParameter("id");
		Client client = clientService.findById(new Long(idStr));
		ServletOutputStream os = resp.getOutputStream();
		os.println("<html><head><title>Affichage client</title></head><body>");
		os.println("<p>Nom : " + client.getNom());
		os.println("<br/><p>Prénom : " + client.getPrenom());
		os.println("</body></html>");
	}
	
}
