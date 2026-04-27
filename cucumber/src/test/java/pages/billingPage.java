package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import locators.billingLocator;

public class billingPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public billingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Hover on Billing Menu
    public void hoverBillingMenu() {
        WebElement billing = wait.until(
                ExpectedConditions.visibilityOfElementLocated(billingLocator.billingMenu)
        );
        actions.moveToElement(billing).perform();
    }

    // Click Bill Entry
    public void selectBillEntry() {

        WebElement billEntry = wait.until(
                ExpectedConditions.elementToBeClickable(billingLocator.billEntryOption)
        );

        billEntry.click();
    }

    // Verify Bill Entry Page Loaded
    public boolean isBillEntryPageLoaded() {
        try {
            return wait.until(ExpectedConditions.urlContains("bill-entry"));
        } catch (Exception e) {
            System.out.println("Bill Entry page not loaded: " + e.getMessage());
            return false;
        }
    }
}