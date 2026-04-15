package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Set;
import locators.IhmsLocator;

public class IhmsPage {

    WebDriver driver;
    WebDriverWait wait;

    public IhmsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForDashboardToLoad() {
        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmslogin));
    }

    public void clickIHMSModule() {

        WebElement ihmsCard = wait.until(
                ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", ihmsCard);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].setAttribute('target','_self');", ihmsCard);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", ihmsCard);

        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    public boolean isIHMSPageDisplayed() {
        try {
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(60));

            return longWait.until(d -> {
                JavascriptExecutor js = (JavascriptExecutor) d;

                String state = (String) js.executeScript("return document.readyState");

                Long textLength = (Long) js.executeScript(
                        "return document.body.innerText.trim().length");

                return state.equals("complete") && textLength > 50;
            });

        } catch (Exception e) {
            System.out.println("IHMS page not loaded properly: " + e.getMessage());
            return false;
        }
    }
}