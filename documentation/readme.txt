Since we were unable to get the application to work on a deployed machine, below are some installation instructions.

1. MySQL

Use the mysql import util (either through command-line or through mysql workbench and import:

cs673_export.sql - this is located in the ProManageDAO\sql directory. It will create the schema as well as all associated users.


2. Tomcat

In order to use container managed authentication/authorization 2 things need to happen with tomcat.

a. Add the following line to server.xml. It should be under the defaultHost="localHost" engine. I have attached a copy of our server.xml for reference.

<Realm className="org.apache.catalina.realm.JDBCRealm" connectionName="cs673_user" connectionPassword="cs673" connectionURL="jdbc:mysql://localhost/cs673" digest="SHA-512" driverName="com.mysql.jdbc.Driver" roleNameCol="rolename" userCredCol="password" userNameCol="username" userRoleTable="cs673.user_roles" userTable="cs673.user"/>

b. The mysql-connector-java-5.1.20-bin.jar needs to be added to the tomcat "install dir"/lib. For me this was located in:

C:\Program Files\Apache Software Foundation\Tomcat 7.0\lib  - (based off of a default install)


3. Build the project using the ant script and/or just right-click on the project from eclipse and export/war. I have attached
a copy of the latest as of what is hopefully the final submission in this directory.

ProManage.war

4. Access the website.

http://localhost:8080/ProManageREST/