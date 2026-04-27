package locators;

import org.openqa.selenium.By;

public class IhmsLocator {

	    public static By ihmslogin = By.xpath("//div[normalize-space()='IHMS']");
	    
	    public static By ihmsIframe = By.xpath("//iframe[contains(@src,'ihms')]");
	    
	    public static By ihmsMenu = By.xpath("//span[contains(text(),'Dashboard')]"); 
	    
	    public static By ihmsHeader = By.xpath("//h1[text()='IHMS']");
}