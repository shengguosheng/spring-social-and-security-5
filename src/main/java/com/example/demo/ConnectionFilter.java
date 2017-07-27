package com.example.demo;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ConnectionFilter extends OncePerRequestFilter {

	public static final String AUTHORIZE_BASE_URI = "/oauth2/authorize/code";
	private static final String CLIENT_ALIAS_VARIABLE_NAME = "clientAlias";
	private static final String AUTHORIZE_URI = AUTHORIZE_BASE_URI + "/{" + CLIENT_ALIAS_VARIABLE_NAME + "}";
	private AntPathRequestMatcher authorizationRequestMatcher;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		this.authorizationRequestMatcher = new AntPathRequestMatcher(AUTHORIZE_URI);

		System.out.println(" ---> IN CONNECTION FILTER");
		
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			System.out.println(" ---> SECURITY CONTEXT IS NOT NULL");
			Authentication authentication = context.getAuthentication();
			System.out.println(" ---> GOT AUTHENTICATION:   " + authentication);
			if (authentication instanceof OAuth2AuthenticationToken) {
				OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
				System.out.println(" ---> TOKEN:  " + token.getAccessToken().getTokenValue());
			}
		}
		
		doFilter(request, response, filterChain);
		
		
	}

	protected boolean shouldProcessRequest(HttpServletRequest request, HttpServletResponse response) {
		return this.authorizationRequestMatcher.matches(request);
	}
	
}
