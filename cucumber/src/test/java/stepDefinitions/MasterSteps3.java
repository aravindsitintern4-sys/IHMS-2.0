package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.MasterPage;
import utils.DriverFactory;

public class MasterSteps3 {

    WebDriver driver = DriverFactory.getDriver();
    MasterPage masterPage = new MasterPage(driver);

    @When("user clicks on Masters menu")
    public void user_clicks_on_masters_menu() {
        masterPage.clickOutpatientMasters();   
    }

    @When("user selects Outpatient Masters")
    public void user_selects_outpatient_masters() {
        masterPage.clickOutpatientMasters();
    }

    @Then("user should be navigated to Outpatient Masters page")
    public void user_should_be_navigated() {
        System.out.println("Navigation successful");
    }
}