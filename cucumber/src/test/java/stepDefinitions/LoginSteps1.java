package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage; 
import utils.DriverFactory;

public class LoginSteps1 {

    private WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://eyenotes20-base-qa.aravind.org:31026/login");
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void click_login() {
        loginPage.clickLogin();
    }

    @Then("user is navigated to ihms dashboard")
    public void user_navigated_to_dashboard() {
        Assert.assertTrue(loginPage.isDashboardLoaded(), "User was NOT navigated to the dashboard!");
    }
}