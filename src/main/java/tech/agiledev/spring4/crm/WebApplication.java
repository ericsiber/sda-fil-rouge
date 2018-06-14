package tech.agiledev.spring4.crm;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		webAppContext.setResourceBase("src/main/webapp/");
		webAppContext.setContextPath("/crm");
		server.setHandler(webAppContext);

		server.start();
		LOGGER.debug("Web application ready");
		server.join();
	}
}
