package com.whyonly.crowd;

import com.atlassian.crowd.integration.http.CrowdHttpAuthenticator;
import com.atlassian.crowd.service.client.ClientProperties;

public class CrowdSecurityFilter extends com.atlassian.crowd.integration.http.filter.CrowdSecurityFilter{

	public CrowdSecurityFilter(CrowdHttpAuthenticator httpAuthenticator, ClientProperties clientProperties) {
		super(httpAuthenticator, clientProperties);
	}
	
	@Override
	public void doFilter(
		      javax.servlet.ServletRequest servletRequest,
		          javax.servlet.ServletResponse servletResponse,
		          javax.servlet.FilterChain filterChain) 
		          throws java.io.IOException,
		          javax.servlet.ServletException {
		System.out.println("--CrowdSecurityFilter");
		super.doFilter(servletRequest, servletResponse, filterChain);
	}
	
	

}
