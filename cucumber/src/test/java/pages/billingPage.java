package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import locators.billingLocator;

public class billingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public billingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openBillingMenu() {

        WebElement billing = wait.until(
                ExpectedConditions.elementToBeClickable(billingLocator.billingMenu)
        );

        try {
            billing.click(); 
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", billing);
        }
    }

    public void clickBillEntry() {

        WebElement billEntry = wait.until(
                ExpectedConditions.elementToBeClickable(billingLocator.billEntryOption)
        );

        try {
            billEntry.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", billEntry);
        }
    }

    public boolean isBillEntryPageLoaded() {
        try {
            return wait.until(ExpectedConditions.urlContains("bill-entry"));
        } catch (Exception e) {
            System.out.println("Bill Entry page not loaded: " + e.getMessage());
            return false;
        }
    }
}