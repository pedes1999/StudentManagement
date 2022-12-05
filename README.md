# StudentManagement
This a Student Management System,where employees of a learning facility have the ability to manage the Students,Professors and Courses through a Graphical User Interface.

This is a lightweight full stack application where the backend was implemented with Jpa-Hibernate framework for manipulating the mySql Database,and Swing acting as a frontend.

The Backend was splitted into 3 layers:
The domain Layer is where are models are stored.
The repositories,which interact with the database to implement the CRUD functionality.
The services,which are the classes responsible for the business part of the application and the validation.

The frontend has a basic flow:
LoginForm,for the employee to sign in and have access to the system.
ChooseForm,where the employee can choose the entity to manage.
Dashboards created for each entity specifically and hold the CRUD functionality implemented in services.


The Employee has the ability:
Insert Students,Professor,Courses,
Edit Them.
Delete Them.
Get a snapshot of the database for each entity real-time.

To run the program:
Simply clone it,and run the StudentManagement.java
In the login form,the credentials are : username=admin , password = admin

Technologies used:
JPA-Hibernate
SDK-17
MySql Database
Swing for fronted
log4j for logging!

Thank you!
