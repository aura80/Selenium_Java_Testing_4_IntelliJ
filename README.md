# Selenium_Java_Testing_4_IntelliJ

GENERAL PRESENTATION

Characteristics:
Web application: Sauce Labs Swag Labsapp.
URL: https://www.saucedemo.com/

Functionality:
•User login and logout with accepted credentials
•Products overview
•Filter products by four criteria
•Viewing ALL ITEMS
•Navigate to https://saucelabs.com/
•Reset application state
•Adding products to the cart
•Booking products
•Logout

Test Scenarios:
•Login with valid data
•Login with invalid data
•View product details
•Add and remove a product from the cart
•Validate sender invalid data
•Create a booking for one product
•Create a booking for two products
•Filter products based on all options.
•Log out

Tools used:
Java11, Eclipse, Selenium, JUnit, Chrome

Packages in src folder:
•components
•pages
•resource
•testdata
•testdatafiles
•testmessages
•tests
•util

Valid URLs:
https://www.saucedemo.com/
https://www.saucedemo.com/inventory.html
https://www.saucedemo.com/inventory-item.html?id=2
https://www.saucedemo.com/checkout-step-two.html

Main packages structure:
•resource -contains the ChromeDriver executable file;
•pages -contains the .java files with classes that hold the element locators, class constructors and methods for pages under test;
•components –have the .java files with classes that hold the element locators and methods for header and footer elements of the pages under test;
•testdatafiles -contains the uservalidlogin.jsonand userinvalidlogin.json files with the username and the password, in key-value format, for valid and invalid login;
•util -contains the Reader.java file to read data from the .json file, GeneralInfo.java file with general information about the current page and AbstractInfo.java with
the abstract class and the unimplemented methods;
•testdata –contains the UserLogin.java file which is a POJO to get the value of the username and password keys and the URL.java file where all the needed URLs are 
defined as constant variables;
•testmessages –contains the Messages.java file with all the messages, names, values and errors defined as constant variables;
•tests -contains the .java files which implement all the tests preceded by the @Test annotation;

Page Object Model:
POM Classes identifies the web elements on a page through locators and contain methods which performs operations on those elements. They also contain constructors 
which are special methods that initialize the objects of the considered class type. It contains five classes.
The InventoryPageclass and StartPageclass inherit GeneralInfoclass with general informations about the working page. The ProductDetailsclass inherits the Header class 
to select products in a certain order. All the classes have their own methods also. The LoginValidInvalidDataPageinherits the AbstractInfo abstractclass which contains
methods that are not implemented.

Tests:
There are four .java test files, from which the SaucedemoBaseTest.java is the main one which makes the setupfor tests at driver level. 
Junit @Beforeand @Afterannotations were used preceding the methods for launching and closing the chrome browser before every test. An object of WebDriver was created, 
implicit wait was used, window was maximized, pages and components were instantiated, Robot class was used for handling the coordinates of the browser zooming out and 
the URL was launched. After test all the browser’s instances were closed.
InventoryChecksAndFilterTests, ProductDetailsBookingTestsand SaucedemoLoginCheckTestsclasses, all inherit the SaucedemoBaseTestclass, which is the parent test class 
for all the test classes. The child classes contain methods preceded by the @Test annotation and implements the tests according to the test scenarios.
The constant variables from Messagesclass were mostly used for assertions inside the tests or for calculating the total price of the cart.



