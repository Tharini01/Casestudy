Feature: TestMe Registration

@registration
Scenario: Registration
Given User must be in the SignUp Page
When User must provide the necessary credentials username "username1234" , firstname "user" , lastname "name" , password "usrname123" , confirmPassword "usrname123" , select the gender ,emailAddress "user@gmail.com" , mobileNumber "9876543210" , dob "28/01/1997" , address "New street, Chennai" , select a security question and provide the necessary answer "blue" and click submit 
Then Registration is done successfully

@login_outline
Scenario Outline: login 
Given User must be in the Login Page
When User must provide registered username credentials "<username>" and "<password>" and click Login
Then Login is done successfully and user is directed to the Home page
Examples:
|username||password|
|Lalitha||Password123|

@Search
Scenario: Search products
Given The user is logged into the Home Page
When search for the product and click Find Details
Then The page with the details of the product opens 

@Add_to_Cart
Scenario: User moves to cart with outing the item
    Given user registered into TestMeApp
    When user search a particular product and try to proceed the payment without adding item
    Then TestMeApp doesnt display cart icon



