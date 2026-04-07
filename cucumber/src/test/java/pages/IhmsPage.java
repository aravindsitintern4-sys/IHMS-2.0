package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import locators.IhmsLocator;

public class IhmsPage {

    WebDriver driver;
    WebDriverWait wait;

    public IhmsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForDashboardToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmslogin));
    }

    public void clickIHMSModule() {

        WebElement ihmsCard = wait.until(
            ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin)
        );

        ihmsCard.click();

        wait.until(ExpectedConditions.urlContains("dashboard"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(text(),'Dashboard')]")
        ));
    }

    public boolean isIHMSPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(text(),'Dashboard')]")
            )).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}