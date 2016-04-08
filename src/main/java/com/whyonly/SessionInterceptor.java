package com.whyonly;


import java.util.stream.Stream;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.atlassian.crowd.integration.AuthenticationState;
import com.atlassian.crowd.integration.http.CrowdHttpAuthenticator;
import com.atlassian.crowd.service.client.CrowdClient;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class SessionInterceptor extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3965995894844751153L;
	
	private static final Log log = LogFactory.getLog(SessionInterceptor.class);
	
	@Autowired protected CrowdClient crowdClient;
	@Autowired protected CrowdHttpAuthenticator crowdHttpAuthenticator;
	 
	
	private final static String[] ignorePages = new String[]{"/login","/loginProc","/logout"};
	
	public String intercept(ActionInvocation invocation)
		throws Exception{

		//System.out.println("--SessionInterceptor");
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		final String servletPath = attr.getRequest().getServletPath();
		final String methodName = servletPath.substring(0, servletPath.indexOf("."));
		if(Stream.of(ignorePages).anyMatch( page -> methodName.equals(page))){
			return invocation.invoke();
		}else{
			AuthenticationState state = crowdHttpAuthenticator.checkAuthenticated(ServletActionContext.getRequest(), ServletActionContext.getResponse());
			if(state.isAuthenticated())
				return invocation.invoke();
			else
				return "login";
				
		}	
	}

	
}

