package locators;

import org.openqa.selenium.By;

public class LoginLocator {

	public static By username = By.id("username");
	public static By password = By.id("password");
	public static By loginBtn = By.xpath("//button[@type='submit']");
}