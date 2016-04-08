package com.whyonly.crowd;

import com.atlassian.crowd.embedded.api.PasswordCredential;
import com.atlassian.crowd.exception.ApplicationPermissionException;
import com.atlassian.crowd.exception.GroupNotFoundException;
import com.atlassian.crowd.exception.InvalidAuthenticationException;
import com.atlassian.crowd.exception.InvalidCredentialException;
import com.atlassian.crowd.exception.InvalidUserException;
import com.atlassian.crowd.exception.OperationFailedException;
import com.atlassian.crowd.integration.rest.entity.MultiValuedAttributeEntityList;
import com.atlassian.crowd.integration.rest.entity.UserEntity;
import com.atlassian.crowd.integration.rest.service.factory.RestCrowdClientFactory;
import com.atlassian.crowd.integration.rest.util.EntityTranslator;
import com.atlassian.crowd.model.group.Group;
import com.atlassian.crowd.model.user.User;
import com.atlassian.crowd.service.client.CrowdClient;
import com.atlassian.crowd.service.factory.CrowdClientFactory;

public class CrowdTest {
	
	public static void main(String[] argv){
		String url = "http://localhost:8095/crowd";
		String applicationName = "pigeon";
		String applicationPass = "n0thing";
		CrowdClient client = new RestCrowdClientFactory().newInstance(url, applicationName , applicationPass);
		try {
			Group group = client.getGroup("pigeon");
			System.out.println(group);
			createUser(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	private static void createUser(CrowdClient client) throws Exception {	
		//client.d
		//UserEntity user = new UserEntity("stephen_ding","Stephen","Ding","Stephen Ding","stephen_ding@apollobizctr.com",null,true,null);
		//PasswordCredential pc = new PasswordCredential("secret");
		//client.addUser(user, pc);
		//User db_user = client.getUser("stephen_ding");
		//client.updateUserCredential("stephen_ding", "7F6CD2828E66B33BE44A9EBC1FD430C1");
		System.out.println(client.authenticateUser("stephen_ding", "7F6CD2828E66B33BE44A9EBC1FD430C1"));
		
		//UserEntity userEntity = new UserEntity(db_user.getName(), null, null, db_user.getDisplayName(),
		//		"stephen@apollobizctr.com", null, db_user.isActive(), db_user.getExternalId(), false);
		//client.updateUser(userEntity);
		//User auth_user = client.authenticateUser("stephen_ding", "secret");
		//System.out.println(client.getGroupsForUser("stephen_ding", 0, 100));
		//client.addUserToGroup("stephen_ding", "jira");
		//client.addUserToGroup("stephen_ding", "pigeon");
		//client.removeUserFromGroup("stephen_ding", "pigeon");
		//System.out.println(auth_user);
		
	}

}
