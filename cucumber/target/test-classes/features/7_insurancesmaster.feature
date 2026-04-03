#@login @dashboard @outpatientmaster
@insurancemaster
Feature: Insurance Master

Background:
  Given user is on dashboard group landing page
  When user clicks on Insurance Master
  Then user should be navigated to Insurance Master page

# INSURANCE NAME VALIDATION
Scenario Outline: Insurance Name field validation
  And user enters insurance name "<insuranceName>"
  Then insurance save button should be disabled
  And user clicks on Clear button in insurance page

Examples:
  | insuranceName |
  | Star Health   |
  | LIC Insurance |
  | Test123       |
  |               |

# SHORT NAME VALIDATION
Scenario Outline: Insurance Short Name field validation
  And user enters insurance short name "<shortName>"
  Then insurance save button should be disabled
  And user clicks on Clear button in insurance page
Examples:
  | shortName |
  | STAR      |
  | LIC       | 
  | TEST123   |
  |           |

# NEGATIVE CHECK FOR EMPTY FIELDS
Scenario Outline: Save button disabled for empty fields
  And user leaves insurance "<field>" empty
  Then insurance save button should be disabled
  And user clicks on Clear button in insurance page

Examples:
  | field          |
  | Insurance Name |
  | Short Name     |

# MAX LENGTH VALIDATION
Scenario Outline: Insurance Name max length validation
  And user enters insurance name "<insuranceName>"
  Then insurance name should not exceed 100 characters

Examples:
  | insuranceName                                                   |
  | ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJK |

Scenario Outline: Short Name max length validation
  And user enters insurance short name "<shortName>"
  Then short name should not exceed 15 characters

Examples:
  | shortName          |
  | ABCDEFGHIJKLMNOPQR |

# CLEAR BUTTON VALIDATION
Scenario: Clear button should reset fields
  And user enters insurance name "Test Insurance"
  And user enters insurance short name "TEST"
  When user clicks on Clear button in insurance page
  Then all fields should be cleared

# FULL POSITIVE SCENARIO
Scenario Outline: Save Insurance Successfully
  And user enters insurance name "<insuranceName>"
  And user enters insurance short name "<shortName>"
  Then insurance save button should be disabled
  When user clicks on Save button in insurance page
  Then insurance should be saved successfully

Examples:
  | insuranceName | shortName |
  | Star Health   | STAR      |
  | LIC Insurance | LIC       |

# SEARCH VALIDATION
Scenario Outline: Search Insurance Name validation
  And user enters insurance name in search "<insuranceName>"
  Then insurance search result should be displayed

Examples:
  | insuranceName |
  | Star          |

# SEARCH NEGATIVE VALIDATION
Scenario Outline: Search Insurance negative validation
  And user enters insurance name in search "<insuranceName>"
  Then no insurance result should be displayed

Examples:
  | insuranceName |
  | ZZZ_INVALID   |
  
# Update Test Repository
Scenario Outline: Update insurancemaster dynamically

  When user clicks insurancemaster row "<inc.code>"
  Then insurancemaster details should be loaded in input fields
  And update button should be displayed in insurancemaster

  When user updates "<field>" with "<value>" in insurancemaster
  And user clicks Update button in insurancemaster
   
  Then update success popup should be displayed in insurancemaster
  And user clicks OK button in insurancemaster

Examples:
  | inc.code  | field            | value   |
  | 26        | Ins Short Name   | hii     |
  | 11        | Insurance Name   | Emi     |
