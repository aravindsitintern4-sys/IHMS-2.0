package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

import locators.billingLocator;
import utils.DriverFactory;

public class billingSteps {

    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Given("user is on ihms dashboard")
    public void user_is_on_dashboard() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        System.out.println("Successfully reached Dashboard");
    }

    @When("user navigates to Billing and selects {string}")
    public void navigate_and_select_bill_entry(String optionName) {
        Actions actions = new Actions(driver);

        WebElement billingMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(billingLocator.billingMenu));
        actions.moveToElement(billingMenu).perform();

        WebElement billEntryOption = wait.until(ExpectedConditions.elementToBeClickable(billingLocator.billEntryOption));
        
        billEntryOption.click();
    }

    @Then("the Bill Entry page should be displayed")
    public void verify_bill_entry_page() {
        boolean urlChanged = wait.until(ExpectedConditions.urlContains("bill-entry"));

        Assert.assertTrue(urlChanged, "Navigation failed: URL does not contain 'bill-entry'");
        
//         wait.until(ExpectedConditions.visibilityOfElementLocated(billingLocator.billEntryHeader));
        System.out.println("Bill Entry Page Loaded Successfully");
    }
}