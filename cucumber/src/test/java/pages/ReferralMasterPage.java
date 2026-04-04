package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import locators.referralmasterLocator;

public class ReferralMasterPage {

    WebDriver driver;
    WebDriverWait wait;

    public ReferralMasterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //NAVIGATION
    public void clickReferralMaster() {
        driver.findElement(referralmasterLocator.REFERRAL_MASTER).click();
    }

    public boolean isReferralPageLoaded() {
        return driver.getCurrentUrl().contains("referral");
    }

    //ROW SELECTION
    public void selectReferralRow(String refName) {
        By row = By.xpath("//td[normalize-space()='" + refName + "']");
        wait.until(ExpectedConditions.elementToBeClickable(row)).click();
    }

    //DATA LOAD CHECK
    public boolean isDataLoaded() {
        String value = driver.findElement(referralmasterLocator.REFERRAL_CODE)
                .getAttribute("value");
        return value != null && !value.isEmpty();
    }

    //INPUT METHODS
    public void enterReferralName(String value) {
        WebElement e = driver.findElement(referralmasterLocator.REFERRAL_NAME);
        e.clear();
        e.sendKeys(value);
    }

    public void enterAddress1(String value) {
        WebElement e = driver.findElement(referralmasterLocator.ADDRESS1);
        e.clear();
        e.sendKeys(value);
    }

    public void enterAddress2(String value) {
        WebElement e = driver.findElement(referralmasterLocator.ADDRESS2);
        e.clear();
        e.sendKeys(value);
    }

    public void enterAddress3(String value) {
        WebElement e = driver.findElement(referralmasterLocator.ADDRESS3);
        e.clear();
        e.sendKeys(value);
    }

    public void enterPhone(String value) {
        WebElement e = driver.findElement(referralmasterLocator.PHONE_NO);
        e.clear();
        e.sendKeys(value);
    }

    public void enterFax(String value) {
        WebElement e = driver.findElement(referralmasterLocator.FAX);
        e.clear();
        e.sendKeys(value);
    }

    public void enterEmail(String value) {
        WebElement e = driver.findElement(referralmasterLocator.EMAIL);
        e.clear();
        e.sendKeys(value);
    }

    public void enterContactPerson(String value) {
        WebElement e = driver.findElement(referralmasterLocator.CONTACT_PERSON);
        e.clear();
        e.sendKeys(value);
    }

    //DROPDOWN 
    public void selectReferralType(String value) {
        Select select = new Select(driver.findElement(referralmasterLocator.REFERRAL_TYPE));
        select.selectByVisibleText(value);
    }

    public boolean isReferralTypeSelected() {
        return driver.findElement(referralmasterLocator.REFERRAL_TYPE).isDisplayed();
    }

    //UPDATE BUTTON
    public boolean isUpdateVisible() {
        return driver.findElement(referralmasterLocator.REFERRAL_TYPE).isDisplayed();
    }

//    public void clickUpdate() {
//        WebElement btn = wait.until(
//                ExpectedConditions.elementToBeClickable(referralmasterLocator.UPDATE_BUTTON));
//        btn.click();
//    }

    //POPUP
//    public String getUpdateSuccessMessage() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(
//                referralmasterLocator.updateSuccessMessage)).getText();
//    }

//    public void clickOk() {
//        WebElement okBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(referralmasterLocator.okButton));
//        okBtn.click();
//    }

    //SEARCH
    public void searchReferral(String value) {
        WebElement e = wait.until(
            ExpectedConditions.visibilityOfElementLocated(referralmasterLocator.referralNameSearchInput));
        e.clear();
        e.sendKeys(value);
    }
    
    public int getSearchname() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                referralmasterLocator.referralResults));
        return driver.findElements(referralmasterLocator.referralResults).size();
    }

    //CLEAR
//    public void clickClear() {
//        driver.findElement(referralmasterLocator.CLEAR_BUTTON).click();
//    }

    public boolean isFormCleared() {
        return driver.findElement(referralmasterLocator.REFERRAL_NAME)
                .getAttribute("value").isEmpty();
    }

    //SAVE
//    public boolean isSaveEnabled() {
//        return driver.findElement(referralmasterLocator.SAVE_BUTTON).isEnabled();
//    }

    //Click
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    
    public WebElement getDynamicField(String fieldLabel) {
        By locator;

        switch (fieldLabel.toLowerCase()) {
            case "phone":
                locator = referralmasterLocator.PHONE_NO;
                break;
            case "email":
                locator = referralmasterLocator.EMAIL;
                break;
            case "contact person":
                locator = referralmasterLocator.CONTACT_PERSON;
                break;
            case "referral name":
                locator = referralmasterLocator.REFERRAL_NAME;
                break;
            default:
                throw new RuntimeException("Field locator not defined for: " + fieldLabel);
        }

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}