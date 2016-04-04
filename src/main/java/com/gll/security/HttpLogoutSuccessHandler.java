package com.gll.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class HttpLogoutSuccessHandler implements LogoutSuccessHandler {
    
	private static final Logger logger = Logger.getLogger(HttpLogoutSuccessHandler.class);
	
	@Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		logger.info("************** : Entering HttpLogoutSuccessHandler--> onLogoutSuccess() " );
		response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().flush();
        logger.info("************** : Exiting HttpLogoutSuccessHandler--> onLogoutSuccess() " );
    }
}
