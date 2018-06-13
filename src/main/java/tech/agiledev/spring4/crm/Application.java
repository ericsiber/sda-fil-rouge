package tech.agiledev.spring4.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tech.agiledev.spring4.crm.dao.ClientJdbcDAO;
import tech.agiledev.spring4.crm.dao.CommandeJdbcDAO;
import tech.agiledev.spring4.crm.modele.Client;
import tech.agiledev.spring4.crm.modele.Commande;

public class Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		LOGGER.debug("Startup");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClientJdbcDAO dao = context.getBean(ClientJdbcDAO.class);
		for (Client c : dao.findAll()) {
			LOGGER.info(c.toString());
		}
		CommandeJdbcDAO daoCommande = context.getBean(CommandeJdbcDAO.class);
		for (Commande c : daoCommande.findAllByClientId(1L)) {
			LOGGER.info("" + c.getMontant());
		}
		context.close();
	}
}
