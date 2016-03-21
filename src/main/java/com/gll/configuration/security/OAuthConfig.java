package com.gll.configuration.security;

import org.scribe.builder.api.FacebookApi;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.builder.api.TwitterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "com.gll.configuration.security")
public class OAuthConfig {


	@Autowired
	Environment environment;
	
	@Bean
	public OAuthServiceConfig getOAuthLinkedInServiceConfig() {
		OAuthServiceConfig linkedInServiceConfig = new OAuthServiceConfig();
		linkedInServiceConfig.setApiKey(environment.getRequiredProperty("app.config.oauth.linkedin.apikey"));
		linkedInServiceConfig.setApiSecret(environment.getRequiredProperty("app.config.oauth.linkedin.apisecret"));
		linkedInServiceConfig.setCallback(environment.getRequiredProperty("app.config.oauth.linkedin.callback"));
		linkedInServiceConfig.setApiClass(LinkedInApi.class);
		return linkedInServiceConfig;
	}

	@Bean
	public OAuthServiceProvider getOAuthLinkedInServiceProvider() {
		OAuthServiceProvider linkedInServiceProvider = new OAuthServiceProvider(getOAuthLinkedInServiceConfig());
		return linkedInServiceProvider;

	}
	
	/*@Bean
	public OAuthServiceConfig getOAuthFacebookServiceConfig() {
		OAuthServiceConfig facebookServiceConfig = new OAuthServiceConfig();
		facebookServiceConfig.setApiKey(environment.getRequiredProperty("app.config.oauth.linkedin.apikey"));
		facebookServiceConfig.setApiSecret(environment.getRequiredProperty("app.config.oauth.linkedin.apisecret"));
		facebookServiceConfig.setCallback(environment.getRequiredProperty("app.config.oauth.linkedin.callback"));
		facebookServiceConfig.setApiClass(FacebookApi.class);
		return facebookServiceConfig;
	}

	@Bean
	public OAuthServiceProvider getOAuthFacebookServiceProvider() {
		OAuthServiceProvider facebookServiceProvider = new OAuthServiceProvider(getOAuthFacebookServiceConfig());
		return facebookServiceProvider;

	}
	
	@Bean
	public OAuthServiceConfig getOAuthTwitterServiceConfig() {
		OAuthServiceConfig twitterServiceConfig = new OAuthServiceConfig();
		twitterServiceConfig.setApiKey(environment.getRequiredProperty("app.config.oauth.linkedin.apikey"));
		twitterServiceConfig.setApiSecret(environment.getRequiredProperty("app.config.oauth.linkedin.apisecret"));
		twitterServiceConfig.setCallback(environment.getRequiredProperty("app.config.oauth.linkedin.callback"));
		twitterServiceConfig.setApiClass(TwitterApi.class);
		return twitterServiceConfig;
	}

	@Bean
	public OAuthServiceProvider getOAuthTwitterServiceProvider() {
		OAuthServiceProvider twitterServiceProvider = new OAuthServiceProvider(getOAuthTwitterServiceConfig());
		return twitterServiceProvider;

	}
*/}
