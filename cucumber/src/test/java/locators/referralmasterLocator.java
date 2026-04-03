package locators;

import org.openqa.selenium.By;

public class referralmasterLocator {

	    public static By REFERRAL_MASTER = By.xpath("//button[.//span[normalize-space()='Referral Master']]");
	
	    public static By REFERRAL_CODE = By.xpath("//input[@formcontrolname='Code']");

	    public static By REFERRAL_NAME = By.xpath("//input[@formcontrolname='Description']");

	    public static By ADDRESS1 = By.xpath("//input[@formcontrolname='Address1']");

	    public static By ADDRESS2 = By.xpath("//input[@formcontrolname='Address2']");

	    public static By ADDRESS3 = By.xpath("//input[@formcontrolname='Address3']");

	    public static By PHONE_NO = By.xpath("//input[@formcontrolname='PhoneNo']");

	    public static By FAX = By.xpath("//input[@formcontrolname='Fax']");

	    public static By EMAIL = By.xpath("//input[@formcontrolname='Email']");

	    public static By CONTACT_PERSON = By.xpath("//input[@formcontrolname='ContactPerson']");

	    public static By REFERRAL_TYPE = By.xpath("//select[@formcontrolname='Type']");

	    public static By SAVE_BUTTON = By.xpath("//button[normalize-space()='Save']");

	    public static By CLEAR_BUTTON =By.xpath("//button[normalize-space()='Clear']");
	    
	    public static By referralNameSearchInput = By.xpath("//input[@formcontrolname='referralnamesearch']");
	    
	    public static By referralResults = By.xpath("//tbody//tr"); 
	    
	    public static By UPDATE_BUTTON = By.xpath("//button[normalize-space()='Update']");
	    
	 // Success popup message
	    public static By updateSuccessMessage = By.xpath("//*[contains(text(),'Record Updated Successfully')]");
	    
	 // OK button
	    public static By okButton = By.xpath("//button[normalize-space()='OK']");

	    public static By referralRowByName(String refName) {
	        return By.xpath("//tbody//tr[td[normalize-space()='" + refName + "']]");
	    }
}





