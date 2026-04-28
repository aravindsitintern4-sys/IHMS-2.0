@Registration
Feature: Outpatient Registration

  Scenario Outline: Register patient with dynamic gender and billing logic
    Given user is on ihms dashboard
    When user navigates to OP Module and selects "Outpatient Registration"
    Then the op registration page should be displayed
    
    And user selects payment type "<PayType>"
    And user selects patient type as "<PatientType>"
    
    And user enters first name "John" and last name "Doe"
    And user enters age as "21" and clicks the DOB field
    
    And user selects gender as "<Gender>"
    And user handles confirmation popup for "<Gender>" by clicking "Yes"
#    And user handles confirmation popup for "<Gender>" by clicking "No"
    
#    Then the registration should be successful

    Examples:
      | PayType | PatientType | Gender      |
      | FREE    | SCHEDULING  | Male        |
      | PAY     | DIRECT      | Female      |
      | FREE    | SCHEDULING  | Transgender |