package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.billingPage;
import utils.DriverFactory;

public class billingSteps {

    WebDriver driver = DriverFactory.getDriver();
    billingPage billingPage = new billingPage(driver);

    @Given("user is on ihms dashboard")
    public void user_is_on_dashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "User is not on Dashboard");
        System.out.println("Successfully reached Dashboard");
    }

    @When("user navigates to Billing and selects {string}")
    public void navigate_and_select_bill_entry(String optionName) {

        billingPage.openBillingMenu();
        billingPage.clickBillEntry();
    }

    @Then("the Bill Entry page should be displayed")
    public void verify_bill_entry_page() {

        Assert.assertTrue(billingPage.isBillEntryPageLoaded(),
                "Navigation failed: Bill Entry page not loaded");

        System.out.println("Bill Entry Page Loaded Successfully");
    }
}