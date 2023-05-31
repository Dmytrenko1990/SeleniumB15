Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    #And  Close the browser

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "admin1" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And  Close the browser

    #HOOKS: for defining pre and Post steps in any Cucumber framework
    #     : This is always created inside the StepDefinitions folder
    #     : This class cannot be inherited
    #     : Hooks will take care of pre and post condition

    #BACKGROUND: Its the clubbing of common steps in different scenarios of a feature file
    #           till flow is not broken

    #1. Hard code
    #2. Config file
    #-----------Cucumber itself provides multiple option through which we can feed data from
    #feature file into Step Definition------------------------------------
    #3. Regular Expressions
      #put the data in double quotes [""]
    #4. Scenario Outline
      # Provides you an alternative to Data driven testing
      # Also supports parametrization
      # if you want to use parametrization
      # if you wish to implement DDT
        #Scenario Outline is always used along with the keyword 'Examples'

    #================Parameterization=======================
    #Executing the same test case with multiple data

  @scenarioOutline
  #Parameterization/ Data Driven
  Scenario Outline: Login with multiple credentials using Scenario Outline
    #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
    #And  Close the browser
  Examples:
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |

  #data Table
  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |

  # Page Object Model: An object Repository [ It stores or holds all the webElements specific to a particular page]