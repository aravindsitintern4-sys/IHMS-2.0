package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import locators.testrepositoryLocator;
import pages.testrepositoryPage;

public class testrepositoryStep8 {

    WebDriver driver;
    WebDriverWait wait;
    testrepositoryPage page;
    
    String selectedSite;
    String selectedCorporate;

    public testrepositoryStep8() {
        driver = Hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        page = new testrepositoryPage(driver);
    }

    //NAVIGATION
    @When("user clicks on Test Repository Master")
    public void user_clicks_on_Test_Master() {
        driver.findElement(testrepositoryLocator.TEST_REPOSITORY).click();
    }
    @Then("user should be navigated to Test Cost Master")
    public void verify_navigation() {
        Assert.assertTrue(driver.getCurrentUrl().contains("testcostmaster"),"Test Cost Master page not opened");
    }
    
  //DROPDOWNS 
    //Site Type
    @When("user selects Site Type {string}")
    public void selectSiteType(String value) {
        new Select(driver.findElement(testrepositoryLocator.sitetypeDropdown)).selectByVisibleText(value);
    }
    @Then("selected Site Type should be displayed")
    public void verifySelectedSiteType() {
        Select select = new Select(driver.findElement(testrepositoryLocator.sitetypeDropdown));
        
        String selectedValue = select.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedValue != null && !selectedValue.equals("--Select--"),"Site Type is not selected properly");
    }
    
    //Account Head
    @When("user selects Account Head {string}")
    public void selectAccountHead(String value) {
        new Select(driver.findElement(testrepositoryLocator.accountheadDropdown)).selectByVisibleText(value);
    }
    @Then("selected Account Head should be displayed")
    public void verifySelectedAccounthead() {
        Select select = new Select(driver.findElement(testrepositoryLocator.accountheadDropdown));
        
        String selectedValue = select.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedValue != null && !selectedValue.equals("--Select--"),"Account Head is not selected properly");
    }
    
    //Clinic
    @When("user selects Clinic {string}")
    public void selectClinic(String value) {
        new Select(driver.findElement(testrepositoryLocator.clinicDropdown)).selectByVisibleText(value);
    }
    @Then("selected Clinic should be displayed")
    public void verifySelectedClinic() {
        Select select = new Select(driver.findElement(testrepositoryLocator.clinicDropdown));
        
        String selectedValue = select.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedValue != null && !selectedValue.equals("--Select--"),"Clinic is not selected properly");
    }

    //Payment
    @When("user selects Payment Type {string}")
    public void selectPaymentType(String value) {
        new Select(driver.findElement(testrepositoryLocator.paymenttypeDropdown)).selectByVisibleText(value);
    }
    @Then("selected Payment Type should be displayed")
    public void verifySelectedPayment() {
        Select select = new Select(driver.findElement(testrepositoryLocator.paymenttypeDropdown));
        
        String selectedValue = select.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedValue != null && !selectedValue.equals("--Select--"),"Payment is not selected properly");
    }
    
    //Site and Corporate DropDown
    @When("user selects Site {string}")
    public void selectSite1(String site) {
        new Select(driver.findElement(testrepositoryLocator.siteDropdown))
                .selectByVisibleText(site);
    }
    
    @When("user selects Corporate {string}")
    public void selectCorporate1(String corporate) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement corporateDropdown = wait.until(
            ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.corporateDropdown)
        );
        wait.until(driver -> 
            new Select(corporateDropdown).getOptions().size() > 1
        );
        new Select(corporateDropdown).selectByVisibleText(corporate);
    }
    
    @Then("selected Site should be displayed")
    public void selected_site_should_be_displayed() {
            Select select = new Select(driver.findElement(testrepositoryLocator.siteDropdown));
            String actualSite = select.getFirstSelectedOption().getText();

            Assert.assertEquals(actualSite, selectedSite, "Selected site is not matching!");
        }

        @Then("selected Corporate should be displayed")
        public void selected_corporate_should_be_displayed() {
            Select select = new Select(driver.findElement(testrepositoryLocator.corporateDropdown));
            String actualCorporate = select.getFirstSelectedOption().getText();

            Assert.assertEquals(actualCorporate, selectedCorporate, "Selected corporate is not matching!");
       }
    

    //PayFree
    @When("user selects PayFree {string}")
    public void selectPayFree(String value) {
        new Select(driver.findElement(testrepositoryLocator.patientclassDropdown)).selectByVisibleText(value);
    }
    
    @Then("selected PayFree Type should be displayed")
    public void verifySelectedPayFree() {
        Select select = new Select(driver.findElement(testrepositoryLocator.patientclassDropdown));
        
        String selectedValue = select.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedValue != null && !selectedValue.equals("--Select--"),"PayFree is not selected properly");
    }

    //Injection
    @When("user selects IsInjection {string}")
    public void selectInjection(String value) {
        new Select(driver.findElement(testrepositoryLocator.injectionDropdown)).selectByVisibleText(value);
    }
    
    @Then("selected IsInjection should be displayed")
    public void verifySelectedIsinjection() {
        Select select = new Select(driver.findElement(testrepositoryLocator.injectionDropdown));
        
        String selectedValue = select.getFirstSelectedOption().getText();

        Assert.assertTrue(selectedValue != null && !selectedValue.equals("--Select--"),"IsInjection is not selected properly");
    }

    //Test Name
    @When("user enters Test Name {string}")
    public void enterTestName(String value) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.testnameInput));
        ele.clear();
        ele.sendKeys(value);
    }
    
    @Then("entered Test Name should be displayed")
    public void verifyTestName() {
        String value = driver.findElement(testrepositoryLocator.testnameInput).getAttribute("value");

        Assert.assertTrue(value != null && !value.isEmpty());
    }
    
    //Test Cost
    @When("user enters Test Cost {string}")
    public void enterTestCost(String value) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.testcostInput));
        ele.clear();
        ele.sendKeys(value);
    }
    
    @Then("entered Test Cost should be displayed")
    public void verifyTestCost() {
        String value = driver.findElement(testrepositoryLocator.testcostInput).getAttribute("value");

        Assert.assertTrue(value != null && !value.isEmpty(),"Test Cost is not entered");
    }

    //BUTTONS 
//    @When("user clicks Save button")
//    public void clickSave() {
//        wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.saveButton)).click();
//    }

//    @When("user clicks on Clear button")
//    public void clickClear() {
//        wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.clearButton)).click();
//    }

    //VALIDATIONS 
//    @Then("save button should be disabled")
//    public void verifySaveDisabled() {
//        Assert.assertFalse(driver.findElement(testrepositoryLocator.saveButton).isEnabled());
//    }
//
//    @Then("save button should be enabled")
//    public void verifySaveEnabled() {
//        Assert.assertTrue(driver.findElement(testrepositoryLocator.saveButton).isEnabled());
//    }

    @Then("test cost should be saved successfully")
    public void verifySuccess() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.popupMessage));

        String msg = driver.findElement(testrepositoryLocator.popupMessage).getText();

        Assert.assertTrue(msg.contains("saved successfully"));

        driver.findElement(testrepositoryLocator.okButton).click();
    }
    
    //Negative
    @And("user leaves test cost {string} empty")
    public void user_leaves_test_cost_empty(String fieldName) {

        switch (fieldName.trim().toLowerCase()) {
            case "site type":
                new Select(driver.findElement(testrepositoryLocator.sitetypeDropdown)).selectByIndex(0);
                break;
            case "account head":
                new Select(driver.findElement(testrepositoryLocator.accountheadDropdown)).selectByIndex(0);
                break;
            case "clinic":
            	new Select(driver.findElement(testrepositoryLocator.clinicDropdown)).selectByIndex(0);
                break;
            case "payment type":
                new Select(driver.findElement(testrepositoryLocator.paymenttypeDropdown)).selectByIndex(0);
                break;
            case "test name":
            	driver.findElement(testrepositoryLocator.testnameInput).clear();
            case "payfree":
                new Select(driver.findElement(testrepositoryLocator.patientclassDropdown)).selectByIndex(0);
                break;
            case "test cost":
            	driver.findElement(testrepositoryLocator.testcostInput).clear();
                break;
            case "is injection":
                new Select(driver.findElement(testrepositoryLocator.injectionDropdown)).selectByIndex(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + fieldName);
        }
    }

    //SEARCH
    @When("user enters test name in search {string}")
    public void searchTestName(String value) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.searchInput));
        ele.clear();
        ele.sendKeys(value);
    }

    @Then("test name search result should be displayed")
    public void verifySearchResult() {
        Assert.assertTrue(driver.findElements(testrepositoryLocator.tableRows).size() > 0);
    }

    @Then("no test name result should be displayed")
    public void verifyNoResult() {
        Assert.assertEquals(driver.findElements(testrepositoryLocator.tableRows).size(), 0);
    }
    
    //Update
    @When("user selects row with Test Name {string}")
    public void clickTestRow(String testName) {
        driver.findElement(testrepositoryLocator.testrepoName(testName)).click();
    }
    
    @When("user enters Test Cost {string} in testrepo")
    public void enter_test_cost(String cost) {
        page.enterTestCost(cost);
    }
    
//    @When("user clicks on Update button")
//    public void click_update() {
//        page.clickUpdate();
//    }
    
    @Then("update success popup should be displayed with message {string}")
    public void validate_update_popup(String expectedMessage) {
        page.validatePopup(expectedMessage);
    }
    
    @When("user clicks on Delete button")
    public void click_delete() {
        page.clickDelete();
    }
    
    @Then("delete success popup should be displayed with message {string}")
    public void validate_delete_popup(String expectedMessage) {
        page.validatePopup(expectedMessage);
    }
    
    @When("user clicks on Cancel button")
    public void click_cancel() {
        page.clickCancel();
    }

    
//    @Then("user clicks OK on popup ")
//    public void click_ok() {
//        page.clickOK();
//    }
}