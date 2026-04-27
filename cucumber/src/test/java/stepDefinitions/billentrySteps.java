package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import hooks.Hooks;
//import pages.IhmsPage;
import pages.billentryPage;
import utils.DriverFactory; 

public class billentrySteps {

	WebDriver driver = DriverFactory.getDriver(); 
//    IhmsPage ihmsPage = new IhmsPage(driver);
    billentryPage billentryPage = new billentryPage(driver);

    @Given("user is on the billing entry page")
    public void user_is_on_the_billing_entry_page() {
        billentryPage.openBillingPage(); 
    }

    @When("user enters UIN {string} and presses enter")
    public void user_enters_uin_and_presses_enter(String uin) {
    	billentryPage.enterUinAndSubmit(uin);
    }

    @Then("patient details should be displayed")
    public void patient_details_should_be_displayed() {
        String patientName = billentryPage.getPatientName();

        System.out.println("Patient Name: " + patientName);

        Assert.assertNotNull(patientName);
        Assert.assertFalse(patientName.isEmpty(), "Patient details not loaded");
    }

    @And("user clicks PayFree dropdown")
    public void user_clicks_pay_free_dropdown() {
        billentryPage.clickPayFreeDropdown();
    }

    @And("user selects {string} from PayFree dropdown")
    public void user_selects_from_pay_free_dropdown(String paymentMode) {
        billentryPage.selectPayFree(paymentMode);
    }

    @And("user clicks Advised By dropdown")
    public void user_clicks_advised_by_dropdown() {
    	billentryPage.clickAdvisedByDropdown();
    }

    @And("user selects {string} from Advised dropdown")
    public void user_selects_from_advised_by_dropdown(String advisedBy) {
    	billentryPage.selectAdvisedBy(advisedBy);
    }

    @Then("selected {string} option should be displayed")
    public void selected_option_should_be_displayed(String expectedValue) {

        String actualValue;

        // Checks whether expected is PAY/FREE or doctor name
        if(expectedValue.equalsIgnoreCase("PAY") || expectedValue.equalsIgnoreCase("FREE")) {

            actualValue = billentryPage.getSelectedPayFree();

        } else {

            actualValue = billentryPage.getSelectedAdvisedBy();
        }

        System.out.println("Expected: " + expectedValue);
        System.out.println("Actual: " + actualValue);

        Assert.assertEquals(
            actualValue.trim(),
            expectedValue.trim(),
            "Dropdown selection mismatch"
        );
    }
}