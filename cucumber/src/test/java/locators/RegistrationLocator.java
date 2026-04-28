package locators;

import org.openqa.selenium.By;

public class RegistrationLocator {

	public static By opModulesMenu = By.xpath("//span[contains(text(),'OP Modules')]");

	public static By outpatientRegistration = By.xpath("//a[normalize-space()='Outpatient Registration']");
	
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
}
