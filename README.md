# atlassian-crowd-third-app
Integrate Crowd with Third Application 

Step1:
Login Atlassian Crowd by admin and create a third Application from Applications > Add application.
Record the ${Name} & ${Password}

Step2:
Edit src/main/resources/crowd.properties and change the property values as your case. eg.

application.name=crowdsso
application.password=password
application.login.url=http://localhost:8080/crowdsso
crowd.base.url=http://localhost:8095/crowd/
session.isauthenticated=session.isauthenticated
session.tokenkey=session.tokenkey
session.validationinterval=0
session.lastvalidation=session.lastvalidation

Step3:
Deploy the application to tomcat

URL http://localhost:8080/crowdsso

