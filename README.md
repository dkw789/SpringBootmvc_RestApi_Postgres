# SpringBootmvc_RestApi_Postgres


Messaging_system__SpringBootmvc_RestApi_Postgres




Objective 1:

Create  web service to add a method to store text passed from the form into the database using MVC design pattern. In addition to saving the text, store the date and time when the when the data was saved.

Objective 2: Include the user info

Extend the form from Objective 1 to capture the user name and a list of all the submissions by user. Add another method to the service to return all text submissions and display them at the bottom of the page.

Objective 3: Replying to text

Extend your solution from Objective 2 to allow “responding” to already posted texts and display responses, indented, below the related text entry.

As always, extend your unit tests.

Objective 4: Capture more data

Capture user’s location (user enters the city) on the form. For every post, include city, city’s latitude and longitude and current temperature. Display this information on the form, next to each post.

Objective 5: Secure your application with https

Add https capability to the solution to Objective 4.



Implementation: 


URI			Method		Action

/Message		GET	"display all Message in JSON format"

/Message		POST	"Save or update  Message"

/Message/{id}		GET	"Display Message {id}"

/Message/greeting	GET	"Display Message form to fill in"

/Message/{id}		PUT	"Display update Message form for {id}"

/Message/{id}		DELETE	"Delete Message {id}"
		
/Message/greeting	POST	"Return Result posted"
		
/Message/Show		GET	"Listing, display all Messages"











p.s in order to enable https : 

You will need to generate a p12 key follow this tutorial for whole process:

http://blog.didierstevens.com/2008/12/30/howto-make-your-own-cert-with-openssl/

In order to use in in the spring application follow this tutorial:

https://www.drissamri.be/blog/java/enable-https-in-spring-boot/


Spring boot Reference;
https://spring.io/guides/gs/spring-boot/
