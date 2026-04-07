package locators;

import org.openqa.selenium.By;

public class billingLocator {
	
	public static By BILLING_MENU = By.xpath("//span[contains(normalize-space(),'Billing')]");

    public static By BILL_ENTRY = By.xpath("//a[normalize-space()='Bill Entry']");

    public static By BILL_CANCELLATION = By.xpath("//a[normalize-space()='Bill Cancellation']");

    public static By BILL_REFUND = By.xpath("//a[normalize-space()='Bill Refund']");
}
