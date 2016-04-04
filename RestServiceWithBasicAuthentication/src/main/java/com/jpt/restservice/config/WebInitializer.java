package com.jpt.restservice.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// here we will extends AbstractAnnotationConfigDispatcherServlet instead of WebApplicationInitializer
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{ApplicationConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		 return new Class<?>[]{SpringWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[]{"/"};
	}

}
