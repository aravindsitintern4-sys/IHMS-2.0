package locators;

import org.openqa.selenium.By;

public class LoginLocator {

    public static By username = By.xpath("//input[@placeholder='Username']");
    public static By password = By.xpath("//input[@type='password']"); 
    public static By loginBtn = By.xpath("//button[@type='submit']");
}