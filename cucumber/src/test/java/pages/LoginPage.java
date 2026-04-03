package pages;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.LoginLocator;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Enter Username
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.username))
            .sendKeys(username);
    }

    // Enter Password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.password))
            .sendKeys(password);
    }

    // Click Login Button
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.loginBtn))
            .click();
    }

    // Perform Login 
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Validate 
    public boolean isDashboardLoaded() {
        return wait.until(ExpectedConditions.urlContains("dashboard"));
    }
}