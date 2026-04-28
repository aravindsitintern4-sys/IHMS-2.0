package locators;

import org.openqa.selenium.By;

public class billentryLocator {

	public static By uinInput = By.xpath("(//input[@formcontrolname='patientUin'])");
	
	public static By paymentTypeDropdown = By.xpath("//app-dropdown[@formcontrolname='patientMode']//select");
	public static By payFreeContainer = By.xpath("//app-dropdown[@formcontrolname='patientMode']");
	
//	public static By optionPay = By.xpath("//option[text()='PAY']");
//    public static By optionFree = By.xpath("//option[text()='FREE']");
    
    public static By patientTypeDropdown = By.cssSelector("select.wid-70-cus");

//    public static By optionInPatient = By.xpath("//option[@value='IP']");
//    public static By optionOutPatient = By.xpath("//option[@value='OP']");
//    public static By optionStaff = By.xpath("//option[@value='S']");
    
    public static By adviseByDropdown = By.id("advisedBy");
    
    public static By TestNameDropdown = By.xpath("//select[option[@hidden][contains(text(),'Select')]]");
    
    public static By locationDropdown = By.xpath("//select[option[@hidden][contains(text(),'Select')]]");
    
    public static By paymentCategorySelect = By.xpath("//app-dropdown[@id='paymentCategoryCode']//select");
    
    public static By paymentCategory = By.xpath("//select[@id='paymentCategoryCode']");
    
    public static By paymentType = By.xpath("//select[@id='paymodeCode']");
    
    public static By paymentSubCategory = By.xpath("//select[@id='paymentSubCategory']");
    
    public static By saveButton = By.xpath("//button[contains(text(),'Save')]");

    public static By cancelButton = By.xpath("//button[contains(text(),'Cancel')]");

    public static By reprintButton = By.xpath("//button[contains(text(),'Reprint')]");
    
    public static By investigationAmount = By.cssSelector("input[formcontrolname='investigationAmount']");
    
    public static By paymentFeesInput = By.id("paymentFees");
    
    public static By patientNameDisplay = By.cssSelector("input[placeholder='Name']");
    
    public static By collectionDisplay = By.xpath("//label[contains(text(),'Collection')]/following-sibling::input");

    public static By cashierDisplay = By.cssSelector("input[formcontrolname='operatorCode']");

    public static By balanceDisplay = By.xpath("//label[contains(text(),'Balance')]/following-sibling::span");

}
