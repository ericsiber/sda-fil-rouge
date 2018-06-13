package tech.agiledev.spring4.crm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tech.agiledev.spring4.crm.dao.ClientJpaDAO;
import tech.agiledev.spring4.crm.modele.Client;

public class Application {

	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		LOGGER.debug("Startup");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		List<Client> clients = context.getBean(ClientJpaDAO.class).findAll();
		for (Client client : clients) {
			LOGGER.info(client.toString());
		}
		
		context.close();
	}
}
