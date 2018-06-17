package tech.agiledev.spring4.crm.web.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tech.agiledev.spring4.crm.jmx.OperationCounter;
import tech.agiledev.spring4.crm.modele.Client;
import tech.agiledev.spring4.crm.service.ClientService;

@RestController
public class ClientRestController {

	private ClientService clientService;
	
	private OperationCounter operationCounter;

	@Autowired
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@Autowired(required = false)
	public void setOperationCounter(OperationCounter operationCounter) {
		this.operationCounter = operationCounter;
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

	// équivalent à @RequestMapping(value = "/clients/{clientId}", method =
	// {RequestMethod.DELETE})
	@DeleteMapping(value = "/clients/{clientId}")
	public HttpStatus removeClient(@PathVariable("clientId") Long id) {
		clientService.deleteClientById(id);
		if (operationCounter != null) {
			operationCounter.incrementDelete();
		}
		return HttpStatus.OK;
	}

	@PostMapping(value = "/clients")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		clientService.createClient(client);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId())
				.toUri();
		if (operationCounter != null) {
			operationCounter.incrementAdd();
		}
		return ResponseEntity.created(location).build();
	}

}
