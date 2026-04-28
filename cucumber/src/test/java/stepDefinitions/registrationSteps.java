package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.RegistrationPage;
import utils.DriverFactory;

public class registrationSteps {

    WebDriver driver = DriverFactory.getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @When("user navigates to OP Module and selects {string}")
    public void navigate_to_op_registration(String optionName) {
        registrationPage.selectOutpatientRegistration(optionName);
    }

    @Then("the op registration page should be displayed")
    public void verify_op_registration_page() {

        Assert.assertTrue(registrationPage.isOPRegistrationPageLoaded(),
                "Navigation failed: OP Registration page not loaded");

        System.out.println("OP Registration Page Loaded Successfully");
    }
    
    @When("user selects payment type {string}")
    public void select_payment(String type) {
        registrationPage.selectPaymentType(type);
    }
    
    @When("user selects patient type as {string}")
    public void user_selects_patient_type(String type) {
        registrationPage.selectPatientType(type);
    }
 
    @When("user enters first name {string} and last name {string}")
    public void user_enters_names(String firstName, String lastName) {
        registrationPage.enterPatientNames(firstName, lastName);
    }
    
    @When("user enters age as {string} and clicks the DOB field")
    public void user_enters_age_and_clicks_dob(String age) {
        registrationPage.enterAgeAndClickDob(age);
    }
    
    @When("user selects gender as {string}")
    public void user_selects_gender(String gender) {
        registrationPage.selectGender(gender);
    }
    
    @And("user handles confirmation popup for {string} by clicking {string}")
    public void handle_gender_popup(String gender, String action) {
        if (gender.equalsIgnoreCase("Transgender")) {
            registrationPage.handleGenderConfirmation(action);
        } else {
            System.out.println("Skipping gender confirmation for: " + gender);
        }
    }
}