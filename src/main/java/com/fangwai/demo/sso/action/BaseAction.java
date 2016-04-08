package com.fangwai.demo.sso.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletResponseAware,ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8394075053100670370L;
	
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected HttpSession session;

	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;	
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		session = request.getSession();	
		
	}

	
	


}
