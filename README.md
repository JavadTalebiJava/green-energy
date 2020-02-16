Project Assessment
---

Green Energy is a backend web application created by a startup company called “Green Energy Analytics” in Texas - USA. 
This application collects energy analytics for solar panels every hour.

Notes:
 * Project accepts data for registered panels only, and to register panel; serial number must be 16 characters length, 
   and latitude/longitude contains 6 decimal places.
 * Frontend application excluded from the current scope. It is a separate, fully-functioning application handled by 
   another team, so we do not want to modify it.

Tasks:

  1. Increase unit test coverage to reach 60%, achieving more than 60% will only consume your valuable time without 
     extra score.
  1. Find bugs and fix them, hint: we provided Green Energy application in a good structure, so no need to spend your 
     valuable time on structure modifications,  just focus on fixing bugs.
  1. Frontend team wants to display panel’s all historical data in a chart, in which each point represents electricity 
     generated by this panel each day `[sum, min, max, average]` up to the end of previous day , your goal is to implement 
     backend part of this task, API specifications already there in code as agreed with Frontend team, and it is ok to 
     implement this task without any optimization.

### Prerequisites
 
 * Java 11
 * MySQL 5.7

### Development Environment

  * Mysql:
    * Green Energy applications require MYSQL database to store its data. Make sure to update application.properties 
      with spring.datasource.url(change hostname only), spring.datasource.username, and  spring.datasource.password. 
      You are free to choose MySQl service in a cloud or installed on local machine or MySQL container.
    
    * Green Energy application uses liquibase for Database changes. For more details on liquibase follow 
      [liquibase docs](https://www.liquibase.org/documentation/changeset.html) 
  
   * Green Energy Application:
     * To start the application run CrossSolarApplication.java main method from your IDE
       and to check that it is running open `http://localhost:8080/panels/1234567890123456/hourly` from your browser.


 

