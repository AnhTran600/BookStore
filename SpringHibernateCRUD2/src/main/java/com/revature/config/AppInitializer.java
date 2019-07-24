package com.revature.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext acwa = new AnnotationConfigWebApplicationContext();
		acwa.register(WebMvcConfig.class);
		acwa.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(acwa));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
