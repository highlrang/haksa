package com.myproject.myweb.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// AbstractAnnotationConfigDispatcherServletInitializer 내부에서 WebApplicationInitializer의 startUp, registDispatcherServlet 포함

public class SpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?> [] {
            RootConfig.class,
            SecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?> [] {
            MvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; //
    }
   
    @Override
    protected Filter[] getServletFilters() {
    	CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
    	encodingFilter.setEncoding("UTF-8");
    	encodingFilter.setForceEncoding(true);
    	return new Filter[] {encodingFilter};
    }

 

}