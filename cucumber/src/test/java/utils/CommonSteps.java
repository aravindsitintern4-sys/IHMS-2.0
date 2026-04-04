package utils;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import pages.reuseableCodePage;
import org.openqa.selenium.WebDriver;


public class CommonSteps {

    WebDriver driver = DriverFactory.getDriver();
    reuseableCodePage page = new reuseableCodePage(driver);
    
	   //NAVIGATION
    @Given("user is on dashboard group landing page")
    public void dashboard_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
    
    
}
