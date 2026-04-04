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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    // Wait for dashboard
    public void waitForDashboardToLoad() {
        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));

        wait.until(ExpectedConditions.presenceOfElementLocated(IhmsLocator.ihmslogin));
    }

    public void clickIHMSModule() {

        WebElement ihmsCard = wait.until(
            ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin)
        );

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", ihmsCard);

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", ihmsCard);

        try { Thread.sleep(3000); } catch (Exception e) {}

//        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[contains(text(),'Dashboard')]")
        ));

        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    public boolean isIHMSPageDisplayed() {
        return wait.until(d ->
                ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }
}