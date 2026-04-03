#@login @dashboard @outpatientmaster
@testrepository

Feature: Test Repository Master

Background:
  Given user is on dashboard group landing page
  When user clicks on Test Repository Master
  Then user should be navigated to Test Cost Master

#POSTIVE 
Scenario Outline: Select Site Type

  When user selects Site Type "<siteType>"
  Then selected Site Type should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | siteType          |
  | Main Hospital     |
  | City Center       |  
  | Community Center  |
  | Vision Center     | 

Scenario Outline: Select Account Head

  When user selects Account Head "<accounthead>"
  Then selected Account Head should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | accounthead              |
  | Anaesthesia              |
  | Cataract surgery         |  
  | Laser Surgery - Glaucoma |
  | CONTACT LENS             |
  
Scenario Outline: Select Clinic 

  When user selects Clinic "<clinic>"
  Then selected Clinic should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | clinic            |
  | A-SCAN            |
  | FREENEW           |  
  | FREE UNIT         |
  | GLAUCOMA CLINIC   |
  
Scenario Outline: Select Payment Type 

  When user selects Payment Type "<paymenttype>"
  Then selected Payment Type should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | paymenttype       |
  | FULL PAYMENT      |
  | CORPORATE         | 
  
Scenario Outline: Select Site and Corporate Dropdown

  When user selects Payment Type "Corporate"
  And user selects Site "<site>"
  And user selects Corporate "<corporate>"
  Then selected Site should be displayed
  Then selected Corporate should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | site                          | corporate         |
  | Aravind Eye Hospital-Tiruppur | THE CHENNAI SILKS |
  | Aravind Eye Hospital-Madurai  | TEST              |
  | Aravind Eye Hospital-Chennai  | SALEM STEEL PLANT |
  
Scenario Outline: Enter Test Name

  When user enters Test Name "<testName>"
  Then entered Test Name should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | testName     |
  | TEST1        |
  | EYE PRESSURE |
  
Scenario Outline: Select PayFree Type

  When user selects PayFree "<payfree>"
  Then selected PayFree Type should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | payfree   |
  | PAY        |
  | FREE       |
  
Scenario Outline: Enter Test Cost

  When user enters Test Cost "<testCost>"
  Then entered Test Cost should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | testCost  |
  | 100       |
  | 0         |
  | 99        |
  
Scenario Outline: Select IsInjection

  When user selects IsInjection "<injection>"
  Then selected IsInjection should be displayed
  And user clicks on Clear button in test cost page

Examples:
  | injection  | 
  | YES        |
  | NO         |
  
#negative 
Scenario Outline: Save button should be disabled when field is empty
  And user leaves test cost "<field>" empty
  Then test cost master save button should be disabled
  
Examples:
  | field          |
  | Site Type      |
  | Account Head   |
  | Clinic         |
  | Payment Type   |
  | Test Name      |
  | PayFree        |
  | Test Cost      |
  | IsInjection    |
  
# FULL POSITIVE SCENARIO                          
Scenario Outline: Save test cost master Successfully
  And user selects Site Type "<sitetype>"
  And user selects Account Head "<accounthead>"
  And user selects Clinic "<clinic>"
  And user selects Payment Type "<paymenttype>"
  And user enters Test Name "<testname>"
  And user selects PayFree "<payfree>"
  And user enters Test Cost "<testcost>"
  And user selects IsInjection "<injection>"
  Then test cost master save button should be enabled
  When user clicks Save button in test cost page
  Then test cost should be saved successfully
  When user clicks on Clear button in test cost page
  Then all fields should be reset
 
Examples:
  | sitetype      | accounthead  | clinic    | paymenttype  | testname          | payfree | testcost  |  injection |
  | Main Hospital | Anaesthesia  | A-SCAN    | FULL PAYMENT | NEW FIRST FLOOR   | FREE    | 100       |  No        |
  | City Center   | CONTACT LENS | FREE UNIT | FULL PAYMEN  | FREE SECOND FLOOR | PAY     | 90        |  YES       |

#SEARCH ROOM VALIDATION 

Scenario Outline: Search test name validation
  And user enters test name in search "<testname>"
  Then test name search result should be displayed

Examples:
  | testname |
  | 012      |

Scenario Outline: Search test name negative validation
  And user enters test name in search "<testname>"
  Then no test name result should be displayed

Examples:
  | testname |
  | @@@    |
  
# Update Test Repository
Scenario: Update test cost after selecting row
    When user selects row with Test Name "012"
    And user enters Test Cost "950000" in testrepo
    And user clicks on Update button in testrepo
    Then update success popup should be displayed with message "Test repository master datas are updated successfully"
    And user clicks OK on popup in testrepo
    
Scenario: Delete selected row
    When user selects row with Test Name "012"
    And user clicks on Delete button in testrepo
    Then delete success popup should be displayed with message "Test repository master datas are deleted successfully"
    And user clicks OK on popup in testrepo

  Scenario: Cancel selected row action
    When user selects row with Test Name "012"
    And user clicks on Cancel button in testrepo
    Then selection should be cleared
    And Update Delete Cancel buttons should not be visible 
  

 
 
 
