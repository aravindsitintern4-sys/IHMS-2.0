package locators;

import org.openqa.selenium.By;

public class reuseableCodeLocator {

	//save button
		public static By SAVE_BUTTON = By.xpath("//button[@type='submit' and normalize-space()='Save']");  
		
    //Cancel Button
		public static By CLEAR_BUTTON = By.xpath("//button[@type='button' and normalize-space()='Clear']");
		
    //Update
		public static By UPDATE_BUTTON = By.xpath("//button[normalize-space()='Update']");
		
	// OK button
	    public static By okButton = By.xpath("//button[normalize-space()='OK']");

    
}
