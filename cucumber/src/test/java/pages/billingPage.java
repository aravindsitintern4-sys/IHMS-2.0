package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import locators.billingLocator;

public class billingPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public billingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void hoverOnBilling() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement billing = wait.until(
            ExpectedConditions.visibilityOfElementLocated(billingLocator.BILLING_MENU)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(billing).perform(); 
    }

    public void clickBillEntry() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement billEntry = wait.until(
            ExpectedConditions.elementToBeClickable(billingLocator.BILL_ENTRY)
        );

        billEntry.click();
    }

    public void verifyBillEntryPage() {
        wait.until(ExpectedConditions.urlContains("bill-entry")); 
        System.out.println("Navigated to Bill Entry Page");
    }
}