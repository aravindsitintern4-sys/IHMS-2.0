@login
Feature: Login Feature

Background:
  Given user is on login page

# INVALID LOGIN 

#Scenario Outline: Login with invalid credentials
#  When user enters username "<username>" and password "<password>"
#  And user clicks on login button
#  Then validation message should be displayed

#Examples:
#  | username  | password    |
#  | Dev       | wrong123    |
#  | Aravind   | test123     |
#  | abc       | abc123      |

#VALID LOGIN

Scenario: Valid Login
  When user enters username "aravindadmin" and password "aravind@123"
  And user clicks on login button
  Then user is navigated to ihms dashboard