package dta.spring.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer{

	private static final Logger LOG = Logger.getLogger(WebAppInitializer.class.getName());
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOG.log(Level.INFO, "demarrage du serveur");
		// Initialisation du contexte Spring
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(PizzeriaSpringWebConfig.class);
		
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		/*
		<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/api</url-pattern>
		</servlet-mapping>
		*/
		dispatcher.addMapping("/mvc/api/*");
		/*
		<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		*/
		servletContext.addListener(new ContextLoaderListener(webContext));
		
	}

}