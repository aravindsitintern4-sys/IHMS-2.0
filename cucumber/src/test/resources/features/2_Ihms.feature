@login
@dashboard
Feature: IHMS dashboard feature

Scenario: Verify user can access IHMS dashboard
  Given user is on dashboard 
  When user selects the IHMS module
  Then IHMS dashboard page should be displayed