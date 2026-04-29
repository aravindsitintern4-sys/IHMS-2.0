package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Set;
import locators.IhmsLocator;

public class IhmsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public IhmsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickIHMSModule() {
        String originalWindow = driver.getWindowHandle();

        WebElement card = wait.until(
            ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin)
        );
        card.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        wait.until(d -> !d.getCurrentUrl().equals("about:blank"));

        loadIHMSContentWithRetry();
    }

    private void loadIHMSContentWithRetry() {
        try {
            switchToIframeAndValidate();
        } catch (Exception e) {
            System.out.println("IHMS content not loaded. Refreshing...");
            driver.navigate().refresh();
            switchToIframeAndValidate();
        }
    }

    public void switchToIframeAndValidate() {
        driver.switchTo().defaultContent();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
        
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src,'ihms')]")));
    }

    public void waitForDashboardToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmsMenu));
    }

    public boolean isIHMSPageDisplayed() {
        try {
            WebElement menu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmsMenu)
            );
            return menu.isDisplayed();
        } catch (Exception e) {
            System.out.println("IHMS Menu not visible.");
            return false;
        }
    }
}