package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.DriverFactory;
import locators.IhmsLocator;  

public class IhmsSteps2 {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on dashboard")
    public void user_is_on_dashboard_page() {
        System.out.println("User is on dashboard Page");
    }
    
    @When("user selects the IHMS module")
    public void user_selects_the_ihms_module() {
        driver.findElement(IhmsLocator.ihmslogin).click();
    }
    
    @Then("user should be navigated to IHMS dashboard page")
    public void user_should_be_navigated_to_ihms_dashboard_page() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url != null && url.contains("ihms"),"IHMS page not loaded. Current URL: " + url);
        System.out.println("IHMS Dashboard loaded successfully");
    }
}