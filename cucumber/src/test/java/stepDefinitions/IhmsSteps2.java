package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.IhmsPage;
import utils.DriverFactory; // Assuming you have a WebDriver factory class

public class IhmsSteps2 {

    WebDriver driver = DriverFactory.getDriver(); // get initialized driver
    IhmsPage ihmsPage = new IhmsPage(driver);

    @Given("user is on dashboard")
    public void user_is_on_dashboard() {
        Assert.assertNotNull(driver, "Driver is not initialized");
        ihmsPage.waitForDashboardToLoad();
    }

    @When("user selects the IHMS module")
    public void user_selects_the_ihms_module() {
        ihmsPage.clickIHMSModule();
    }

    @Then("IHMS dashboard page should be displayed")
    public void ihms_dashboard_page_should_be_displayed() {
        Assert.assertTrue(ihmsPage.isIHMSPageDisplayed(), "IHMS page is not displayed");
    }
} 