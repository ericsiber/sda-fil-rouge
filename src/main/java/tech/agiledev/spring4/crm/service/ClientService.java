package tech.agiledev.spring4.crm.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tech.agiledev.spring4.crm.dao.AdresseJdbcDAO;
import tech.agiledev.spring4.crm.dao.ClientJpaDAO;

@Service
public class ClientService {

	private ClientJpaDAO clientDAO;
	private AdresseJdbcDAO adresseDAO;
	
	@Autowired
	public ClientService(ClientJpaDAO clientDAO, AdresseJdbcDAO adresseDAO) {
		this.clientDAO = clientDAO;
		this.adresseDAO = adresseDAO;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor=NullPointerException.class)
	public void deleteClientById(Long id) {
		this.clientDAO.deleteByAdresseId(id);
		this.adresseDAO.deleteById(id);
	}
}
