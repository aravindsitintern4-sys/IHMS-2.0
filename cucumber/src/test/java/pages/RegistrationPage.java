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

    public void navigateToOutpatientRegistration(String optionName) {
        Actions actions = new Actions(driver);
        
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(
            RegistrationLocator.opModulesMenu));
        
        actions.moveToElement(menu).perform();
        
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
            RegistrationLocator.outpatientRegistration));
        
        option.click();
    }
    
    public boolean isOPRegistrationPageLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(RegistrationLocator.firstNameInput)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
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
    
    public void enterKinDetails(String relation, String name) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
            RegistrationLocator.kinTypeDropdown));
        
        Select select = new Select(dropdown);
        select.selectByVisibleText(relation.trim());

        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(
            RegistrationLocator.kinNameField));
        
        nameInput.clear();
        nameInput.sendKeys(name);
    }
    
    public void clickCancel() {
        WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.cancelButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelBtn);       
    }
    
    public void selectVisitType(String visitType) {
        WebElement radioBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
            RegistrationLocator.getVisitTypeRadio(visitType)));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioBtn);
    }
    
    public void enterReferenceNumber(String refNo) {
        WebElement refField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            RegistrationLocator.referenceNoInput));
        
        refField.clear();
        refField.sendKeys(refNo);
    }
    
    public void setCRSCheckbox(boolean shouldBeChecked) {
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(
            RegistrationLocator.crsCheckbox));
        
        if (checkbox.isSelected() != shouldBeChecked) {
            try {
                checkbox.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            }
        }
    }
    
    public void selectReferralName(String hospitalName) {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.referralNameSelect));
        Select referralSelect = new Select(dropdownElement);
        
        try {
            referralSelect.selectByVisibleText(hospitalName);
        } catch (Exception e) {
            System.out.println("Could not find hospital: " + hospitalName);
            referralSelect.selectByIndex(1);
        }
    }
    
    public void selectDistrict(String districtName) {
        WebElement districtDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(RegistrationLocator.districtSelect));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", districtDropdown);
        wait.until(d -> districtDropdown.isEnabled());

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", districtDropdown);
        Select select = new Select(districtDropdown);
        select.selectByVisibleText(" " + districtName.toUpperCase().trim() + " ");
    }
    
    public void selectClinicReferredTo(String clinicName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.clinicReferredToSelect));
        
        Select select = new Select(dropdown);
        
        try {
            select.selectByVisibleText(" " + clinicName.toUpperCase().trim() + " ");
        } catch (Exception e) {
            System.out.println("Clinic not found exactly. Trying partial match for: " + clinicName);
            select.selectByContainsVisibleText(clinicName.trim());
        }
    }
    
    public void fillReferralForm(String refNo, String district, String refName, String clinic, String doctor) {
      
        WebElement refInput = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.referenceNoInput));
        refInput.sendKeys(refNo, Keys.TAB);

        WebElement crs = driver.findElement(By.xpath("//input[@type='checkbox']"));
        crs.click();
        crs.sendKeys(Keys.TAB); 

        selectDropdownWorkaround(RegistrationLocator.districtSelect, district);
        selectDropdownWorkaround(RegistrationLocator.referralNameSelect, refName);
        selectDropdownWorkaround(RegistrationLocator.clinicReferredToSelect, clinic);
        selectDropdownWorkaround(RegistrationLocator.doctorReferredToSelect, doctor);
    }

    private void selectDropdownWorkaround(By locator, String value) {
      
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(d -> dropdown.isEnabled());

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);

        Select select = new Select(dropdown);
        select.selectByVisibleText(" " + value.trim().toUpperCase() + " ");
    }
    
    public void selectDoctorReferredTo(String doctorName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.doctorReferredToSelect));
        
        Select select = new Select(dropdown);
        try {
            select.selectByVisibleText(" " + doctorName + " ");
        } catch (Exception e) {
            select.selectByVisibleText(doctorName);
        }
    }
    
    public void clickReferralSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(RegistrationLocator.referralSubmitBtn));
        submitBtn.click();
    }

    public void clickReferralCancel() {
        driver.findElement(RegistrationLocator.referralCancelBtn).click();
    }
}

















