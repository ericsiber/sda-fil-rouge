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
		webAppContext.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*.*\\.jar$");
		
		//4. Enabling the Annotation based configuration
		org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
        


		server.setHandler(webAppContext);

		server.start();
		LOGGER.debug("Web application ready");
		server.join();
	}
}
