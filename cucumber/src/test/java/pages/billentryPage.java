package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import locators.billentryLocator;

public class billentryPage {

    WebDriver driver;
    WebDriverWait wait;

    public billentryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void openBillingPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(billentryLocator.uinInput));
        System.out.println("Billing page ready");
    }
    public void enterUinAndSubmit(String uinNumber) {

        WebElement uinField = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.uinInput)
        );

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

    public void clickPayFree() {

        WebElement container = driver.findElement(
                billentryLocator.payFreeContainer
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", container);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", container);
    }

    public void selectPayFree(String value) {

        WebElement dropdown = driver.findElement(
                billentryLocator.paymentTypeDropdown
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "let select = arguments[0];" +
            "for (let i = 0; i < select.options.length; i++) {" +
            "  if (select.options[i].text.trim() === arguments[1]) {" +
            "    select.selectedIndex = i;" +
            "    select.dispatchEvent(new Event('change'));" +
            "    break;" +
            "  }" +
            "}",
            dropdown,
            value
        );
    }


    public void clickAdvisedBy() {

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(billentryLocator.adviseByDropdown));

        dropdown.click();
    }

    public void selectAdvisedBy(String value) {

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(billentryLocator.adviseByDropdown));

        try {
            Select select = new Select(dropdown);
            select.selectByVisibleText(value);

        } catch (Exception e) {
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='" + value + "']")));
            option.click();
        }
    }
    
    public void selectTestNameAndEnter(String value) {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.TestNameDropdown));

        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

        dropdown.sendKeys(Keys.ENTER);
    }
    
    public void selectPaymentCategory(String value) {

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.paymentCategory));

        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    } 
    
    public void clickFeesField() {

        WebElement fees = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.paymentFeesInput));

        fees.click();
    }
    
    public void pressEnterInFees() {

        WebElement fees = wait.until(
                ExpectedConditions.visibilityOfElementLocated(billentryLocator.paymentFeesInput));

        fees.sendKeys(Keys.ENTER);
    }
    
    public void clickSaveButton() {

        WebElement saveBtn = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.saveButton));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", saveBtn);

        saveBtn.click();
    }
    
    public void clickCancelButton() {

        WebElement cancelBtn = wait.until(
                ExpectedConditions.elementToBeClickable(billentryLocator.cancelButton));

        cancelBtn.click();
    }

	public void clickTestNameDropdown() {
		WebElement dropdown = wait.until(
	            ExpectedConditions.elementToBeClickable(billentryLocator.TestNameDropdown));

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView(true);", dropdown);

	    dropdown.click();
		
	}
}