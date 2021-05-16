@tag
Feature: Elearning
  @SignUp
  Scenario Outline: SignUp_Functionality and Compose an Email
    Given User is on the Login Page and clicks on SignUp
    When User navigate to registration page and Enter all the mandatory fields "<firstname>","<lastname>","<email>","<Username>","<password>","<Cpassword>"
    And Click on Register button
    Then verify the username"<userregistered>"
    And User Click on home icon 
    Then user enter the required fields "<Username>","<password>"
    And click on submit button
     Then user verify that Register is completed sucessfull "<registered>"
    And Clicks on Compose
    And Enter Send to,Subject,Message "<sentto>","<subject>","<message>"
    And Clicks on Send Message
    Then Validate the success message
    Examples:
      | firstname | lastname   | email                  |Username      |password      | Cpassword        | userregistered                | registered          |sentto |subject|message|
      | Padmasri  | Srinivasan | padmaashri9@gmail.com  |padmaashri1994| Padmaashri@09| Padmaashri@09    | This login is already in use  | padmasri srinivasan |test   |Test   |Welcome|