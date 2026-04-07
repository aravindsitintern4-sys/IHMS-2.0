package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.MasterPage;
import utils.DriverFactory;
import org.testng.Assert;

public class MasterSteps3 {

    WebDriver driver = DriverFactory.getDriver();
    MasterPage masterPage = new MasterPage(driver);

    @When("user clicks on Masters menu")
    public void user_clicks_on_masters_menu() {
        masterPage.openMastersMenu();
    }

    @When("user selects Outpatient Masters")
    public void user_selects_outpatient_masters() {
        masterPage.clickOutpatientMasters();
    }

    @Then("user should be navigated to Outpatient Masters page")
    public void user_should_be_navigated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean isLoaded = wait.until(ExpectedConditions.urlContains("outpatient"));

        Assert.assertTrue(isLoaded, "Navigation failed");
    }
}