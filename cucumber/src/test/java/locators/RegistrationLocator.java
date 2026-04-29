package locators;

import org.openqa.selenium.By;

public class RegistrationLocator {

    public static By opModulesMenu = By.xpath("//div[contains(@class, 'group') and contains(., 'OP Modules')]");
    
    public static By outpatientRegistration = By.xpath("//a[contains(text(), 'Outpatient Registration')]");
    	
	public static By getMenuOption(String optionName) {
	    return By.xpath("//a[normalize-space()='" + optionName + "']");
	}
	
	public static By payFreeDropdown = By.xpath("//label[contains(text(),'Pay/Free')]/following-sibling::select");
	
	public static By patientTypeDropdown = By.xpath("//label[contains(text(),'Patient Type')]/following-sibling::select");
	
    public static By firstNameInput = By.xpath("//input[@placeholder='First Name']");
	
	public static By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
	
	public static By ageYearField = By.xpath("//input[@placeholder='Years']");
	
	public static By dobDateField = By.xpath("//input[@type='date']");
	
	public static By getGenderRadio(String code) {
	    return By.xpath("//input[@type='radio' and @value='" + code + "']");
	}
	
	public static By genderConfirmModal = By.xpath("//h2[text()='Gender Confirmation']");

    public static By confirmYesBtn = By.xpath("//h2[text()='Gender Confirmation']/parent::div//button[text()=' Yes ']");
    public static By confirmNoBtn = By.xpath("//h2[text()='Gender Confirmation']/parent::div//button[text()=' No ']");
    
    public static By kinTypeDropdown = By.xpath("//app-dropdown-select[@formcontrolname='nextOfKin']//select");
    
    public static By kinNameField = By.xpath("//app-input-field[@formcontrolname='nextOfKinName']//input");
    
    public static By cancelButton = By.xpath("//button[contains(@class, 'bg-red-500') and contains(text(), 'Cancel')]");
    
    public static By getVisitTypeRadio(String type) {
        return By.xpath("//label[contains(normalize-space(), '" + type + "')]/input[@type='radio']");
    }
    
    public static By referenceNoInput = By.xpath("//input[@placeholder='Reference No']");
    
    public static By crsCheckbox = By.name("crs");
    
    public static By referralNameSelect = By.xpath("//label[contains(text(),'Referral Name')]/following-sibling::select");
    
    public static By districtSelect = By.xpath("//label[contains(text(),'District')]/following-sibling::select");
    
    public static By clinicReferredToSelect = By.xpath("//label[contains(text(),'Clinic Referred to')]/following-sibling::select");

    public static By doctorReferredToSelect = By.xpath("//label[contains(text(),'Doctor Referred to')]/following-sibling::select");

    public static By referralSubmitBtn = By.xpath("//button[contains(text(),'Submit')]");
    public static By referralCancelBtn = By.xpath("//button[contains(text(),'Cancel')]");
}






