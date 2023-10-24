@SmokeTest
Feature: Epic module creation


  Scenario: Create Epic module
    Given the user is on signin page
    And the user enters valid details and clicks on signin
    Then the user is on homePage
    And the user hovers on menu
    And the user clicks on project
    Then the user is on projectPage
    And the user hovers on execute menu
    And the user clicks on epics
    Then the user is on epicModulePage



  Scenario Outline: Generating id in Epics module
    Given the user is on epicModulePage
    And the user clicks on add button
    And the user enters Name <name> ,Date <date> ,Description <desc> ,Priority <priority> and Size <size> in respective fields 
    And the user clicks on Save button
    Then the Epic id is generated
    And user enters invalid details or leaves mandatory fields empty
    And user clears the name field
    And user clears the date field
    Then user clicks on Save button
    Then the user handles the Alerts



	Examples: 
	| name              |    date      |     desc      |  priority  |  size  |
	| Testing Team2     | 03-Sep-2021  |  Description  |  Medium    |   M    |
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	