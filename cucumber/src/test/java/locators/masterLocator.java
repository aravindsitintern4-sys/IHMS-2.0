package locators;

import org.openqa.selenium.By;

public class masterLocator {

	public static By MASTERS = By.xpath("//span[normalize-space()='Masters']/parent::div");
	public static By OUTPATIENT_MASTERS = By.xpath("//a[normalize-space()='Outpatient Masters']");
}