package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.LoginLocator;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
    }

    // Wait for login page
    public void waitForLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.username));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.username))
            .sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.password))
            .sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.loginBtn))
            .click();
    }

    public void login(String username, String password) {
        waitForLoginPage();  
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isDashboardLoaded() {
        return wait.until(ExpectedConditions.urlContains("dashboard"));
    }
}