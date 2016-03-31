package com.gll.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import com.gll.controller.UserController;
import com.gll.service.UserService;
import com.gll.service.UserServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.gll" }, excludeFilters = {
		@Filter(type = FilterType.REGEX, pattern = "com.gll.security.*"),
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserServiceImpl.class),
		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserController.class) }, includeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserService.class) )
public class AppConfig extends WebMvcConfigurerAdapter {

	private static final Logger logger = Logger.getLogger(AppConfig.class);

	@Autowired
	WebApplicationContext context;

	@Autowired
	Environment environment;
/*
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				// .registry.addMapping("/api/**")
				// .allowedOrigins("http://domain2.com")
				.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("header1", "header2", "header3")
				.exposedHeaders("header1", "header2").allowCredentials(false).maxAge(3600);
	}*/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(false).defaultContentType(MediaType.APPLICATION_JSON_UTF8);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(jsonViewResolver());
		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}
	
	@Override
	 public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
	   configurer.enable();
	 }

}