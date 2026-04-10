package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    public void enterUINAndSubmit(String uin) {

        WebElement uinField = wait.until(driver -> {
            WebElement el = driver.findElement(billentryLocator.uinInput);
            return (el.isDisplayed() && el.isEnabled()) ? el : null;
        });

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", uinField);

        wait.until(ExpectedConditions.elementToBeClickable(uinField));

        Actions actions = new Actions(driver);
        actions.moveToElement(uinField).click().perform();

        uinField.sendKeys(Keys.CONTROL, "a");
        uinField.sendKeys(Keys.DELETE);

        uinField.sendKeys(uin);

        String val = uinField.getAttribute("value");

        if (val == null || !val.equals(uin)) {

            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value='" + uin + "';" +
                "arguments[0].dispatchEvent(new Event('input', {bubbles:true}));",
                uinField
            );
        }

        uinField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                billentryLocator.patientNameDisplay
        ));
    }
    
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