@login @dashboard
@billing

Feature: Billing Entry

  Scenario: Navigate to Bill Entry page
#   Given user is on ihms dashboard
    When user navigates to Billing and selects "Bill Entry"
    Then the Bill Entry page should be displayed