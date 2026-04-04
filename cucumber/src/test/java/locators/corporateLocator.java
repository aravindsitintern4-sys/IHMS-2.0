package locators;

import org.openqa.selenium.By;

public class corporateLocator {

	public static By MASTERS = By.xpath("//span[normalize-space()='Corporate Master']");
	
	public static By SITE_DROPDOWN = By.id("siteName");
	
	public static By newCorporateEntryBtn = By.xpath("//button[normalize-space()='New Corporate Entry']");
	
	public static By CORP_NAME = By.xpath("//input[@formcontrolname='description']");
	
	public static By CHARGES_TYPE_DROPDOWN = By.xpath("//select[@formcontrolname='publicCharges']");
	
	public static By CO_PAYMENT_DROPDOWN = By.xpath("//select[@formcontrolname='coPayment']");
	
	public static By CORP_GROUP_DROPDOWN = By.xpath("//select[@formcontrolname='groupCode']");
	
	public static By NEW_PAY_COST = By.xpath("//input[@formcontrolname='newPaymentCostValue']");
	
	public static By OLD_PAY_COST = By.xpath("//input[@formcontrolname='oldPaymentCostValue']");
	
	//Form
	public static By form = By.xpath("//h2[text()='Corporate Master']");
	
	//Address Contact
	public static By ADDRESS_1 = By.xpath("//input[@formcontrolname='address1']");
	
	public static By PHONE = By.xpath("//input[@formcontrolname='phoneNumber']");
	
	public static By ADDRESS_2 = By.xpath("//input[@formcontrolname='address2']");
	
	public static By EMAIL = By.xpath("//input[@formcontrolname='emailId']");
	
	public static By ADDRESS_3 = By.xpath("//input[@formcontrolname='address3']");
	
	public static By CONTACT_PERSON = By.xpath("//input[@formcontrolname='contactPerson']");
	
	public static By DISTRICT = By.xpath("//select[@formcontrolname='districtMasterId']");
	
	public static By FAX = By.xpath("//input[@formcontrolname='fax']");
	
	public static By ABI = By.xpath("//input[@formcontrolname='abi']");
	
	//Employee Grade
	public static By EMPLOYEE_GRADE = By.xpath("//select[@formcontrolname='employeeGrade']");

	public static By EMPLOYEE_GRADE_AMOUNT = By.xpath("//input[@formcontrolname='employeeGradeAmount']");

	public static By ADD_BUTTON = By.xpath("//td//button[@title='Add']");
	
    //Active
	public static By ACTIVE = By.xpath("//select[@formcontrolname='active']");
	
	//save button
//	public static By SAVE_BUTTON = By.xpath("//button[@type='submit' and normalize-space()='Save']");
	
	//Cancel Button
//	public static By CLEAR_BUTTON = By.xpath("//button[@type='button' and normalize-space()='Clear']");
	
	//PopUp Message
//	public static By ERROR_MESSAGE = By.xpath("//p[contains(text(),'Please fill district field')]");
//	public static By OK_BUTTON = By.xpath("//button[normalize-space()='OK']"); 
	
	//Update 
//	public static By UPDATE_BUTTON = By.xpath("//button[contains(text(),'Update')]");
	
	//Search
	public static By searchInput = By.xpath("//input[@formcontrolname='search']");
  	
	public static final By TABLE_ROWS = By.xpath("//tbody//tr");
  	
  	//Edit
	public static By editIconByName(String name) {
	    return By.xpath("//tr[td[normalize-space()='" + name + "']]//i[contains(@class,'fa-edit')]");
	}
  	
	public static By popupMessage(String msg) {
	    return By.xpath("//p[normalize-space()='" + msg + "']");
	}
}
