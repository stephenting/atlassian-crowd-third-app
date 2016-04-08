<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
    	<title>Crowd SSO 登录</title>
    </head>
    <body>
        
        <div>
        	<h1>Crowd SSO 登录</h1>
        	<s:fielderror escape="false"/>
        	<s:form action="loginProc"> 
        		<table>
        			<tr>
        				<td>用户名：</td>
        				<td><s:textfield name="username" /></td>
        			</tr>
        			<tr>
        				<td>密码：</td>
        				<td><s:password name="password" /></td>
        			</tr>
        			
        			<tr>
        				<td colspan="2"><s:submit name="Submit"/></td>
        			</tr>
        		</table> 
        	
        	</s:form>
        	
        	<p/><p/>
        	<h4><a href="http://localhost:8095/crowd">访问Crowd (http://localhost:8095/crowd)</a></h4>
        	
        
        </div>
        
        
	</body>	
</html>