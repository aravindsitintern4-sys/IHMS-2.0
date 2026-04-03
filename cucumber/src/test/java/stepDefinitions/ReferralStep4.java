package stepDefinitions;

import io.cucumber.java.en.*;
import pages.ReferralMasterPage;
import locators.referralmasterLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverFactory;

public class ReferralStep4 {

    WebDriver driver = DriverFactory.getDriver();
    ReferralMasterPage page = new ReferralMasterPage(driver);
    
   
    
    @When("user clicks on Referral Master")
    public void user_clicks_on_referral_master() {
    	page.click(referralmasterLocator.REFERRAL_MASTER);
    }
    
    @Then("user should be navigated to referral master page")
    public void user_should_be_navigated() {
        Assert.assertTrue(driver.getCurrentUrl().contains("referral"),"Referral page not opened");
    }

    //INPUT FIELDS
    @And("user enters Referral Name {string}")
    public void enter_referral_name(String name) {
    	WebElement field = driver.findElement(referralmasterLocator.REFERRAL_NAME);
        field.clear();
        field.sendKeys(name);
    }
    
    @And("user enters Referral Address 1 {string}")
    public void enter_address1(String addr) {
        WebElement field = driver.findElement(referralmasterLocator.ADDRESS1);
        field.clear();
        field.sendKeys(addr);
    }
    
    @And("user enters Referral Address 2 {string}")
    public void enter_address2(String addr) {
        driver.findElement(referralmasterLocator.ADDRESS2).sendKeys(addr);
    }
    
    @And("user enters Referral Address 3 {string}")
    public void enter_address3(String addr) {
        driver.findElement(referralmasterLocator.ADDRESS3).sendKeys(addr);
    }
    
    @And("user enters Phone No {string}")
    public void enter_phone(String phone) {
    	 WebElement field = driver.findElement(referralmasterLocator.PHONE_NO);
        field.clear();
        field.sendKeys(phone);
    }
    
    @And("user enters Fax {string}")
    public void enter_fax(String fax) {
        WebElement field = driver.findElement(referralmasterLocator.FAX);
        field.clear();
        field.sendKeys(fax);
    }
    
    @And("user enters Email ID {string}")
    public void enter_email(String email) {
    	WebElement field = driver.findElement(referralmasterLocator.EMAIL);
        field.clear();
        field.sendKeys(email);
    }
    
    @And("user enters Contact Person {string}")
    public void enter_contact_person(String name) {
        WebElement field = driver.findElement(referralmasterLocator.CONTACT_PERSON);
        field.clear();
        field.sendKeys(name);
    }

    //SAVE BUTTON
    @Then("save button should be disabled")
    public void validate_save_disabled() {
    	WebElement saveBtn = driver.findElement(referralmasterLocator.SAVE_BUTTON);
        Assert.assertFalse(saveBtn.isEnabled(), "Save button should be disabled");
    }

    //VALIDATIONS
    @Then("only alphabets should be entered in referral name field")
    public void validate_referral_name() {
    	String value = driver.findElement(referralmasterLocator.REFERRAL_NAME).getAttribute("value");
        Assert.assertTrue(value.matches("[a-zA-Z ]*"),"Invalid characters in referral name");
    }
    
    @Then("validation for referral address 1 field")
    public void validate_address1() {
    	String value = driver.findElement(referralmasterLocator.ADDRESS1).getAttribute("value");
        Assert.assertTrue(value.matches("[a-zA-Z0-9 ,]*"),"Invalid Address1");
    }
    
    @Then("validation for fax field")
    public void validation_for_fax_field() {
        String fax = driver.findElement(referralmasterLocator.FAX).getAttribute("value");
        if (!fax.matches("\\d{6,}")) {
            System.out.println("Invalid Fax: " + fax);
        } else {
            System.out.println("Valid Fax: " + fax);
        }
    }
    
    @Then("validation for phone number field")
    public void validate_phone() {
    	String phone = driver.findElement(referralmasterLocator.PHONE_NO).getAttribute("value");
        Assert.assertTrue(phone.matches("\\d{10}"),"Invalid phone number");
    }
    
    @Then("validation for email field")
    public void validate_email() {
        String email = driver.findElement(By.id("email")).getAttribute("value");
        Assert.assertTrue(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"),"Invalid email");
    }

    @Then("only alphabets should be entered in contact person field")
    public void validate_contact_person() {
        String value = driver.findElement(By.id("contactPerson")).getAttribute("value");
        Assert.assertTrue(value.matches("[a-zA-Z ]*"),"Invalid contact person");
    }

    //DROPDOWN
    @When("user clicks on Referral Type dropdown")
    public void click_dropdown() {
        driver.findElement(By.id("referralType")).click();
    }
    
    @Then("user should see all 7 options in dropdown")
    public void validate_dropdown() {
        int size = driver.findElements(By.xpath("//select[@id='referralType']/option")).size();
        Assert.assertEquals(size, 7);
    }
    
    @When("user selects Referral Type {string}")
    public void select_type(String type) {
        WebElement dropdown = driver.findElement(referralmasterLocator.REFERRAL_TYPE);
        Select select = new Select(dropdown);
        select.selectByVisibleText(type);
    }
    
    @Then("selected referral type should be displayed")
    public void validate_selected_type() {
    	int rows = driver.findElements(referralmasterLocator.referralResults).size();
        Assert.assertTrue(rows > 0, "No search results found");
    }

    //CLEAR BUTTON
    @And("user clicks on Clear button in referral")
    public void click_clear() {
    	driver.findElement(referralmasterLocator.CLEAR_BUTTON).click();
    }
    
    @Then("entered referral details should be cleared")
    public void validate_clear() {
        Assert.assertEquals(driver.findElement(By.id("referralName")).getAttribute("value"), "");
        Assert.assertEquals(driver.findElement(By.id("phone")).getAttribute("value"), "");
        Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value"), "");
        System.out.println("Fields cleared");
    }
    
    //search 
    @When("user enters referral name in search {string}")
    public void user_enters_referral_name_in_search(String referralName) {
        page.searchReferral(referralName);
    }
    
    @Then("referral name search result should be displayed")
    public void referral_search_result() {
        int rows = driver.findElements(referralmasterLocator.referralResults).size();
        Assert.assertTrue(rows > 0, "No results found");
    }
    
    @Then("no referral name result should be displayed")
    public void no_referral_result_should_be_displayed() {
        int rows = driver.findElements(referralmasterLocator.referralResults).size();
        Assert.assertTrue(rows == 0, "Unexpected results found");
    }
    
 //UPDATE
    
    @When("user clicks referral row {string}")
    public void clickReferralRow(String refName) {
        driver.findElement(referralmasterLocator.referralRowByName(refName)).click();
    }

    @Then("referral details should be loaded in input fields")
    public void verifyDetailsLoaded() {
        String value = driver.findElement(referralmasterLocator.REFERRAL_NAME).getAttribute("value");
        Assert.assertFalse(value.isEmpty());
    }

    @And("update button should be displayed in referral")
    public void verifyUpdateVisible() {
        Assert.assertTrue(driver.findElement(referralmasterLocator.UPDATE_BUTTON).isDisplayed());
    }

    @When("user updates {string} with {string} in referral")
    public void dynamicUpdate(String field, String value) {
    	WebElement input = page.getDynamicField(field);
        input.clear();
        input.sendKeys(value);
    }

    @And("user clicks Update button in referral")
    public void clickUpdate() {
        page.click(By.id("update_btn"));
    }

    @Then("update success popup should be displayed in referral")
    public void verifyUpdateSuccess() {
    	Assert.assertTrue(driver.findElement(referralmasterLocator.updateSuccessMessage).isDisplayed());
    }

    @And("user clicks OK button in referral")
    public void clickOk() {
    	driver.findElement(referralmasterLocator.okButton).click();
    }
}