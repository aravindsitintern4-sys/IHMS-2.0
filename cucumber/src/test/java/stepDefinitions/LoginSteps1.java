package stepDefinitions;

import io.cucumber.java.en.*;
import locators.LoginLocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverFactory;

public class LoginSteps1 {

    WebDriver driver = DriverFactory.getDriver();

    // NAVIGATION
    @Given("user is on login page")
    public void user_is_on_login_page() {
//        driver.get(""); 
    }

    // INPUT
    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.username))
            .sendKeys(username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocator.password))
            .sendKeys(password);
    }

    // CLICK
    @When("user clicks on login button")
    public void click_login() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.loginBtn))
            .click();

        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    // VALIDATION
    @Then("user is navigated to ihms dashboard")
    public void user_navigated_to_dashboard() {

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "User not navigated to dashboard");
    }
}