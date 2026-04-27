@login @dashboard @billing
@billentry

Feature: Billing Patient Management

  Background:
    Given user is on the billing entry page

  Scenario Outline: Verify billing details for different patients and payment modes
    When user enters UIN "0024425395" and presses enter
    Then patient details should be displayed

    And user clicks PayFree dropdown
    And user selects "<PayFree>" from PayFree dropdown 

    And user clicks Advised By dropdown
    And user selects "<AdvisedBy>" from Advised dropdown

    Then selected "<PaymentMode>" option should be displayed
    And selected "<AdvisedBy>" option should be displayed

#    And user clicks Cancel button

Examples:
| PayFree     | AdvisedBy |
| PAY         | Ashwin B  |
| FREE        | Rupa A    |