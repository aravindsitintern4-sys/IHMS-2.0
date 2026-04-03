package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import locators.insurancesmasterLocators;
import pages.insurancesmasterPage;

public class insurancesmasterSteps7 {

    WebDriver driver = Hooks.driver;
    insurancesmasterPage page = new insurancesmasterPage(driver);

    //NAVIGATION
    @When("user clicks on Insurance Master")
    public void user_clicks_on_insurance_master() {
    	driver.findElement(By.id("insurancesmaster")).click();
    }
    
    @Then("user should be navigated to Insurance Master page")
    public void user_should_be_navigated_to_insurance_master_page() {
    	Assert.assertTrue(driver.getCurrentUrl().contains("insurances"),"insurance page not opened");
    }

    //INPUT 
    @When("user enters insurance name {string}")
    public void user_enters_insurance_name(String insuranceName) {
        page.enterInsuranceName(insuranceName);
    }
    
    @When("user enters insurance short name {string}")
    public void user_enters_insurance_short_name(String shortName) {
        page.enterShortName(shortName);
    }

    //BUTTON ACTIONS 
    @When("user clicks on Save button in insurance page")
    public void user_clicks_on_save_button() {
        page.clickSave();
    }
    
    @When("user clicks on Clear button in insurance page")
    public void user_clicks_on_clear_button() {
        page.clickClear();
    }

    //EMPTY FIELD 
    @When("user leaves insurance {string} empty")
    public void user_leaves_field_empty(String field) {
        page.leaveFieldEmpty(field);
    }

    //SAVE BUTTON VALIDATION
    @Then("insurance save button should be disabled")
    public void save_button_should_be_disabled() {
        Assert.assertFalse(page.isSaveEnabled(),"Save button should be disabled");
    }
    
    @Then("Save button should be enabled")
    public void save_button_should_be_enabled() {
        Assert.assertTrue(page.isSaveEnabled(),"Save button should be enabled");
    }

    //CLEAR VALIDATION 
    @Then("all fields should be cleared")
    public void all_fields_should_be_cleared() {
        Assert.assertTrue(page.areFieldsCleared(),"Fields are not cleared");
    }

    //SAVE SUCCESS 
    @Then("insurance should be saved successfully")
    public void insurance_should_be_saved_successfully() {
        Assert.assertTrue(page.isSaveSuccessful(),"Insurance not saved successfully");
    }

    //LENGTH VALIDATION
    @Then("insurance name should not exceed 100 characters")
    public void insurance_name_should_not_exceed_100_characters() {
        Assert.assertTrue(page.isInsuranceNameLengthValid(),"Insurance name exceeded 100 characters");
    }
    
    @Then("short name should not exceed 15 characters")
    public void short_name_should_not_exceed_15_characters() {
        Assert.assertTrue(page.isShortNameLengthValid(),"Short name exceeded 15 characters");
    }

    //SEARCH
    @When("user enters insurance name in search {string}")
    public void user_enters_insurance_name_in_search(String insuranceName) {
        page.searchInsurance(insuranceName);
    }
    
    @Then("insurance search result should be displayed")
    public void insurance_search_result() {
        Assert.assertTrue(page.isSearchResultDisplayed(),"No search results found");
    }
    
    @Then("no insurance result should be displayed")
    public void no_insurance_result_should_be_displayed() {
        Assert.assertTrue(page.isNoResultDisplayed(),"Unexpected results found");
    }
    
  //UPDATE 
    @When("user clicks insurancemaster row {string}")
    public void clickInsuranceRow(String code) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                insurancesmasterLocators.insurancesRowByName(code)))
            .click();
    }

    @Then("insurancemaster details should be loaded in input fields")
    public void verifyDetailsLoaded() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(
                insurancesmasterLocators.insShortNameInput))
            .getAttribute("value");

        Assert.assertFalse(value.isEmpty(), "Data not loaded in input field");
    }

    @And("update button should be displayed in insurancemaster")
    public void verifyUpdateVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                insurancesmasterLocators.UPDATE_BUTTON)).isDisplayed());
    }
    
    @When("user updates {string} with {string} in insurancemaster")
    public void dynamicUpdate(String field, String value) {

        page.updateField(field, value); 
    }

    @And("user clicks Update button in insurancemaster")
    public void clickUpdate() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                insurancesmasterLocators.UPDATE_BUTTON)).click();
    }
      
    @Then("update success popup should be displayed in insurancemaster")
    public void verifyPopup() {

        String msg = page.getPopupMessage();

        Assert.assertTrue(
            msg.contains("Already Exist") || msg.contains("Success"),
            "Popup not displayed"
        );
    }

    @And("user clicks OK button in insurancemaster")
    public void clickOk() {
    	
        page.clickOkButton();
    }
}
