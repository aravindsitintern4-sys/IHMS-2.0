package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import locators.IhmsLocator;

public class IhmsPage {

    WebDriver driver;
    IhmsLocator loc = new IhmsLocator();

    public IhmsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIhms() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin)).click();
    }

    public boolean isIHMSPageDisplayed() {
        return driver.getTitle().contains("IHMS");   
    }
    
    public void switchToIHMSFrame() {
        driver.switchTo().frame(0); 
    }
}