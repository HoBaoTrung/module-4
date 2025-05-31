package com.codegym.springuploadfile.configuration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[] { encodingFilter };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // Cấu hình Multipart
        registration.setMultipartConfig(new MultipartConfigElement(
                "webapp/WEB-INF/image",           // Thư mục để lưu hình
                10 * 1024 * 1024, // Kích thước tối đa của file: 10MB
                15 * 1024 * 1024, // Kích thước tối đa của request: 15MB
                1 * 1024 * 1024   // Ngưỡng lưu trữ file trên đĩa: 1MB
        ));
    }
}