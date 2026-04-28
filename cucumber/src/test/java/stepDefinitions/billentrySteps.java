package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.billentryPage;
import utils.DriverFactory;

public class billentrySteps {

    WebDriver driver = DriverFactory.getDriver();
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

        Assert.assertNotNull(patientName, "Patient name is null");
        Assert.assertFalse(patientName.isEmpty(), "Patient details not loaded");
    }

    @And("user clicks PayFree dropdown")
    public void user_clicks_payfree_dropdown() {
    	billentryPage.clickPayFree();
    }

    @And("user selects {string} from PayFree dropdown")
    public void user_selects_payfree(String value) {
    	billentryPage.selectPayFree(value);
    }

    @And("user clicks Advised By dropdown")
    public void user_clicks_advised_by_dropdown() {
    	billentryPage.clickAdvisedBy();
    }

    @And("user selects {string} from Advised By dropdown")
    public void user_selects_advised_by(String value) {
    	billentryPage.selectAdvisedBy(value);
    }
    
    @And("user clicks Testname dropdown")
    public void user_clicks_testname_dropdown() {
    	billentryPage.clickTestNameDropdown();
    }
    
    @And("user selects test name {string} and presses enter")
    public void user_selects_test_name_and_presses_enter(String testName) {
    	billentryPage.selectTestNameAndEnter(testName);
    }
    
    @And("user selects payment category {string}")
    public void user_selects_payment_category(String category) {
    	billentryPage.selectPaymentCategory(category);
    }

    @And("user clicks on Fees field")
    public void user_clicks_on_fees_field() {
    	billentryPage.clickFeesField();
    }

    @And("user presses Enter in Fees field")
    public void user_presses_enter_in_fees_field() {
    	billentryPage.pressEnterInFees();
    }
    
    @And("user clicks Save button")
    public void user_clicks_save_button() {
    	billentryPage.clickSaveButton();
    }

    @And("user clicks Cancel button")
    public void user_clicks_cancel_button() {
    	billentryPage.clickCancelButton();
    }
}