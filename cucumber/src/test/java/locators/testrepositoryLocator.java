package locators;

import org.openqa.selenium.By;

public class testrepositoryLocator {

	// Navigation
    public static By TEST_REPOSITORY = By.xpath("//button[.//span[normalize-space()='Test Repository Master']]");
    
    // SiteType DropDown 
    public static By sitetypeDropdown = By.cssSelector("select[formcontrolname='Sitetype']");
    
    // AcountHead DropDown 
    public static By accountheadDropdown = By.cssSelector("select[formcontrolname='AccountHead']");
    
    // Clinic DropDown 
    public static By clinicDropdown = By.cssSelector("select[formcontrolname='Clinic']");
    
    // PaymentType DropDown 
    public static By paymenttypeDropdown = By.cssSelector("select[formcontrolname='PaymentType']");
    
    //Corporate Site&Corporate DropDown
    public static By siteDropdown = By.cssSelector("select[formcontrolname='CorpSiteId']");
    public static By corporateDropdown = By.cssSelector("select[formcontrolname='Corporate']");
    
    //TestName 
    public static By testnameInput = By.xpath("//input[@formcontrolname='Testname']");
    
    // Pay/Free DropDown 
    public static By patientclassDropdown = By.cssSelector("select[formcontrolname='PatientClassCode']");
    
    //Test Cost
    public static By testcostInput = By.xpath("//input[@formcontrolname='Testcost']");
    
    // Injection DropDown 
    public static By injectionDropdown = By.cssSelector("select[formcontrolname='Injection']");
    
    //Save
  	 public static By saveButton = By.xpath("//button[normalize-space()='Save']");

    //clear
  	 public static By clearButton = By.xpath("//button[normalize-space()='Clear']");
  	
  	//PopUp Message
//  	public static By popup = By.xpath("//div[contains(@class,'shadow-sm')]");
//  	public static By popupMessage = By.xpath("//div[contains(@class,'shadow-sm')]//p");
  	 
  	public static By popupMessage = By.xpath("//div[contains(@class,'rounded-lg')]//p");
  	public static By okButton = By.xpath("//button[normalize-space()='OK']");
  	
  	//Search
  	public static By searchInput = By.cssSelector("input[formcontrolname='testnamesearch']");
  	
  	public static By tableRows = By.xpath("//tbody/tr");
  	
  	//update popup
  	public static By updateButton = By.xpath("//button[normalize-space()='Update']");
  	public static By updateMessage = By.xpath("//p[contains(text(),'updated successfully')]");
  	
  	//Delete Popup
  	public static By deleteButton = By.xpath("//button[normalize-space()='Delete']");
  	public static By deleteMessage = By.xpath("//p[contains(text(),'deleted successfully')]");
  	
  	//Cancel Button
  	public static By cancelbutton = By.xpath("//button[normalize-space()='Cancel']");
  	
  	//Row Select
  	public static By testrepoName(String testName) {
        return By.xpath("//tbody//tr[td[normalize-space()='" + testName + "']]");
    }
}
