#@login @dashboard @outpatientmaster
@corporatemaster
Feature: Corporate Master

Background:
  Given user is on dashboard group landing page
  When user clicks on Corporate Master
  Then user should be navigated to Corporate Master page
  
  
 Scenario Outline: Open Corporate creation form
    When user selects Site "<site>" in corporate master
    And user clicks on New Corporate Create button
    Then corporate creation form should be displayed
Examples:
  | site                         |
  | Aravind Eye Hospital-Madurai |  

Scenario Outline: Enter Corporate Name
   
   And user enters Corporate Name "<corporatename>"
   Then entered Corporate Name should be cleared
   And user clicks on Clear button in corporate
Examples:
| corporatename |
| xxxwwww       |
| abccorporate  |

Scenario Outline: Select Charges Type
   
  When user selects Charge Type "<chargetype>"
  Then selected Charge Type should be displayed
  And user clicks on Clear button in corporate

Examples:
  | chargetype          | 
  | Public Charge       |
  | Individual Rate     |
  
Scenario Outline: Select Co-Payment
   
  When user selects Co-Payment "<co-payment>"
  Then selected Co-Payment should be displayed
  And user clicks on Clear button in corporate

Examples:
  | co-payment | 
  | Yes        |
  | No         |
  
Scenario Outline: Select Corp.Group
   
  When user selects Corp.Group "<corp.group>"
  Then selected Corp.Group should be displayed
  And user clicks on Clear button in corporate

Examples:
  | corp.group                          | 
  | Debtors-Central Govt.Units/undertaking  |
  | Debtors-State Govt.Units/undertaking    |
  
Scenario Outline: Enter New Pay Cost
   
   And user enter New Pay Cost "<newpaycost>"
   Then entered New Pay Cost should be displayed
   And user clicks on Clear button in corporate
Examples:
| newpaycost |
| 1000       |
| 2000       |

Scenario Outline: Enter Old Pay Cost
   
   And user enter Old Pay Cost "<oldpaycost>"
   Then entered Old Pay Cost should be displayed
   And user clicks on Clear button in corporate
Examples:
| oldpaycost |
| 1200       |
| 1300       |

Scenario: Enter Address1
 
   And user enter Address1 "Cross street1"
   Then entered Address1 should be displayed 
   And user clicks on Clear button in corporate
   
Scenario Outline: Enter Phone Number

   And user enter Phone number "<phonenum>"
   Then entered Phone number should be displayed
   And user clicks on Clear button in corporate
   
Examples:   
| phonenum   |
| 8976543214 |
| 9765432156 |
   
Scenario: Enter Address2
 
   And user enter Address2 "Cross street2"
   Then entered Address2 should be displayed 
   And user clicks on Clear button in corporate
   
Scenario Outline: Enter Email

   And user enter Email "<email>"
   Then entered Email should be displayed
   And user clicks on Clear button in corporate
   
Examples:   
| email         |
| af@.gmail.com |
| xyz@gmail.com |
   
Scenario: Enter Address3
 
   And user enter Address3 "Cross street3"
   Then entered Address3 should be displayed 
   And user clicks on Clear button in corporate   
   
Scenario Outline: Enter Contact Person

   And user enter Contact Person "<contactperson>"
   Then entered Contact Person should be displayed
   And user clicks on Clear button in corporate
   
Examples:   
| contactperson |
| dev           |
| divya         |

Scenario Outline: Select District

   And user select District "<district>"
   Then selected District should be displayed
   And user clicks on Clear button in corporate
   
Examples:   
| district  |
| Ajmer     |
| Azamgarh  |

Scenario Outline: Enter Fax

   And user enter Fax "<fax>"
   Then entered Fax should be displayed
   And user clicks on Clear button in corporate
   
Examples:   
  | fax        |
  | abc@123    |
  | 12345      |
  | 9876543210 |

Scenario Outline: Enter ABI

   And user enter ABI "<abi>"
   Then entered ABI should be displayed
   And user clicks on Clear button in corporate
   
Examples:   
  | abi        |
  | 12345      |
  | 23456      |
  
Scenario Outline: Select Employee Grade

  And user selected Employee Grade "<employeegrade>"
  Then selected Employee Grade should be displayed
  
Examples:
 | employeegrade |
 | Employee      |
 | Driver        |
 | Doctor        |
 
Scenario Outline: Enter Max Amount Allow

   And user enter Max Amount Allow "<amount>"
   Then entered Max Amount Allow should be displayed
   
Examples:   
  | amount    |
  | 100       |
  | 90        |
  
Scenario: Click Action button
   
  And user clicks on Action button
  Then given employee grade and amount shoukd be added
  And user clicks on Clear button in corporate 
  
Scenario Outline: Select Action type

  And user select Action type "<action>"
  Then selected Action type should be displayed
  And user clicks on Clear button in corporate
  
Examples:
 | action |
 | Yes    |
 | No     |

#Negative 
Scenario: Validate error when clicking Save without entering data
  And user clicks Save button without entering any data
  Then validation popup should be displayed with message "Please fill district field"
  And user clicks on Clear button in corporate
 
#Positive                         
Scenario Outline: Save Room Status Successfully
  And user enters Corporate Name "<corporatename>"
  And user selects Charge Type "<chargetype>"
  And user selects Co-Payment "<co-payment>"
  And user selects Corp.Group "<corp.group>"
  And user enter New Pay Cost "<newpaycost>"
  And user enter Old Pay Cost "<oldpaycost>"
  And user enter Address1 "Cross street1"
  And user enter Phone number "<phonenum>"
  And user enter Address2 "Cross street2"
  And user enter Email "<email>"
  And user enter Address3 "Cross street3"
  And user enter Contact Person "<contactperson>"
  And user select District "<district>"
  And user enter Fax "<fax>"
  And user enter ABI "<abi>"
  And user selected Employee Grade "<employeegrade>"
  And user enter Max Amount Allow "<amount>"
  And user clicks on Action button
  And user select Action type "<action>"
 
  When user clicks on Save button in corporate
  Then saved success popup message should be displayed "Record Saved Successfully"
  And user clicks on Clear button in corporate

Examples:
  | site                         | corporatename | chargetype    | copayment | corpgroup                        | newpaycost | oldpaycost | address1      | phonenum   | address2      | email          | address3      | contactperson | district | fax        | abi   | employeegrade | amount | action |
  | Aravind Eye Hospital-Madurai | TestCorp      | Public Charge | Yes       | Debators-Central Govt.Units      | 100       | 90       | Cross street1 | 9876543210 | Cross street2 | test@gmail.com| Cross street3 | Divya         | Ajmer    | 1234567890 | 12345 | Employee      | 1000   | Yes    |
  
#SEARCH ROOM VALIDATION 

Scenario Outline: Search Corporate Name Validation
  And user enters Corporate name in search "<corporatename>"
  Then Corporate name search result should be displayed

Examples:
  | corporatename |
  | FENNER      |

Scenario Outline: Search Corporate name negative validation
  And user enters Corporate name in search "<corporatename>"
  Then no Corporate name result should be displayed

Examples:
  | corporatename |
  | @@@    |  
  
#Update
Scenario Outline: Update the corporate detail

    When user clicks on active icon for corporate "<corporatename>"
    Then corporate creation form should be displayed
    And corporate details should be loaded in input fields
    And user enter New Pay Cost "<newpaycost>"
    And user clicks on Update button in corporate
    Then update success popup message should be displayed "Record Updated Successfully"
    And user clicks OK on popup in corporate

Examples:
| corporatename | newpaycost |
| FENNER        | 90         |
    
Scenario Outline: Clear button validation
     
    When user clicks on active icon for corporate "<corporatename>"
    Then corporate creation form should be displayed
    And corporate details should be loaded in input fields
    And user enter New Pay Cost "<newpaycost>"
    And user clicks on Clear button in corporate
    Then entered all the detail should be cleared 

Examples:
| corporatename | newpaycost |
| TestCorp      | 100        |
    

