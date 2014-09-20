AliensOnTheEarth
================

A treaty of friendship has been signed between Aliens and Humans. The aliens are now welcome on Earth and can stay as long as they wish with the Humans. This Application is responsible to register the aliens and Generate Reports


There are mainly two parts of the application. 

1. Alien Registration
2. Report Generation

Technology Stack

1. Spring 4.0.6
   a. Dependency Injection
2. Hibernate 4
   a. Database Interaction
3. Jasper Reports
   a. PDF Generation
4. SQLite
   a. Database
5. Java 7


Kindly Refer to the Class Diagram for overall Structure of the application. 

Configuration

1. Hibernate

Hibernate Configuration needs to be done in spring-config.xml file.

2.Spring

Currently Application uses spring-config.xml file through classpath, the same can put in external file location to change it dynamically. 

3. Jasper

There is no special configuration required for Jasper. 
It only requires Pdf Template path, which needs to be configured inside Spring config file inside PDFReportGenerator Bean.

Same is the case with output pdf and text file.
path needs to be given as property for the respective beans.

4. Dynamic Report Format. 

The list of available report formats need to be configured in ReportFormatMapper Bean.

Currently Application supports two format
1. Text
2. PDF

Tomorrow suppose there is a third format foobar, then following steps should be configured without changing any code.

1. FooBar Class should implement IReportGenerator Interface and corresponding method generateReport.
2. create bean in spring config file.
3. make a entry of new format in reportGenerationMapper bean.
4. Add this bean reference in ReportGeneratorFactory bean.
And there you go.


Run Application. 

When you run the application it will ask to select the operation to perform. 

1. Alien Registration
2. Report Generation

if user selects 1. then application will ask for alien data and store it in SQLite database file.

If user selects 2. then application will ask for the desired report format from the available formats in application.  (If foobar format is properly configured then it will automatically be shown to user).

Based on the selected format report will be generated at configured location. 


Further Scope. 

1. Another DAO implementation (JDBC) can be provided by implementing IAlienRegistrationDAO  to eliminate dependency on Hibernate. 

2. Currently User Interacts with application through Console, we can provide another interaction medium by Implementing IUserInteraction interface. 

3. Currently Application has only default console logging.
Custom logger can easily be configured through Spring AOP with advice and join points.  (Sorry I missed it  :) )
