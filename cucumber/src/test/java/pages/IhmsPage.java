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
        wait.until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState")
                .equals("complete"));

        wait.until(ExpectedConditions.presenceOfElementLocated(IhmsLocator.ihmslogin));
    }

    public void clickIHMSModuleAndSwitchTab() {

        String sessionData = (String) ((JavascriptExecutor) driver)
                .executeScript("return JSON.stringify(sessionStorage);");

        WebElement ihmsCard = wait.until(
                ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", ihmsCard);

        ihmsCard.click();

        try { Thread.sleep(3000); } catch (Exception e) {}

        String current = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(current)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        ((JavascriptExecutor) driver).executeScript(
            "var data = JSON.parse(arguments[0]);" +
            "for (var key in data) { sessionStorage.setItem(key, data[key]); }",
            sessionData
        );

        driver.navigate().refresh();

     
        wait.until(d -> ((JavascriptExecutor)d)
                .executeScript("return document.readyState")
                .equals("complete"));

        try { Thread.sleep(4000); } catch (Exception e) {}
    }

    public boolean isIHMSPageDisplayed() {
        return wait.until(d ->
                ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }
}