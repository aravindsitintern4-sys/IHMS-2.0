#@login @dashboard
#@outpatientmaster
Feature: Masters Navigation

Scenario: Open Outpatient Masters
  Given user is on dashboard
  When user clicks on Masters menu
  And user selects Outpatient Masters
  Then user should be navigated to Outpatient Masters page 