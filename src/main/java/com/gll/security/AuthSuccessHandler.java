package com.gll.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gll.model.User;

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger logger = Logger.getLogger(AuthSuccessHandler.class);
    
	@Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	logger.info("************** : Entering AuthSuccessHandler--> onAuthenticationSuccess() " );
    	response.setStatus(HttpServletResponse.SC_OK);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        userDetails.setUser(user);

        logger.info(userDetails.getUsername() + " got is connected ");

        PrintWriter writer = response.getWriter();
        ObjectMapper mapper= mappingJackson2HttpMessageConverter.getObjectMapper();
        mapper.writeValue(writer, user);
        writer.flush();
        logger.info("************** : Exiting AuthSuccessHandler--> onAuthenticationSuccess() " );
    }
}
