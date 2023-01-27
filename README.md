# Group-12
HR-Employee Project
Project Description:

We are creating a human resource and employee portal for SAKK Company and the name of the portal is “Mini Ultimatix”
It can serve as an internal gateway for the company’s employees to access their own details by logging in as an employee. The portal can also be accessed by the HR in order to view, update and edit the details of all the employees.
Mini Ultimatix can be accessed in 2 main ways:

**1.	HR Login**

**2.	Employee Login**

One can login to the portal by using the:
	
•	Username
•	Password

( Where username is nothing but the employee id of the employee/hr)
 
 There are two main features which Mini Ultimatix offers namely:
 
•	**Personal Details**

•	**Work Details**

(Each having 5 and 4 sub-features respectively as of now)


**	HR Login**

The HR has been granted some special privileges:

•	HR can register a new employee and fill in his details by clicking on “Register here”

•	HR can login to the portal using his own employee ID as username and password

•	Next after logging in he can view all the details of each and every employee and update or delete the same as and when required.

**	Employee Login**

The employee on the other hand has few/limited privileges:

•	He can enter into the portal using the username and password created by the HR

•	Next he is allowed to only view his own specific details and edit only few of them

 Technologies used:

The overall project is designed using the MVC pattern (MVC i.e. Model, View, and Controller). In the Backend, it is using Spring Boot, at the data access layer the project is using Hibernate Framework, and at the front end, we are using HTML and CSS. The Database used here is PostgreSQL.
       
       Tools and Technologies Used
       Front-End:   Html, CSS, and JS. 
       Server-side: Spring Boot. 
       Back-end:    PostgreSQL, Hibernate.
       Server:      Tomcat 4.0.
       
**How to run the project?**

The entire application is run in Spring Tools Suite.

**Steps:**

•	Downloading the Employee-Portal-WebApp zip file from github

•	Extract the files in the local system

•	Open STS and import the entire file from local system

•	After importing, open the main method and run as spring boot app

•	Wait for the console to show “Tomcat started successfully”

•	Open web browser and in the search bar type: localhost:8081/ashwin/login

•	The login page of “Mini Ultimatix” will open

•	Under the HR Portal Sign in:

 					 Type in Username as: 123456

                               	 Type in Password as: 441466
									 
•	Employee Details’ Index will open

•	Click on “Personal Details” button to view the personal details of every employee and “Work Details” button to view the work details of every employee

•	The HR can update and delete the details of every employee by clicking on “update” and “delete” buttons in the table under “Actions” field.

•	Click on “Logout” which in present in the upper left corner of the navigation bar

•	We can login to Mini Ultimatix by logging in as an employee 

•	For that under Employee Portal Sign in:

						 Type in Username as: Employee ID from the already registered employee list.(E.g: 42421,42422)
												 
                                          	 Type in Password as: 466441
												 
•	We are able to login to the employee portal but unable to display specific details mapped to specific employee

•	In order to view the same, we can go to the browser and in the search bar type:
											
						 localhost:8081/ashwin/emplogin/getemppersonal/42421(Keep replacing 42421 with specific employee id)
