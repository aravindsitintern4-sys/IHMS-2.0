package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.reuseableCodeLocator;

import java.time.Duration;

public class reuseableCodePage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public reuseableCodePage(WebDriver driver) {
        this.driver = driver;
    }
    
  //SAVE
    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
        		reuseableCodeLocator.SAVE_BUTTON)).click();
    }
    public boolean isSaveEnabled() {
        return driver.findElement(reuseableCodeLocator.SAVE_BUTTON).isEnabled();
    }

  //UPDATE
    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
        		reuseableCodeLocator.UPDATE_BUTTON)).click();
    }
    
  //Ok Button
    public void clickOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
        		reuseableCodeLocator.okButton)).click();
    }

  //CLEAR
    public void clickClearButton() {
        wait.until(ExpectedConditions.elementToBeClickable(
        		reuseableCodeLocator.CLEAR_BUTTON)).click();
    }
    
   
    
}
