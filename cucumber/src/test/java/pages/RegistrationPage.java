package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import locators.RegistrationLocator;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public void selectOutpatientRegistration(String optionName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(RegistrationLocator.genderConfirmModal));

        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.opModulesMenu));
        
        menu.click(); 

        WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(
            RegistrationLocator.getMenuOption(optionName)));

        try {
            wait.until(ExpectedConditions.visibilityOf(option));
            option.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
        }
    }

    public boolean isOPRegistrationPageLoaded() {
        return wait.until(ExpectedConditions.urlContains("registration"));
    }
    
    public void selectPaymentType(String type) {
        WebElement dropdownElement = wait.until(
            ExpectedConditions.elementToBeClickable(RegistrationLocator.payFreeDropdown));
        
        dropdownElement.click(); 
        
        Select paySelect = new Select(dropdownElement);
        
        if (type.equalsIgnoreCase("PAY")) {
            paySelect.selectByValue("SITE01");
        } else {
            paySelect.selectByValue("SITE02");
        }
    }
    
    public void selectPatientType(String type) {
        WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(RegistrationLocator.patientTypeDropdown));
        
        dropdown.click();

        Select select = new Select(dropdown);
        if (type.equalsIgnoreCase("DIRECT")) {
            select.selectByValue("PTY001");
        } else if (type.equalsIgnoreCase("SCHEDULING")) {
            select.selectByValue("PTY010");
        }
    }
    
    public void enterPatientNames(String fName, String lName) {
        WebElement fNameInput = wait.until(
            ExpectedConditions.elementToBeClickable(RegistrationLocator.firstNameInput));
        
        fNameInput.clear();
        fNameInput.sendKeys(fName);
        
        WebElement lNameInput = driver.findElement(RegistrationLocator.lastNameInput);
        lNameInput.clear();
        lNameInput.sendKeys(lName);
    }
    
    public void enterAgeAndClickDob(String ageValue) {
        WebElement ageField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(RegistrationLocator.ageYearField)
        );
        ageField.clear();
        ageField.sendKeys(ageValue);

        WebElement dobField = wait.until(
            ExpectedConditions.elementToBeClickable(RegistrationLocator.dobDateField));
        dobField.click();
        
        System.out.println("Entered age: " + ageValue + " and clicked DOB field.");
    }
    
    public void selectGender(String gender) {
        String code = "";
        if (gender.equalsIgnoreCase("Male")) code = "M";
        else if (gender.equalsIgnoreCase("Female")) code = "F";
        else if (gender.equalsIgnoreCase("Transgender")) code = "T";

        WebElement radio = wait.until(
            ExpectedConditions.presenceOfElementLocated(RegistrationLocator.getGenderRadio(code))
        );

        try {
            radio.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
        }
        
        System.out.println("Forced selection for gender: " + gender);
    }
    
    public void handleGenderConfirmation(String action) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationLocator.genderConfirmModal));
    	
        if (action.equalsIgnoreCase("Yes")) {
            driver.findElement(RegistrationLocator.confirmYesBtn).click();
        } else {
            driver.findElement(RegistrationLocator.confirmNoBtn).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(RegistrationLocator.genderConfirmModal));
    }
}