package stepDefinitions;

import io.cucumber.java.en.*;
import utils.DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import locators.masterLocator;

public class MasterSteps3 {

    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

    @When("user clicks on Masters menu")
    public void user_clicks_on_masters_menu() {

        WebElement masters = wait.until(ExpectedConditions.visibilityOfElementLocated(masterLocator.MASTERS));

        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(masters).perform();  
    }
    
    @When("user selects Outpatient Masters")
    public void user_selects_outpatient_masters() {

        WebElement opMasters = wait.until(ExpectedConditions.elementToBeClickable(masterLocator.OUTPATIENT_MASTERS));

        opMasters.click();
    }

    @Then("user should be navigated to Outpatient Masters page")
    public void outpatient_masters_page_should_be_displayed() {

        wait.until(ExpectedConditions.urlContains("masters"));
        System.out.println("Outpatient Masters page opened successfully");
    }
}