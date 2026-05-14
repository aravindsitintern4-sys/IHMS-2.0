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
     
     Scenario Outline: Select visit without CRS
   And user selects visit type as "Normal"
   And user selects visit type as "Referral"
   And user enter Reference No as "9876543456"
   And user selects Referral Name as "<Name>"
   And user selects Clinic Referred as "<Clinic>"
   And user selects Doctor Referred as "<Doctor>"
   
   Then user clicks on referral submit button
#   Then user clicks referral Cancel button

   Then user clicks Cancel button
   
   Examples:
     | Name               | Clinic    | Doctor  |
     | AADHI EYE HOSPITAL | FREENEW   | Anjana  |
     
     
#    Scenario Outline: Select visit
#   And user selects visit type as "Normal"
#   And user selects visit type as "Referral"
#   And user enter Reference No as "9876543456"
#   And user Click CRS box
#   And user selects District as "<District>"
#   And user selects Referral Name as "<Name>"
#   And user selects Clinic Referred as "<Clinic>"
#   And user selects Doctor Referred as "<Doctor>"
   
#   Then user clicks on referral submit button
#   Then user clicks referral Cancel button
   
#   Examples:
#     |District | Name                               | Clinic    | Doctor  |
#     |DINDIGUL | Kamarajar Narpani Mandram, Eriodu  | FREENEW   | Anjana  |
#     |KARUR    | Lions Club Of Karur Host           | FREE UNIT | Anu N V |

    Scenario: Select Nationality Of  Indian
     When user selects Nationality as "Indian"
     And user enters Door or Street as "<DoorStreet>"
     And user enters Locality as "<Locality>"
     And user enters City as "<City>"
     And user clicks Area option to enable Area dropdown
     And user select Area as "ELLIS NAGAR"
     And user enters PinCode as "<PinCode>"
     And user selects Taluk as "<Taluk>"
     And user enters Mobilenumber as "<Number>"
     And user enters emailid as "<Mail>"
     And user enters Aadhaar No as "<Aadhaar>"
    
    Examples:
      | DoorStreet    | Locality      | City    | PinCode | Taluk   | Number      | Mail            | Aadhaar        | 
      | 123 Main St   | North Block   | Madurai | 625001  | Madurai | 9876546789  | aff56@gmail.com | 123456789012   |
     
   
    
      
    