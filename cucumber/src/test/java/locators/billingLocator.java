package locators;

import org.openqa.selenium.By;

public class billingLocator {

	public static By billingMenu = By.xpath("//span[contains(text(),'Billing')]");

	public static By billEntryOption = By.xpath("//a[contains(normalize-space(),'Bill Entry')]");
}