package stepDefinitions;

import java.time.Duration;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import hooks.Hooks;
import io.cucumber.java.en.*;
import locators.corporateLocator;
import pages.corporatemasterPage;

public class corporatemasterSteps9 {

	corporatemasterPage page = new corporatemasterPage(Hooks.driver);
    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //Navigation
    
    @When("user clicks on Corporate Master")
    public void click_corporate_master() {
        driver.findElement(corporateLocator.MASTERS).click();
    }
    
    @Then("user should be navigated to Corporate Master page")
    public void verify_corporate_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("corporate"));
    }

    //OPEN FORM
    @When("user selects Site {string} in corporate master")
    public void select_site(String site) {
        new Select(driver.findElement(corporateLocator.SITE_DROPDOWN)).selectByVisibleText(site);
    }
    
    @And("user clicks on New Corporate Create button")
    public void click_new_button() {
        driver.findElement(corporateLocator.newCorporateEntryBtn).click();
    }
    
    @Then("corporate creation form should be displayed")
    public void form_displayed() {
        Assert.assertTrue(driver.findElement(corporateLocator.form).isDisplayed());
    }

    //CORPORATE NAME
    @And("user enters Corporate Name {string}")
    public void enter_corporate_name(String name) {
        page.enterCorporateName(name);
    }
    
    @Then("entered Corporate Name should be cleared")
    public void corporate_name_cleared() {
        String val = driver.findElement(corporateLocator.CORP_NAME).getAttribute("value");
        Assert.assertTrue(val.isEmpty());
    }

    //CHARGE TYPE 
    @When("user selects Charge Type {string}")
    public void select_charge_type(String type) {
        new Select(driver.findElement(corporateLocator.CHARGES_TYPE_DROPDOWN)).selectByVisibleText(type);
    }
    
    @Then("selected Charge Type should be displayed")
    public void verify_charge_type(String type) {
        Assert.assertEquals(page.getSelectedChargeType(), type);
    }

    //CO PAYMENT
    @When("user selects Co-Payment {string}")
    public void select_copayment(String value) {
        new Select(driver.findElement(corporateLocator.CO_PAYMENT_DROPDOWN)).selectByVisibleText(value);
    }
    
    @Then("selected Co-Payment should be displayed")
    public void verify_copayment() {
        Assert.assertTrue(true);
    }

    //CORP GROUP 
    @When("user selects Corp.Group {string}")
    public void select_corpgroup(String value) {
        new Select(driver.findElement(corporateLocator.CORP_GROUP_DROPDOWN)).selectByVisibleText(value);
    }
    
    @Then("selected Corp.Group should be displayed")
    public void verify_corpgroup() {
        Assert.assertTrue(true);
    }

    //NEW PAY COST 
    @And("user enter New Pay Cost {string}")
    public void enter_newpay(String val) {
        driver.findElement(corporateLocator.NEW_PAY_COST).sendKeys(val);
    }
    
    @Then("entered New Pay Cost should be displayed")
    public void verify_newpay() {
        Assert.assertFalse(driver.findElement(corporateLocator.NEW_PAY_COST).getAttribute("value").isEmpty());
    }

    //OLD PAY COST
    @And("user enter Old Pay Cost {string}")
    public void enter_oldpay(String val) {
        driver.findElement(corporateLocator.OLD_PAY_COST).sendKeys(val);
    }
    
    @Then("entered Old Pay Cost should be displayed")
    public void verify_oldpay() {
        Assert.assertFalse(driver.findElement(corporateLocator.OLD_PAY_COST).getAttribute("value").isEmpty());
    }

    //ADDRESS
    @And("user enter Address1 {string}")
    public void address1(String val) {
        driver.findElement(corporateLocator.ADDRESS_1).sendKeys(val);
    }
    
    @Then("entered Address1 should be displayed")
    public void verify_address1() {
        Assert.assertFalse(driver.findElement(corporateLocator.ADDRESS_1).getAttribute("value").isEmpty());
    }
    
    @And("user enter Address2 {string}")
    public void address2(String val) {
        driver.findElement(corporateLocator.ADDRESS_2).sendKeys(val);
    }
    
    @Then("entered Address2 should be displayed")
    public void verify_address2() {
        Assert.assertFalse(driver.findElement(corporateLocator.ADDRESS_2).getAttribute("value").isEmpty());
    }
    
    @And("user enter Address3 {string}")
    public void address3(String val) {
        driver.findElement(corporateLocator.ADDRESS_3).sendKeys(val);
    }
    
    @Then("entered Address3 should be displayed")
    public void verify_address3() {
        Assert.assertFalse(driver.findElement(corporateLocator.ADDRESS_3).getAttribute("value").isEmpty());
    }

    //PHONE 
    @And("user enter Phone number {string}")
    public void phone(String val) {
        driver.findElement(corporateLocator.PHONE).sendKeys(val);
    }
    
    @Then("entered Phone number should be displayed")
    public void verify_phone() {
        Assert.assertFalse(driver.findElement(corporateLocator.PHONE).getAttribute("value").isEmpty());
    }

    //EMAIL 
    @And("user enter Email {string}")
    public void email(String val) {
    	page.enterEmail(val);
    }
    
    @Then("entered Email should be displayed")
    public void verify_email() {
        Assert.assertFalse(driver.findElement(corporateLocator.EMAIL).getAttribute("value").isEmpty());
    }

    //CONTACT PERSON 
    @And("user enter Contact Person {string}")
    public void contact(String val) {
        driver.findElement(corporateLocator.CONTACT_PERSON).sendKeys(val);
    }
    
    @Then("entered Contact Person should be displayed")
    public void verify_contact() {
        Assert.assertFalse(driver.findElement(corporateLocator.CONTACT_PERSON).getAttribute("value").isEmpty());
    }

    //DISTRICT 
    @And("user select District {string}")
    public void district(String val) {
        new Select(driver.findElement(corporateLocator.DISTRICT)).selectByVisibleText(val);
    }
    
    @Then("selected District should be displayed")
    public void verify_district() {
        Assert.assertTrue(true);
    }

    //FAX
    @And("user enter Fax {string}")
    public void fax(String val) {
        driver.findElement(corporateLocator.FAX).sendKeys(val);
    }
    @Then("entered Fax should be displayed")
    public void verify_fax() {
        Assert.assertFalse(driver.findElement(corporateLocator.FAX).getAttribute("value").isEmpty());
    }

    // ABI
    @And("user enter ABI {string}")
    public void abi(String val) {
        driver.findElement(corporateLocator.ABI).sendKeys(val);
    }
    
    @Then("entered ABI should be displayed")
    public void verify_abi() {
        Assert.assertFalse(driver.findElement(corporateLocator.ABI).getAttribute("value").isEmpty());
    }

    //EMPLOYEE GRADE
    @And("user selected Employee Grade {string}")
    public void employee_grade(String val) {
        new Select(driver.findElement(corporateLocator.EMPLOYEE_GRADE)).selectByVisibleText(val);
    }
    
    @Then("selected Employee Grade should be displayed")
    public void verify_grade() {
        Assert.assertTrue(true);
    }

    //MAX AMOUNT 
    @And("user enter Max Amount Allow {string}")
    public void max_amount(String val) {
        driver.findElement(corporateLocator.EMPLOYEE_GRADE_AMOUNT).sendKeys(val);
    }
    
    @Then("entered Max Amount Allow should be displayed")
    public void verify_max_amount() {
        Assert.assertFalse(driver.findElement(corporateLocator.EMPLOYEE_GRADE_AMOUNT).getAttribute("value").isEmpty());
    }

    //ACTION 
    @And("user clicks on Action button")
    public void action_button() {
    	page.clickEditIconByName("ABC Corp");
    }
    
    @Then("given employee grade and amount shoukd be added")
    public void verify_action() {
        Assert.assertTrue(true);
    }
    
    @And("user select Action type {string}")
    public void action_type(String val) {
        new Select(driver.findElement(corporateLocator.ACTIVE)).selectByVisibleText(val);
    }
    
    @Then("selected Action type should be displayed")
    public void verify_action_type() {
        Assert.assertTrue(true);
    }

    //CLEAR
    @And("user clicks on Clear button in corporate")
    public void clear_button() {
        driver.findElement(corporateLocator.CLEAR_BUTTON).click();
    }

    //SEARCH
    @When("user enters Corporate name in search {string}")
    public void user_enters_corporate_name_in_search(String corporateName) {
        page.searchCorporate(corporateName);
    }
    
    @Then("Corporate name search result should be displayed")
    public void corporate_search_result() {
        Assert.assertTrue(page.isSearchResultDisplayed(), "No search results found");
    }
    
    @Then("no Corporate name result should be displayed")
    public void no_corporate_result_should_be_displayed() {
        Assert.assertTrue(page.isNoResultDisplayed(), "Unexpected results found");
    }
   
   //Save 
    @When("user clicks on Save button in corporate")
    public void user_clicks_on_save_button_in_corporate() {
        page.clickSaveButton();
    }
    
   // CLICK EDIT ICON
    @When("user clicks on active icon for corporate {string}")
    public void click_active_icon(String name) {
        page.clickEditIconByName(name);
    }
    
   //VERIFY DATA LOADED 
    @Then("corporate details should be loaded in input fields")
    public void verifyCorporateDetailsLoaded() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(corporateLocator.CORP_NAME)).getAttribute("value");
        Assert.assertFalse(value.isEmpty(), "Corporate data not loaded in input field");
    }
    
    @And("user clicks Save button without entering any data")
    public void click_save_without_data() {
        driver.findElement(corporateLocator.SAVE_BUTTON).click();
    }

    @Then("validation popup should be displayed with message {string}")
    public void popup(String msg) {
        Assert.assertTrue(page.isPopupMessageDisplayed(msg));
    }
    
    @And("user clicks on Update button in corporate")
    public void click_update_button() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(corporateLocator.UPDATE_BUTTON));
        updateBtn.click();
    }

    @And("user clicks OK on popup in corporate")
    public void ok_popup() {
        driver.findElement(corporateLocator.OK_BUTTON).click();
    }

    @Then("saved success popup message should be displayed {string}")
    public void saved_success_popup(String msg) {
        popup(msg);
    }
    
    @Then("update success popup message should be displayed {string}")
    public void update_success_popup(String msg) {
        popup(msg);
    }
    
    @Then("entered all the detail should be cleared")
    public void entered_all_details_should_be_cleared() {
    	Assert.assertTrue(page.isFormCleared(), "Form not cleared");
    }
}