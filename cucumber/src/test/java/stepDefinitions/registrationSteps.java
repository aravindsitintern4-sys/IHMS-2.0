package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.RegistrationPage;
import utils.DriverFactory;

public class registrationSteps {
	WebDriver driver;
    RegistrationPage registrationPage;
    
    public registrationSteps() {
        this.driver = DriverFactory.getDriver();
        this.registrationPage = new RegistrationPage(this.driver);
    }

//    WebDriver driver = DriverFactory.getDriver();
//    RegistrationPage registrationPage = new RegistrationPage(driver);

    @When("user navigates to OP Module and selects {string}")
    public void navigate_to_op_registration(String optionName) {
        registrationPage.navigateToOutpatientRegistration(optionName);
    }

    @Then("the op registration page should be displayed")
    public void verify_registration_page() {
        boolean isLoaded = registrationPage.isOPRegistrationPageLoaded();
        
        Assert.assertTrue(isLoaded, "Registration page failed to load after clicking OP Modules!");
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
    
    @And("user selects kin relation as {string} and enters name {string}")
    public void user_selects_kin_relation_and_enters_name(String relation, String kinName) {
        registrationPage.enterKinDetails(relation, kinName);
    }
    
    @When("user clicks the cancel button")
    public void user_clicks_cancel() {
        registrationPage.clickCancel();
    }
    
    @When("user selects visit type as {string}")
    public void select_visit_type(String type) {
        registrationPage.selectVisitType(type);
    }
    
    @And("user enter Reference No as {string}")
    public void user_enters_reference_no(String refNo) {
        registrationPage.enterReferenceNumber(refNo);
    }
    
    @And("user Click CRS box")
    public void user_clicks_crs_box() {
        registrationPage.setCRSCheckbox(true);
    }
    
    @And("user selects District as {string}")
    public void user_selects_district(String district) {
        registrationPage.selectDistrict(district);
    }
    
    @And("user selects Referral Name as {string}")
    public void user_selects_referral_name(String hospital) {
        registrationPage.selectReferralName(hospital);
    }
    
    @And("user selects Clinic Referred as {string}")
    public void user_selects_clinic_referred_to(String clinic) {
        registrationPage.selectClinicReferredTo(clinic);
    }
    
    @And("user selects Doctor Referred as {string}")
    public void user_selects_doctor_referred_to(String doctor) {
        registrationPage.selectDoctorReferredTo(doctor);
    }
    
    @And("user clicks on referral submit button")
    public void user_clicks_on_referral_submit_button() {
        registrationPage.clickReferralSubmit();
    }
}
























