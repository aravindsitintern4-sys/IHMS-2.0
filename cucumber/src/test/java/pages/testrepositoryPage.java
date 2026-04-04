package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import locators.testrepositoryLocator;

public class testrepositoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public testrepositoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //DROPDOWN METHODS
    public void selectSiteType(String value) {
        Select select = new Select(driver.findElement(testrepositoryLocator.sitetypeDropdown));
        select.selectByVisibleText(value);
    }

    public void selectAccountHead(String value) {
        Select select = new Select(driver.findElement(testrepositoryLocator.accountheadDropdown));
        select.selectByVisibleText(value);
    }

    public void selectClinic(String value) {
        Select select = new Select(driver.findElement(testrepositoryLocator.clinicDropdown));
        select.selectByVisibleText(value);
    }

    public void selectPaymentType(String value) {
        Select select = new Select(driver.findElement(testrepositoryLocator.paymenttypeDropdown));
        select.selectByVisibleText(value);
    }

    public void selectPayFree(String value) {
        Select select = new Select(driver.findElement(testrepositoryLocator.patientclassDropdown));
        select.selectByVisibleText(value);
    }

    public void selectInjection(String value) {
        Select select = new Select(driver.findElement(testrepositoryLocator.injectionDropdown));
        select.selectByVisibleText(value);
    }

    //INPUT METHODS 
    public void enterTestName(String value) {
        WebElement ele = driver.findElement(testrepositoryLocator.testnameInput);
        ele.clear();
        ele.sendKeys(value);
    }

    public void enterTestCost(String value) {
        WebElement ele = driver.findElement(testrepositoryLocator.testcostInput);
        ele.clear();
        ele.sendKeys(value);
    }

//    BUTTON ACTIONS 
//    public void clickSave() {
//        driver.findElement(testrepositoryLocator.saveButton).click();
//    }
//
//    public void clickClear() {
//        driver.findElement(testrepositoryLocator.clearButton).click();
//    }
//
//    VALIDATIONS 
//    public boolean isSaveButtonEnabled() {
//        return driver.findElement(testrepositoryLocator.saveButton).isEnabled();
//    }

    public boolean isTestNameDisplayed() {
        return driver.findElement(testrepositoryLocator.testnameInput).getAttribute("value").length() > 0;
    }

    public String getPopupMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.popupMessage));
        return driver.findElement(testrepositoryLocator.popupMessage).getText();
    }

//    public void clickOkOnPopup() {
//        driver.findElement(testrepositoryLocator.okButton).click();
//    }

    //SEARCH 
    public int getSearchResultCount() {
        return driver.findElements(testrepositoryLocator.tableRows).size();
    }
    
    public void selectRow(String testName) {
        WebElement row = wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.testrepoName(testName)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", row);
    }

    //Click Update
//    public void clickUpdate() {
//        wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.updateButton)).click();
//    }

    //Click Delete
    public void clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.deleteButton)).click();
    }

    //Click Cancel
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.cancelbutton)).click();
    }

    //Validate Popup 
    public void validatePopup(String expectedMessage) {

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(testrepositoryLocator.popupMessage));

        String actualMessage = message.getText();
        System.out.println("Popup Message: " + actualMessage);

        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError(
                "Expected: " + expectedMessage + " but got: " + actualMessage
            );
        }
    }
   
    //OK Button
//    public void clickOK() {
//        wait.until(ExpectedConditions.elementToBeClickable(testrepositoryLocator.okButton)).click();
//    }

}