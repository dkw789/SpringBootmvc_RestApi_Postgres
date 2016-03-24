# SpringBootmvc_RestApi_Postgres

Technology being used  :

Gradle
Spring 
Thymeleaf 
Postgres database (version 9.4)
H2 database



The URI structure :


URI				Method		Action

/Message			GET		Listing, display all Messages in JSON format

/Message/greeting		GET 		Display user form 

/Message/greeting		POST		Post data input from user form

/Message/{id}			GET		Display specific Message based on {id}

/Message/{id}			PUT		Update user data for {id}

/Message/{id}			DELETE		Delete user data for {id}

/Message/getText		GET		Returns text passed to it

/Message?user1={username}	GET		Retrieve messages posted from specific user




To run it :


1) Install Postgres SQL and create a database with name “test”
2) $ gradle clean build
3) Then to start either: 
 $ gradle run 
   or
 run it as a Springboot Application in your favorite ide
 





Spring boot Reference;
https://spring.io/guides/gs/spring-boot/
