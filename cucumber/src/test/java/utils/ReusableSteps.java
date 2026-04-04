package utils;

import io.cucumber.java.en.*;
import pages.reuseableCodePage;
import locators.reuseableCodeLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ReusableSteps {

    WebDriver driver = DriverFactory.getDriver();
    reuseableCodePage page = new reuseableCodePage(driver);
    
  //CLEAR
    @And("user clicks on Clear button")
    public void clear_button() {
        driver.findElement(reuseableCodeLocator.CLEAR_BUTTON).click();
    }
   
  //SAVE
    @When("user clicks on Save button")
    public void user_clicks_on_save_button_in_corporate() {
        page.clickSaveButton();
    }

    @Then("save button should be disabled")
    public void validate_save_disabled() {
    	WebElement saveBtn = driver.findElement(reuseableCodeLocator.SAVE_BUTTON);
        Assert.assertFalse(saveBtn.isEnabled(), "Save button should be disabled");
    }
    
    @And("user clicks Save button without entering any data")
    public void click_save_without_data() {
        driver.findElement(reuseableCodeLocator.SAVE_BUTTON).click();
    }
    
    @Then("insurance save button should be disabled")
    public void save_button_should_be_disabled() {
        Assert.assertFalse(page.isSaveEnabled(),"Save button should be disabled");
    }
    
    @Then("save button should be enabled")
    public void save_button_should_be_enabled() {
        Assert.assertTrue(page.isSaveEnabled(),"Save button should be enabled");
    }
    
  //OK BUTTON
    @And("user clicks OK on popup")
    public void ok_popup() {
        driver.findElement(reuseableCodeLocator.okButton).click();
    }
    
  //UPdate
    
    @And("update button should be displayed")
    public void verifyUpdateVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
        		reuseableCodeLocator.UPDATE_BUTTON)).isDisplayed());
    }
    
    @And("user clicks on Update button")
    public void click_update_button() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(reuseableCodeLocator.UPDATE_BUTTON));
        updateBtn.click();
    }
   
    
	
}
