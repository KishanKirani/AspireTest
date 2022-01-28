Structure
  Aspire Test Framework
    |____Configs - all the configuration files for the project (configuration.properties)
    |____Drivers - Chrome driver (Please update this depending on your machine and browser)
    |____POM - Since it is a maven based project
    |____Src
            |___main.java.com.aspire.test.automation
                           |___constants - All the project specific constants
                           |___helpers - Helper classes for framework(Driver Manager, Any sort of helper classes)
                           |___hooks - Service hook class which is used to define our before and after actions
                           |___pageobjects - Page Objects as per the POM framework
                           |___test - All the test classed pertaining to the project
                           |___utils - Generic methods that are used in the project(Selenium Utils, Common Utils)
    |____automation-framework.bat

Steps to Follow
* Configs file - configuration.properties
    |___ Update any specific details required like username or passwords

* automation-framework.bat file
    |___ Once the project is cloned to local directory
    |___ Update the project path as your local cloned directory path in automation-framework.bat
    |___ Double click on the bat file to run the test.
