package pages;

import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import locators.billentryLocator;

public class billentryPage {

    WebDriver driver;
    WebDriverWait wait;

    public billentryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void openBillingPage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(billentryLocator.uinInput));
        System.out.println("Billing page ready");
    }

    public void enterUinAndSubmit(String uinNumber) {

        WebElement uinField = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.uinInput)
        );

        uinField.click();
        uinField.clear();

        uinField.sendKeys(uinNumber);
        uinField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'loader')]") 
        ));
    }
    
    public String getPatientName() {
        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(billentryLocator.patientNameDisplay)
        );
        return nameField.getAttribute("value").trim();
    }

    public void clickPayFreeDropdown() {

        driver.findElement(billentryLocator.paymentTypeDropdown).click();
    }


    public void selectPayFree(String paymentMode) {

        driver.findElement(
            By.xpath("//option[contains(text(),'" + paymentMode + "')]")
        ).click();
    }


    public void clickAdvisedByDropdown() {

        driver.findElement(billentryLocator.adviseByDropdown).click();
    }


    public void selectAdvisedBy(String doctorName) {

        driver.findElement(
            By.xpath("//option[contains(text(),'" + doctorName + "')]")
        ).click();
    }


    public String getSelectedPayFree() {

        return driver.findElement(
            billentryLocator.paymentTypeDropdown
        ).getAttribute("value").trim();
    }


    public String getSelectedAdvisedBy() {

        return driver.findElement(
            billentryLocator.adviseByDropdown
        ).getAttribute("value").trim();
    }
}