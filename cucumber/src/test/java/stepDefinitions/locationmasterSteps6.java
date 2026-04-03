package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DriverFactory;
import locators.locationmasterLocation;

import java.util.List;

public class locationmasterSteps6 {

    WebDriver driver = DriverFactory.getDriver();

    //NAVIGATION
    @When("user clicks on Location Master")
    public void user_clicks_on_location_master() {
        driver.findElement(locationmasterLocation.LOCATION_MASTER).click();
    }
    
    @Then("user should be navigated to Location Master page")
    public void user_should_be_navigated_to_location_master_page() {
        Assert.assertTrue( driver.getCurrentUrl().toLowerCase().contains("location"),"Location Master page not opened" );
    }

    //SEARCH
    @And("user searches location {string}")
    public void user_searches_location(String location) {
        WebElement search = driver.findElement(locationmasterLocation.locationSearchInput);
        search.clear();
        search.sendKeys(location);
        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    // POSITIVE
    @Then("location result should be displayed")
    public void location_result_should_be_displayed() {
        List<WebElement> rows = driver.findElements(locationmasterLocation.tableRows);
        
        Assert.assertTrue(rows.size() > 1, "Expected location results but none found");
    }

    //NEGATIVE
    @Then("no location result should be displayed")
    public void no_location_result_should_be_displayed() {
        List<WebElement> rows = driver.findElements(locationmasterLocation.tableRows);

        Assert.assertTrue(rows.size() <= 1, "Unexpected location results found");
    }
}