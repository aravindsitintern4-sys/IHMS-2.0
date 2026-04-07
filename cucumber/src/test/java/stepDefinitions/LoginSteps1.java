package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.LoginPage;
import hooks.Hooks;

public class LoginSteps1 {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.login(username, password);  
    }

    @When("user clicks on login button")
    public void click_login() {
        // Already handled in login()
    }

    @Then("user is navigated to ihms dashboard")
    public void user_navigated_to_dashboard() {
        Assert.assertTrue(loginPage.isDashboardLoaded(),
                "User not navigated to dashboard");
    }
}