package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import locators.insurancesmasterLocators;

public class insurancesmasterPage {

    WebDriver driver;
    WebDriverWait wait;
    
    public insurancesmasterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //NAVIGATION 
    public void clickinsurancemaster() {
        driver.findElement(insurancesmasterLocators.INSURANCE_MASTER).click();
    }

    //INPUT
    public void enterInsuranceName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(insurancesmasterLocators.insuranceNameInput));
        el.clear();
        el.sendKeys(name);
    }
    public void enterShortName(String shortName) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(insurancesmasterLocators.insShortNameInput));
        el.clear();
        el.sendKeys(shortName);
    }

    //BUTTON ACTIONS 
//    public void clickSave() {
//        wait.until(ExpectedConditions.elementToBeClickable(insurancesmasterLocators.saveButton)).click();
//    }
//    public void clickClear() {
//        wait.until(ExpectedConditions.elementToBeClickable(insurancesmasterLocators.clearButton)).click();
//    }
//    public boolean isSaveEnabled() {
//        return driver.findElement(insurancesmasterLocators.saveButton).isEnabled();
//    }

    //CLEAR VALIDATION 
    public boolean areFieldsCleared() {
        String name = driver.findElement(insurancesmasterLocators.insuranceNameInput).getAttribute("value");
        String shortName = driver.findElement(insurancesmasterLocators.insShortNameInput).getAttribute("value");
        return name.isEmpty() && shortName.isEmpty();
    }

    //SAVE SUCCESS
    public boolean isSaveSuccessful() {
        try {
            By successMsg = By.xpath("//div[contains(text(),'success')]");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //LENGTH VALIDATION 
    public boolean isInsuranceNameLengthValid() {
        String value = driver.findElement(insurancesmasterLocators.insuranceNameInput).getAttribute("value");
        return value.length() <= 100;
    }
    public boolean isShortNameLengthValid() {
        String value = driver.findElement(insurancesmasterLocators.insShortNameInput).getAttribute("value");
        return value.length() <= 15;
    }

    //EMPTY FIELD HANDLING 
    public void leaveFieldEmpty(String field) {
        switch (field.toLowerCase()) {
            case "insurance name":
                enterInsuranceName("");
                break;
            case "short name":
                enterShortName("");
                break;
            default:
                System.out.println("Invalid field: " + field);
        }
    }

    //SEARCH 
    public void searchInsurance(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(insurancesmasterLocators.insuranceSearchInput));
        el.clear();
        el.sendKeys(name);
    }
    public boolean isSearchResultDisplayed() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(insurancesmasterLocators.insuranceSearchResults, 0));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isNoResultDisplayed() {
        List<WebElement> list = driver.findElements(insurancesmasterLocators.insuranceSearchResults);

        return list.isEmpty();
    }
    //update
    public void updateField(String field, String value) {

        WebElement input = getDynamicField(field);

        input.clear();
        input.sendKeys(value);
    }
    
    public WebElement getDynamicField(String fieldLabel) {

        By locator;
        switch (fieldLabel.toLowerCase().trim()) {

            case "ins short name":
                locator = insurancesmasterLocators.insShortNameInput;
                break;
            case "insurance name":
                locator = insurancesmasterLocators.insuranceNameInput;
                break;
            default:
                throw new RuntimeException("Invalid field: " + fieldLabel);
        }

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
//    public String getPopupMessage() {
//
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(
//                insurancesmasterLocators.popupMessage))
//            .getText();
//    }
    
//    public void clickOkButton() {
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                insurancesmasterLocators.okButton)).click();
//    }

}