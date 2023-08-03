package com.danilermolenko.spring.mvc_rest_hibernate.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaWeb extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{JavaApplication.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
