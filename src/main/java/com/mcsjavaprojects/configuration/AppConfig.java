package com.mcsjavaprojects.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mcsjavaprojects")
public class AppConfig extends WebMvcConfigurerAdapter { 
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}
	
		
	@Bean
    public JasperReportsViewResolver getJasperReportsViewResolver() {
        JasperReportsViewResolver viewresolver = new JasperReportsViewResolver();
        viewresolver.setPrefix("classpath:/reports/");
        viewresolver.setSuffix(".jrxml");       
        viewresolver.setReportDataKey("datasource"); 
        viewresolver.setViewNames("*_report");
        viewresolver.setViewClass(JasperReportsMultiFormatView.class);
        viewresolver.setOrder(1);
        return viewresolver;
    }

	
	/**
     * ResourceHandlers para acceder a CSS, JavaScript, etc.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
	
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("messages");
	    return messageSource;
	}
	
	 
	    
}

