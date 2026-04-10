package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.LoginLocator;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPageToLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.username))
            .clear(); 
        driver.findElement(LoginLocator.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.password))
            .clear();
        driver.findElement(LoginLocator.password).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.loginBtn))
            .click();
    }

    public void login(String username, String password) {
        waitForPageToLoad();   

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isDashboardLoaded() {
        try {
            return wait.until(ExpectedConditions.urlContains("dashboard"));
        } catch (Exception e) {
            return false;
        }
    }
}