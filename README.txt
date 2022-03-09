Project Title:  GCO Provider

Description:
GCO Provider is a basic and easy to use, Information Sytem with GUI. It is designed for 
companies selling subscriptions for internet connection. 

The program consist of 2 parts: Customer and Service Provider. In service 
provider section you can add a new service provider or choose from an 
existing one. There are two types of service providers for now: GSM and Cable 
Providers. You can add as many subscription plan as you want to the selected
service provider. The available subscription plans can be seen on the panel 
labeled as Subscription Plans. You can change the subscription plans and 
provider's name whenever you want. There will be no information lost. 

In the second part the program keeps track of the existing and possible 
customers. To create a possible customer, the only thing you need 
is his/her citizenship number. You can also add or change e-mail,
telephone number and name of the customer whenever you want after creation. If 
the customer wants to get a subscription, he just need to find an appropriate 
one from subscription plans page and enter a date in customer panel. After 
signing up for a subscription, the customer's information is upgraded to 
existing customers.

NOT: The citizenship number of the customer could not be changed. If tried
you will get a warning.


Requirments:
To run the Test, jUnitTest 4 or higher and hamcrast core is required.



Used Libraries:
Java Swing, Java Awt, Java util 


Compilation and Running on Command Line:

The program is tested with open-jdk 11 and open-jdk 15. Thus it is recomended
to use one of them. The java files already compiled with open-jdk 11 and can be found in bin folder. 

If you want to compile by yourself, follow the steps given below:

Install one of the versions of the open-jdk to the source folder.
Compile the InformationSystem.java file by using: 
javac InformationSystem.java

The Compilation will result in an executable file calledInformationSystem.class.
Then you can run the program by using:
java InformationSystem to the terminal.


//Tests
In order to compile and run the tests download jUnitTest 4 or higher 
and hamcrast core from https://github.com/junit-team/junit4/wiki/Download-and-Install
to the source directory of the program. 

In Unix:
TestAll.java is responsible for running all the tests currently available.

To compile all of the tests use:
javac -cp junit-4.13.2.jar:. TestAll.java

To run the tests use:
java -cp junit-4.13.2.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore TestAll

In Windows:
Change the : with ; and apply the steps shown above.




