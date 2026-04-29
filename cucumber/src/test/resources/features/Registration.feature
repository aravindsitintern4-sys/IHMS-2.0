@login @dashboard
@Registration
Feature: Outpatient Registration

  Scenario Outline: Register patient with dynamic data
    Given user is on ihms dashboard
    When user navigates to OP Module and selects "Outpatient Registration"
    Then the op registration page should be displayed
    
#    And user selects payment type "PAY"
    And user selects payment type "FREE"
    And user selects patient type as "SCHEDULING"
#    And user selects patient type as "DIRECT"
    
  Scenario Outline: Enter firstname and lastname and age
    And user enters first name "<FirstName>" and last name "<LastName>"
    And user enters age as "<Age>" and clicks the DOB field
    Then user clicks Cancel button
    
   Examples:
    | FirstName | LastName | Age |
    | John      | Doe      | 21  |
    | Jane      | Smith    | 30  |
    | Alex      | Case     | 25  |
    
    
   Scenario Outline: Enter gender
    And user selects gender as "<Gender>"
    And user handles confirmation popup for "<Gender>" by clicking "Yes"
#    And user handles confirmation popup for "<Gender>" by clicking "No"
    
    And user selects kin relation as "<Relation>" and enters name "<KinName>"
    Then user clicks Cancel button
    

    Examples:
      | Gender      | Relation | KinName     |
      | Male        | S/O      | Richard Roe |
      | Female      | W/O      | Juily       |
      | Transgender | C/O      | Rose        |
      
   Scenario Outline: Select visit
   And user selects visit type as "Normal"
   And user selects visit type as "Referral"
   And user enter Reference No as "9876543456"
   And user Click CRS box
   And user selects District as "<District>"
   And user selects Referral Name as "<Name>"
   And user selects Clinic Referred as "<Clinic>"
   And user selects Doctor Referred as "<Doctor>"
   
   Then user clicks on referral submit button
#   Then user clicks referral Cancel button
   
   Examples:
     |District | Name                               | Clinic    | Doctor  |
     |DINDIGUL | Kamarajar Narpani Mandram, Eriodu  | FREENEW   | Anjana  |
     |KARUR    | Lions Club Of Karur Host           | FREE UNIT | Anu N V |
    
      
    