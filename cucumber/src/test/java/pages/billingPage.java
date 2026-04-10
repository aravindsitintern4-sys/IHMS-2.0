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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    public void hoverBillingMenu() {
        WebElement billing = wait.until(ExpectedConditions.visibilityOfElementLocated(billingLocator.billingMenu));
        actions.moveToElement(billing).perform();
    }

    public void selectBillEntry() {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(billingLocator.billEntryOption));
        
        try {
            option.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }
    }

    public boolean isBillEntryPageLoaded() {
        return wait.until(ExpectedConditions.urlContains("bill-entry"));
    }
}