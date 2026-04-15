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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openBillingPage() {
        driver.get("https://eyenotes20-ihms-qa.aravind.org:30434/dashboard/billing");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(billentryLocator.uinInput));
    }

    public void enterUinAndSubmit(String uinNumber) {
        WebElement uinField = wait.until(ExpectedConditions.visibilityOfElementLocated(billentryLocator.uinInput));

        uinField.click();
        uinField.clear();

        uinField.sendKeys(uinNumber + Keys.ENTER);
        
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

//    public void clickBillEntry() {
//        // Some systems require clicking a "Bill Entry" link/tab first
//        WebElement entryLink = wait.until(ExpectedConditions.elementToBeClickable(billentryLocator.billEntryMenu));
//        
//        // Use JS click to avoid 'ElementClickInterceptedException' if a loader is still fading out
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", entryLink);
//    }
    
    public String getPatientName() {
        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(billentryLocator.patientNameDisplay)
        );
        return nameField.getAttribute("value").trim();
    }

    public void selectPayFree(String mode) {
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.paymentTypeDropdown)
        );

        new Select(dropdown).selectByVisibleText(mode.trim());
    }

    public void selectAdvisedBy(String doctorName) {
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.AdviseByDropdown)
        );

        Select select = new Select(dropdown);

        for (WebElement option : select.getOptions()) {
            if (option.getText().trim().equalsIgnoreCase(doctorName.trim())) {
                option.click();
                break;
            }
        }
    }
    
    public String getSelectedOption(By locator) {
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        return new Select(dropdown)
                .getFirstSelectedOption()
                .getText()
                .trim();
    }

    public void clickCancel() {
        WebElement cancelBtn = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.cancelButton)
        );
        cancelBtn.click();
    }
}