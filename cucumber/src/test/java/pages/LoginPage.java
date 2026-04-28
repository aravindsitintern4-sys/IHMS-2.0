package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.LoginLocator;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.username));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.username)).clear();
        driver.findElement(LoginLocator.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.password)).clear();
        driver.findElement(LoginLocator.password).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.loginBtn)).click();


        wait.until(ExpectedConditions.urlContains("dashboard"));
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