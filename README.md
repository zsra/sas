# sas
School Administration System 


-- RUN ---

Before you start running this application, you most have a MySQL server and "enaplodb" database.
If you are using different user/password then the default settings in the MySQL server, you have to change the 

<b>spring.datasource.username</b>=<i>user</i></br>
<b>spring.datasource.password</b>=<i>password</i>

in the enaplo > src > main > resources > application.properties configuration file.  

________________________________________________________________________________________________________________

If you don't want init data you can set in
sas/enaplo/src/main/java/hu/zsra/enaplo/InitData.java by turning into a comment the the testData() method 
in the line 55.
________________________________________________________________________________________________________________

commands to run:

<b>Back-end: enaplo > mvn spring-boot:run</b> </br>
<b>Front-end: enaplo-app > ng serve --open</b>
________________________________________________________________________________________________________________

Default admin user login: admin/admin</br>
Default student user login: student[0-20]/student</br>
Default teacher user login: teacher[0-8]/teacher


