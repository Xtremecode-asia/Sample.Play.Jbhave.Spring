Sample.Play.Jbhave.Spring
=========================

Play 2.0's sample app which integrates JBehave &amp; Spring frameworks.

Things to do before running the sample:
---------------------------------------
1. Install these following softwares in your machine:
  - JDK 7 with latest updates version.
  - Latest version of Play 2.1RC or above (www.playframework.org).
  - Git client
  - Intellij IDEA 11.x-12.x (Optional)
2. Open command line box & change directory to the Sample.Play.Jbehave.Spring.Client.
3. Type & enter: play clean compile

HOW TO - Run the unit test:
---------------------------
In the Sample.Play.Jbehave.Spring.Client directory (in command line mode), type & enter: play test.

HOW TO - Run the web app:
-------------------------
1. In the Sample.Play.Jbehave.Spring.Client directory, type & enter: play run (in command line mode). 
2. Open your browser and browse to: http://localhost:9000

HOW TO - Open Sample.Play.Jbehave.Spring.Client project on Intellij IDEA (11.x-12.x) :
--------------------------------------------------------------------------------------
1. Change directory to the Sample.Play.Jbehave.Spring.Client (in command line mode).  
2. Type & enter: play idea
3. Open the project using your Intellij IDEA.

The anatomy of Sample.Play.Jbehave.Spring.Client project:
---------------------------------------------------------
1. app folder - contains controllers & views packages. Each of the package contains the web's main controller (Application.java) & html page (index.scala.html).
2. conf folder - The place of where Play's config, routes & Spring module config file (application-context.xml) reside. 
3. test folder - Contains 1 test package at the moment (sample.play.jbehave.spring.service.math.spec) where JBehave story file, JUnitStory & steps classes reside.

HOW TO - Prove that the dependency injection is working in the JBehave Test ( Intellij IDEA 11.x-12.x):
-------------------------------------------------------------------------------------------------------
1. Open the Sample.Play.Jbehave.Spring.Client project on Intellij IDEA.
2. In the Project panel, rename the .jar library 'sample.play.jbehave.spring.services.jar' to 'sample.play.jbehave.spring.services.renamed'.
3. Run the JBehave unit test in the command line. Confirm that 'org.springframework.beans.factory.BeanCreationException' error happens.
4. Re-rename the .jar library in step #2 to its original name.
5. Re-run the JBehave unit test in the command line. Ensure that the test is passed.

Future TO-DOs:
--------------
1. Extend the sample to cover real-life problems or business processes (e.g. CRUD sample, Credentials check, report, etc)
2. And many more.

Reference links that inspired us creating this sample application:
------------------------------------------------------------------
1. "Dependency Injection with the Spring Framework - Tutorial" (http://bit.ly/MebzQd).
2. "JBehave - quick BDD example" (http://bit.ly/qk5WpW).
3. "Spring Module for Play 2.0" (http:http://bit.ly/TTK910)