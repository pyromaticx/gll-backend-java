/*package com.gll.controller.hrboost;

import static com.gll.controller.hrboost.SessionAttributes.ATTR_OAUTH_ACCESS_TOKEN;
import static com.gll.controller.hrboost.SessionAttributes.ATTR_OAUTH_REQUEST_TOKEN;
import static org.springframework.web.context.request.RequestAttributes.SCOPE_SESSION;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gll.configuration.OAuthServiceProvider;

@Controller
public class LinkedInController {
	
	@Autowired
	//@Qualifier("linkedInServiceProvider")
	private OAuthServiceProvider linkedInServiceProvider;
	
	@RequestMapping(value={"/login-linkedin"}, method = RequestMethod.GET)
	public String login(WebRequest request) {
		
		// getting request and access token from session
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		Token accessToken = (Token) request.getAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
		if(requestToken == null || accessToken == null) {
			// generate new request token
			OAuthService service = linkedInServiceProvider.getService();
			requestToken = service.getRequestToken();
			request.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, requestToken, SCOPE_SESSION);
			
			// redirect to linkedin auth page
			return "redirect:" + service.getAuthorizationUrl(requestToken);
		}
		return "person.html";
	}
	
	@RequestMapping(value={"/linkedin-callback"}, method = RequestMethod.GET)
	public ModelAndView callback(@RequestParam(value="oauth_verifier", required=false) String oauthVerifier, WebRequest request) {
		
		// getting request tocken
		OAuthService service = linkedInServiceProvider.getService();
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		
		// getting access token
		Verifier verifier = new Verifier(oauthVerifier);
		Token accessToken = service.getAccessToken(requestToken, verifier);
		
		// store access token as a session attribute
		request.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken, SCOPE_SESSION);
		
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "http://api.linkedin.com/v1/people/~:(id,first-name,last-name,industry,headline)");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		System.out.println(oauthResponse.getBody());

		ModelAndView mav = new ModelAndView("redirect:loginPage");
		return mav;
	}
}*/