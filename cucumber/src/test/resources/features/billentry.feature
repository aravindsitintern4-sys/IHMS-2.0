@login @dashboard @billing
@billentry

Feature: Billing Patient Management

  Background:
    Given user is on the billing entry page

  Scenario Outline: Verify billing details for different patients and payment modes
    When user enters UIN "0024425296" and presses enter
    Then patient details should be displayed
    And user selects Pay/Free as "<PaymentMode>"
    And user selects Advised By as "<AdvisedBy>"
    Then selected Pay/Free option should displayed 
    And selected Advised By option should displayed
    Then user clicks on Cancel button

    Examples:
     | PaymentMode | AdvisedBy |
     | PAY         | Ashwin B  |
     | FREE        | Rupa a    |