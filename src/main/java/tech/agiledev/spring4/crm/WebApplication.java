package tech.agiledev.spring4.crm;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebApplication {
	public static void main(String[] args) throws Exception {
		Server server = new Server(80);

		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		webAppContext.setResourceBase("src/main/webapp/");
		webAppContext.setContextPath("/servlet-rest-service");
		server.setHandler(webAppContext);

		server.start();
		server.join();
	}
}
