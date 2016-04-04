package com.gll.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private static final Logger logger = Logger.getLogger(HttpAuthenticationEntryPoint.class);
	
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		logger.info("************** : Entering HttpAuthenticationEntryPoint--> commence() " );
    	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    	logger.info("************** : Exiting HttpAuthenticationEntryPoint--> commence() " );
    }
}
