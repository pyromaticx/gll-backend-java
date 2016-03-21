package com.gll.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.scribe.builder.api.LinkedInApi;
/*import org.scribe.builder.api.LinkedInApi;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.gll.bean.hrboost.Person;
import com.gll.configuration.security.OAuthServiceConfig;
import com.gll.configuration.security.OAuthServiceProvider;
import com.gll.controller.hrboost.FrontController;
import com.gll.viewResolvers.ExcelViewResolver;
import com.gll.viewResolvers.Jaxb2MarshallingXmlViewResolver;
import com.gll.viewResolvers.JsonViewResolver;
import com.gll.viewResolvers.PdfViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gll")
@PropertySource(value = { "classpath:social.properties" })
public class AppConfig extends WebMvcConfigurerAdapter {
	
	private static final Logger logger = Logger.getLogger(FrontController.class);

	@Autowired
	WebApplicationContext context;
	
	@Autowired
	Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
	
	/*
	 * Configure ContentNegotiationManager
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(false).defaultContentType(MediaType.TEXT_HTML);
	//	configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.APPLICATION_JSON_UTF8);
	}
	
	/*
	 * Configure ContentNegotiatingViewResolver
	 */
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		// Define all possible view resolvers
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		resolvers.add(jaxb2MarshallingXmlViewResolver());
		resolvers.add(jsonViewResolver());
		//resolvers.add(jspViewResolver());
		resolvers.add(pdfViewResolver());
		resolvers.add(excelViewResolver());
		resolvers.add(tilesViewResolver());
		
		resolver.setViewResolvers(resolvers);
		return resolver;
	}
	
	/*
	 * Configure View resolver to provide XML output Uses JAXB2 marshaller to
	 * marshall/unmarshall POJO's (with JAXB annotations) to XML
	 */
	@Bean
	public ViewResolver jaxb2MarshallingXmlViewResolver() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Person.class);
		return new Jaxb2MarshallingXmlViewResolver(marshaller);
	}

	/*
	 * Configure View resolver to provide JSON output using JACKSON library to
	 * convert object in JSON format.
	 */
	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	/*
	 * Configure View resolver to provide PDF output using lowagie pdf library to
	 * generate PDF output for an object content
	 */
	@Bean
	public ViewResolver pdfViewResolver() {
		return new PdfViewResolver();
	}

	/*
	 * Configure View resolver to provide XLS output using Apache POI library to
	 * generate XLS output for an object content
	 */
	@Bean
	public ViewResolver excelViewResolver() {
		return new ExcelViewResolver();
	}

	/*
	 * Configure View resolver to provide HTML output This is the default format
	 * in absence of any type suffix.
	 */
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/*Tiles Configuration for Templating */
	@Bean
    TilesViewResolver tilesViewResolver(){
    	TilesViewResolver tilesViewResolver = new TilesViewResolver();
        return tilesViewResolver;
    }
    
    @Bean
    TilesConfigurer tilesConfigurer(){
    	/*String arr[] = new String[] { 
    			context.getServletContext().getContextPath()+"/WEB-INF/views/tiles/tiles.xml",
    			context.getServletContext().getContextPath()+"/WEB-INF/views/tiles/person.xml",
    			context.getServletContext().getContextPath()+"/WEB-INF/views/tiles/index.xml",
    			context.getServletContext().getContextPath()+"/WEB-INF/views/tiles/login.xml"
    			};*/
    	String arr[] = new String[] { 
    			"WEB-INF/views/tiles/tiles.xml",
    			"WEB-INF/views/tiles/person.xml",
    			"WEB-INF/views/tiles/index.xml",
    			"WEB-INF/views/tiles/login.xml"
    			};
    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
    	tilesConfigurer.setDefinitions(arr);
    	tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
    	return tilesConfigurer;	
    }    
}