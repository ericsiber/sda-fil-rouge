package tech.agiledev.spring4.crm.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.agiledev.spring4.crm.modele.Client;
import tech.agiledev.spring4.crm.service.ClientService;

@RestController
public class ClientRestController {

	private ClientService clientService;
	
	@Autowired
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@RequestMapping(value = "/clients")
	public List<Client> listeClients() {
		return this.clientService.findAll();
	}
	
	@RequestMapping(value = "/clients/{clientId}")
	public ResponseEntity<Client> getClient(@PathVariable("clientId") Long id) {
		try {
			return new ResponseEntity<Client>(this.clientService.findById(id), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
	}
	
	//équivalent à @RequestMapping(value = "/clients/{clientId}", method = {RequestMethod.DELETE})
	@DeleteMapping(value = "/clients/{clientId}")
	public HttpStatus removeClient(@PathVariable("clientId") Long id) {
		clientService.deleteClientById(id);
		return HttpStatus.OK;
	}
	
}
