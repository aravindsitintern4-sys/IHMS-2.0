package stepDefinitions;

import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import pages.billingPage;
import io.cucumber.java.en.*;

public class billingSteps {

    WebDriver driver = Hooks.driver;
    billingPage billingPage = new billingPage(driver);

    @When("User hovers on Billing menu")
    public void user_hovers_on_billing_menu() {
        billingPage.hoverOnBilling();
    }

    @When("User clicks on Bill Entry option")
    public void user_clicks_on_bill_entry_option() {
        billingPage.clickBillEntry();
    }

    @Then("user navigate to Bill Entry page")
    public void user_navigate_to_bill_entry_page() {
        billingPage.verifyBillEntryPage();
    }
}