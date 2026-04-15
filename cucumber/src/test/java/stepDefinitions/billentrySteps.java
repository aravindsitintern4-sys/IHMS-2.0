package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import hooks.Hooks;
import pages.billentryPage;
import locators.billentryLocator;

public class billentrySteps {

    billentryPage billPage = new billentryPage(Hooks.driver);

    @Given("user is on the billing entry page")
    public void user_is_on_the_billing_entry_page() {
        billPage.openBillingPage();
    }

    @When("user enters UIN {string} and presses enter")
    public void user_enters_uin_and_presses_enter(String uin) {
        billPage.enterUinAndSubmit(uin);
    }

    @Then("patient details should be displayed")
    public void patient_details_should_be_displayed() {
        String patientName = billPage.getPatientName();

        System.out.println("Patient Name: " + patientName);

        Assert.assertNotNull(patientName);
        Assert.assertFalse(patientName.isEmpty(), "Patient details not loaded");
    }

    @And("user selects Pay/Free as {string}")
    public void user_selects_pay_free(String mode) {
        billPage.selectPayFree(mode);
    }

    @And("user selects Advised By as {string}")
    public void user_selects_advised_by(String doctor) {
        billPage.selectAdvisedBy(doctor);
    }

    @Then("selected Pay/Free option should displayed")
    public void verify_pay_selection() {
        String selected = billPage.getSelectedOption(billentryLocator.paymentTypeDropdown);

        System.out.println("Selected Pay/Free: " + selected);

        Assert.assertNotNull(selected);
        Assert.assertFalse(selected.isEmpty(), "Pay/Free not selected");
    }

    @And("selected Advised By option should displayed")
    public void verify_advised_selection() {
        String selected = billPage.getSelectedOption(billentryLocator.AdviseByDropdown);

        System.out.println("Selected Doctor: " + selected);

        Assert.assertNotNull(selected);
        Assert.assertFalse(selected.equalsIgnoreCase("Select"), "Doctor not selected");
    }

//    @Then("user clicks on Cancel button")
//    public void user_clicks_on_cancel_button() {
//        billPage.clickCancel();
//    }
}