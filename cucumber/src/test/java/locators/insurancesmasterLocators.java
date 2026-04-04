package locators;

import org.openqa.selenium.By;

public class insurancesmasterLocators {
	
	public static By INSURANCE_MASTER = By.xpath("//button[.//span[normalize-space()='Insurance Master']]");
	
	//InsuranceName
	public static By insuranceNameInput = By.xpath("//input[@formcontrolname='Description']");
	
	//ShortName
	public static By insShortNameInput = By.xpath("//input[@formcontrolname='ShortName']");
	
	// Save button
//    public static By saveButton = By.xpath("//button[normalize-space()='Save']");

    // Clear button
//    public static By clearButton = By.xpath("//button[normalize-space()='Clear']");
    
    //Search
    public static By insuranceSearchInput = By.xpath("//input[@formcontrolname='insurance_Description_search']");

    // Update actual result
    public static By insuranceSearchResults = By.xpath("//tbody//tr");
    
    public static By popupMessage = By.xpath("//p[contains(text(),'Already Exist')]");
//    public static By okButton = By.xpath("//button[text()='OK']");
    
    public static By insurancesRowByName(String insName) {
        return By.xpath("//tbody//tr[td[normalize-space()='" + insName + "']]");
    }
    
//    public static By UPDATE_BUTTON = By.xpath("//button[normalize-space()='Update']");
}
