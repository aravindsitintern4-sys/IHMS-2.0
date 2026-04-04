package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import locators.corporateLocator;

public class corporatemasterPage {

    WebDriver driver;
    WebDriverWait wait;

    public corporatemasterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //SEARCH 
    public void searchCorporate(String name) {
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(corporateLocator.searchInput));

        searchBox.clear();
        searchBox.sendKeys(name);
    }

    public boolean isSearchResultDisplayed() {
        List<WebElement> rows = driver.findElements(corporateLocator.TABLE_ROWS);
        return rows.size() > 0;
    }

    public boolean isNoResultDisplayed() {
        List<WebElement> rows = driver.findElements(corporateLocator.TABLE_ROWS);
        return rows.size() == 0;
    }

    //SAVE
//    public void clickSaveButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(
//                corporateLocator.SAVE_BUTTON)).click();
//    }

    //EDIT
    public void clickEditIconByName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                corporateLocator.TABLE_ROWS));

        driver.findElement(corporateLocator.editIconByName(name)).click();
    }

    public boolean isCorporateDataLoaded() {
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(
                corporateLocator.CORP_NAME)).getAttribute("value");

        return !value.isEmpty();
    }

    //UPDATE
//    public void clickUpdateButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(
//                corporateLocator.UPDATE_BUTTON)).click();
//    }

//    POPUP   
    public boolean isPopupMessageDisplayed(String msg) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    corporateLocator.popupMessage(msg))).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

//    public void clickOkButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(
//                corporateLocator.OK_BUTTON)).click();
//    }
    
    //Corporate Name
    public void enterCorporateName(String name) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(corporateLocator.CORP_NAME));
        el.clear();
        el.sendKeys(name);
    }
    
    //Email
    public void enterEmail(String val) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(corporateLocator.EMAIL));
        el.clear();
        el.sendKeys(val);
    }
    
    //Duplicate
    public boolean isCorporateExists(String name) {
        searchCorporate(name);
        return driver.findElements(corporateLocator.editIconByName(name)).size() > 0;
    }
    
    //Select Charge Type
    public String getSelectedChargeType() {
        Select select = new Select(
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                corporateLocator.CHARGES_TYPE_DROPDOWN))
        );
        return select.getFirstSelectedOption().getText();
    }

    //CLEAR
//    public void clickClearButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(
//                corporateLocator.CLEAR_BUTTON)).click();
//    }

    public boolean isFormCleared() {

        List<WebElement> inputs = driver.findElements(
            By.xpath("//input | //textarea"));

        for (WebElement input : inputs) {
            String value = input.getAttribute("value");

            if (value != null && !value.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}