package com.fangwai.demo.sso.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;


@ParentPackage(value = "fangwai")


public class LoginoutAction extends CrowdBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7001203981345998836L;
	
	private String username;
	private String password;
	
	@Actions( { 
		@Action(value = "/login", results = { 
				@Result(location = "login.jsp", name = "success"),
		}) 
	})
	
	public String login(){
		System.out.println("login");
		return SUCCESS; 
	}
	
	@Actions( { 
		@Action(value = "/loginProc", results = { 
				@Result(location = "login.jsp", name = "input"),
				@Result(location = "main", type="redirectAction", name = "success"),
		}) 
	})
	
	public String loginProc(){
		session.setAttribute("username", username);
		return SUCCESS; 
	}
	
	public void validateLoginProc(){
		try {
			super.crowdLogin(username, password);
		} catch (Exception e) {
			this.addFieldError("error", e.getMessage());
		}
	}
	
	@Actions( { 
		@Action(value = "/main", results = { 
				@Result(location = "main.jsp", name = "success"),
		}) 
	})
	public String mainpage(){
		username = (String)session.getAttribute("username");
		return SUCCESS;
	}
	
	@Actions( { 
		@Action(value = "/logout", results = { 
				@Result(location = "login.jsp", name = "success"),
		}) 
	})
	
	public String logout(){
		super.crowdLogout();
		session.invalidate();
		return SUCCESS; 
	}
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
