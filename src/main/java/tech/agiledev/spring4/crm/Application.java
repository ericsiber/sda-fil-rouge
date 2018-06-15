package tech.agiledev.spring4.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import tech.agiledev.spring4.crm.dao.ClientJpaDAO;
import tech.agiledev.spring4.crm.modele.Client;
import tech.agiledev.spring4.crm.service.ClientService;

public class Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		LOGGER.debug("Startup");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		afficherClients(context);

		authenticateUser(context, "eric", "passwordDb");

		try {
			LOGGER.debug("Tentative de suppression d'un client et son adresse");
			ClientService service = context.getBean(ClientService.class);
			service.deleteClientById(1L);
			LOGGER.debug("Client et son adresse supprimés");
		} catch (NullPointerException e) {
			LOGGER.error("Problème lors de la suppression");
		}

		afficherClients(context);

		context.close();
	}

	private static void authenticateUser(AbstractApplicationContext context, String username, String password) {
		AuthenticationManager authManager = context.getBean(AuthenticationManager.class);
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = authManager.authenticate(authReq);
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(auth);
	}

	private static void afficherClients(ApplicationContext context) {
		ClientJpaDAO dao = context.getBean(ClientJpaDAO.class);
		LOGGER.debug("Liste des clients :");
		for (Client c : dao.findAll()) {
			LOGGER.debug(c.toString());
		}
	}
}
