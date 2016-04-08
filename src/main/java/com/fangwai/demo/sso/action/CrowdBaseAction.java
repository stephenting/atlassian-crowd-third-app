package com.fangwai.demo.sso.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.atlassian.crowd.exception.ApplicationAccessDeniedException;
import com.atlassian.crowd.exception.ApplicationPermissionException;
import com.atlassian.crowd.exception.ExpiredCredentialException;
import com.atlassian.crowd.exception.InactiveAccountException;
import com.atlassian.crowd.exception.InvalidAuthenticationException;
import com.atlassian.crowd.exception.InvalidTokenException;
import com.atlassian.crowd.exception.OperationFailedException;
import com.atlassian.crowd.integration.AuthenticationState;
import com.atlassian.crowd.integration.http.CrowdHttpAuthenticator;
import com.atlassian.crowd.model.user.User;
import com.atlassian.crowd.service.client.CrowdClient;

public class CrowdBaseAction extends BaseAction{

	private static final long serialVersionUID = 9210276247543671577L;
	
	@Autowired protected CrowdClient crowdClient;
	@Autowired protected CrowdHttpAuthenticator crowdHttpAuthenticator;
	
	protected Boolean authenticated = null;
	protected User remoteUser;
	
	protected String getSessionUsername(){
		String username = (String)session.getAttribute("username");
		if(username == null){
			User user = getRemoteUser();
			if(user != null)
				return user.getName();
			else
				return null;
		}else{
			return username;
		}
	}
	
	protected void crowdLogin(String username, String password) {
		try {
			crowdHttpAuthenticator.authenticate(ServletActionContext.getRequest(), ServletActionContext.getResponse(), username, password);
		} catch (ExpiredCredentialException | InactiveAccountException | ApplicationPermissionException
				| InvalidAuthenticationException | OperationFailedException | ApplicationAccessDeniedException
				| InvalidTokenException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	protected void crowdLogout(){
		try {
			crowdHttpAuthenticator.logout(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		} catch (ApplicationPermissionException | InvalidAuthenticationException | OperationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected boolean isAuthenticated() {
        if (authenticated == null) {
            try {
                //authenticated = crowdHttpAuthenticator.isAuthenticated(ServletActionContext.getRequest(), ServletActionContext.getResponse());
            	AuthenticationState state = crowdHttpAuthenticator.checkAuthenticated(ServletActionContext.getRequest(), ServletActionContext.getResponse());
            	authenticated = state.isAuthenticated();
            }
            catch (Exception e) {
                authenticated = Boolean.FALSE;
            }
        }
        return authenticated;
    }
	
	protected User getRemoteUser(){
        if (!isAuthenticated())
            return null;
        if (remoteUser == null){
            try{
                // find the user from the authenticated token key.
                remoteUser = crowdHttpAuthenticator.getUser(ServletActionContext.getRequest());
            }
            catch (Exception e){
                e.printStackTrace();
            	//throw new InvalidAuthenticationException("", e);
            }
        }
        return remoteUser;
    }



}
