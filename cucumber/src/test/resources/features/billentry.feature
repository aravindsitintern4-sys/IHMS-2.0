#@login @dashboard @billing
#@billentry

Feature: Billing Patient Management

  Background:
    Given user is on the billing entry page

  Scenario: Verify billing 

    When user enters UIN "0024425411" and presses enter
    Then patient details should be displayed
    
    And user clicks PayFree dropdown
    And user selects "PAY" from PayFree dropdown
    
#    And user clicks PayFree dropdown
#    And user selects "FREE" from PayFree dropdown
    
    And user clicks Advised By dropdown
    And user selects "Dev User" from Advised By dropdown
    
    And user clicks Testname dropdown
    And user selects test name "APTT" and presses enter
    
    And user selects payment category "FULL PAYMENT"
    And user clicks on Fees field
    And user presses Enter in Fees field
    
    And user clicks Save button
    And user clicks Cancel button
    
    
    


  