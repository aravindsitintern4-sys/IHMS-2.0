#@login @dashboard @outpatientmaster
@locationmaster
Feature: Location Master

Background:
  Given user is on dashboard group landing page
  When user clicks on Location Master
  Then user should be navigated to Location Master page

# POSITIVE
Scenario Outline: Location search validation
  And user searches location "<location>"
  Then location result should be displayed

Examples:
  | location        |
  | A-SCAN          |

#NEGATIVE
Scenario Outline: Location search negative validation
  And user searches location "<location>"
  Then no location result should be displayed

Examples:
  | location |
  | XYZ      |
  
