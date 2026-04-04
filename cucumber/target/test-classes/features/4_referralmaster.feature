#@login @dashboard @outpatientmaster
@Referralmaster
Feature: Referral Master

Background:
  Given user is on dashboard group landing page
  When user clicks on Referral Master
  Then user should be navigated to referral master page

# REQUIRED FIELD VALIDATION

Scenario: Save button should be disabled when Referral Name is empty
  And user enters Referral Name ""
  And user enters Referral Address 1 "Address1"
  Then save button should be disabled

Scenario: Save button should be disabled when Referral Address 1 is empty
  And user enters Referral Name "Test"
  And user enters Referral Address 1 ""
  Then save button should be disabled


# REFERRAL NAME VALIDATION

Scenario Outline: Referral Name field validation
  And user enters Referral Name "<input>"
  And user enters Referral Address 1 "Address1"
  Then only alphabets should be entered in referral name field
  And user clicks on Clear button 

Examples:
  | input   |
  | g1thr   |
  | {},@;   |
  | 12345   |
  | Siva123 |
  | Siv@    |


# ADDRESS 1 VALIDATION

Scenario Outline: Referral Address 1 field validation
  And user enters Referral Name "Test"
  And user enters Referral Address 1 "<address1>"
  Then validation for referral address 1 field
  And user clicks on Clear button 

Examples:
  | address1 |
  | @@@@     |
  | 12345    |
  | Address@ |
  | ###      |
  | Addr123  |


# ADDRESS 2

Scenario: Validate Address 2 clear functionality
  And user enters Referral Address 2 "Cross street"
  And user clicks on Clear button 
  Then entered referral details should be cleared


# ADDRESS 3

Scenario: Validate Address 3 clear functionality
  And user enters Referral Address 3 "Address3"
  And user clicks on Clear button 
  Then entered referral details should be cleared


# FAX VALIDATION

Scenario Outline: Fax field validation
  And user enters Fax "<fax>"
  Then validation for fax field
  And user clicks on Clear button 

Examples:
  | fax        |
  | abc@123    |
  | 12345      |
  | 9876543210 |


# PHONE NUMBER VALIDATION

Scenario Outline: Phone No field validation
  And user enters Phone No "<phone>"
  Then validation for phone number field
  And user clicks on Clear button 

Examples:
  | phone      |
  | abc123     |
  | 98765      |
  | 1234567890 |
  | 9876543210 |


# EMAIL VALIDATION

Scenario Outline: Email field validation
  And user enters Email ID "<email>"
  Then validation for email field
  And user clicks on Clear button 

Examples:
  | email          |
  | test           |
  | test@          |
  | test@gmail     |
  | test@gmail.com |


# CONTACT PERSON VALIDATION

Scenario Outline: Contact Person field validation
  And user enters Contact Person "<name>"
  Then only alphabets should be entered in contact person field
  And user clicks on Clear button 

Examples:
  | name    |
  | g1thr   |
  | {},@;   |
  | 12345   |
  | Siva123 |
  | Siv@    |


# DROPDOWN

Scenario: Validate Referral Type dropdown selection
  When user clicks on Referral Type dropdown
  Then user should see all 7 options in dropdown

Scenario Outline: Select Referral Type
  When user selects Referral Type "<type>"
  Then selected referral type should be displayed

Examples:
  | type             |
  | AEH Hospital     |
  | Community Center |
  | City Center      |
  | Vision Center    |
  | Diabetologist    |
  | Ophthalmologist  |
  | Other            |


# CLEAR BUTTON

Scenario: Verify Clear Functionality
  And user enters Referral Name "Test"
  And user enters Phone No "9876543210"
  And user enters Email ID "test@gmail.com"
  And user clicks on Clear button 
  Then entered referral details should be cleared


# SAVE FUNCTIONALITY

Scenario: Save Referral Successfully
  And user enters Referral Name "Test Referral"
  And user enters Referral Address 1 "Address1"
  And user enters Referral Address 2 "Address2"
  And user enters Referral Address 3 "Address3"
  And user enters Phone No "9876543210"
  And user enters Fax "1234567890"
  And user enters Email ID "test@gmail.com"
  And user enters Contact Person "Siva"
  And user selects Referral Type "AEH Hospital"
  #And user clicks on Save button 
  #Then referral should be saved successfully

  And user clicks on Clear button 
  Then entered referral details should be cleared
  
#SEARCH REFFERAL VALIDATION 

Scenario Outline: Search Refferal name validation
  And user enters referral name in search "<refferal>"
  Then referral name search result should be displayed

Examples:
  | referral        | 
  | 33TEST          |

Scenario Outline: Search Room Number negative validation
  And user enters referral name in search "<referral>"
  Then no referral name result should be displayed

Examples:
  | referral|
  | ABC     |
 
# Update Referral
Scenario Outline: Update referral dynamically

  When user clicks referral row "<refName>"
  Then referral details should be loaded in input fields
  And update button should be displayed 

  When user updates "<field>" with "<value>" in referral
  And user clicks on Update button

  Then update success popup should be displayed with message "Test repository master datas are updated successfully"
  And user clicks OK on popup

Examples:
  | refName                   | field           | value          |
  | AADARSH CLINIC            | Phone           | 9876543218     |
  | AADARSH CLINIC            | Email           | test@gmail.com |
  | AADARSH CLINIC            | Contact Person  | Ravi           |
  | AADARSH CLINIC            | Referral Name   | New Clinic     |
  
  
  
  
  