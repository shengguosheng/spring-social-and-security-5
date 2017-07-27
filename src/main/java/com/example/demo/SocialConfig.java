package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SocialConfig {

	@Bean
	@RequestScope
	public Facebook facebook() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication != null && authentication instanceof OAuth2AuthenticationToken) {
			OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
			return new FacebookTemplate(oauthToken.getAccessToken().getTokenValue());
		}
		return null; // ?? is this right ??
	}
	
}
