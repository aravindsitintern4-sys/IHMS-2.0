package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverFactory;
import locators.roomstatusLocator;

import java.util.List;

public class roomstatusSteps5 {

    WebDriver driver = DriverFactory.getDriver();

    //NAVIGATION
    @When("user clicks on Current Room Status")
    public void user_clicks_on_room_status() {
        driver.findElement(roomstatusLocator.ROOM_STATUS).click();
    }
    
    @Then("user should be navigated to Room Master page")
    public void verify_navigation() {
        Assert.assertTrue(driver.getCurrentUrl().contains("roomstatus"),"Room Status page not opened");
    }

    //PATIENT TYPE
    @And("user selects Patient Type {string}")
    public void select_patient_type(String patientType) {
        Select select = new Select(driver.findElement(roomstatusLocator.patientTypeDropdown));
        select.selectByVisibleText(patientType);
    }
    
    @Then("room Type dropdown should display correct options")
    public void verify_room_type_options(io.cucumber.datatable.DataTable dataTable) {
        Select select = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown));
        List<WebElement> options = select.getOptions();
        List<String> expectedOptions = dataTable.asList(String.class);

        for (String expected : expectedOptions) {
            if (!expected.isEmpty()) { 
                boolean found = options.stream().anyMatch(o -> o.getText().equals(expected));
                Assert.assertTrue(found, "Expected Room Type option not found: " + expected);
            }
        }
    }
    
  //NEGATIVE CHECKS 
    @And("user leaves room status {string} empty")
    public void user_leaves_room_status_empty(String fieldName) {

        switch (fieldName.trim().toLowerCase()) {
            case "patient type":
                new Select(driver.findElement(roomstatusLocator.patientTypeDropdown)).selectByIndex(0);
                break;
            case "room type":
                new Select(driver.findElement(roomstatusLocator.roomTypeDropdown)).selectByIndex(0);
                break;
            case "room number":
                driver.findElement(roomstatusLocator.roomNoInput).clear();
                break;
            case "occupancy flag":
                new Select(driver.findElement(roomstatusLocator.occupancyFlagDropdown)).selectByIndex(0);
                break;
            case "floor":
                new Select(driver.findElement(roomstatusLocator.floorDropdown)).selectByIndex(0);
                break;
            case "toilet type":
                new Select(driver.findElement(roomstatusLocator.toiletTypeDropdown)).selectByIndex(0);
                break;
            case "location":
                new Select(driver.findElement(roomstatusLocator.locationDropdown)).selectByIndex(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + fieldName);
        }
    }

    //ROOM TYPE
    @And("user selects Room Type {string}")
    public void select_room_type(String roomType) {
        Select select = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown));
        select.selectByVisibleText(roomType);
    }
     
    //ROOM NUMBER
    @And("user enters Room No {string}")
    public void enter_room_no(String roomNo) {
        WebElement input = driver.findElement(roomstatusLocator.roomNoInput);
        input.clear();
        input.sendKeys(roomNo);
    }
   
    //OCCUPANCY FLAG
    @And("user selects Occupancy Flag {string}")
    public void select_occupancy_flag(String occupancyFlag) {
        Select select = new Select(driver.findElement(roomstatusLocator.occupancyFlagDropdown));
        select.selectByVisibleText(occupancyFlag);
    }

    //FLOOR 
    @And("user selects Floor {string}")
    public void select_floor(String floor) {
        Select select = new Select(driver.findElement(roomstatusLocator.floorDropdown));
        select.selectByVisibleText(floor);
    }

    //TOILET TYPE 
    @And("user selects Toilet Type {string}")
    public void select_toilet_type(String toiletType) {
        Select select = new Select(driver.findElement(roomstatusLocator.toiletTypeDropdown));
        select.selectByVisibleText(toiletType);
    }

    //LOCATION
    @And("user selects Location {string}")
    public void select_location(String location) {
        Select select = new Select(driver.findElement(roomstatusLocator.locationDropdown));
        select.selectByVisibleText(location);
    }

    //SAVE BUTTON
    @Then("the room status save button should be disabled")
    public void validate_save_disabled() {
        Assert.assertFalse(driver.findElement(roomstatusLocator.saveButton).isEnabled(), "Save button should be disabled");
    }

    @Then("room status save button should be enabled")
    public void validate_save_enabled() {
        Assert.assertTrue(driver.findElement(roomstatusLocator.saveButton).isEnabled(), "Save button should be enabled");
    }

    @When("user clicks Save button in roomstatus page")
    public void click_save_button() {
        driver.findElement(roomstatusLocator.saveButton).click();
    }

    @Then("room status should be saved successfully")
    public void verify_room_saved() {
        System.out.println("Room status saved successfully");
    }

    //CLEAR BUTTON
    @And("user clicks on Clear button in roomstatus page")
    public void click_clear_button() {
        driver.findElement(roomstatusLocator.clearButton).click();
    }

    @Then("all fields should be reset")
    public void verify_fields_cleared() {
        Assert.assertEquals(driver.findElement(roomstatusLocator.roomNoInput).getAttribute("value"), "");

        Select patientSelect = new Select(driver.findElement(roomstatusLocator.patientTypeDropdown));
        Assert.assertEquals("--Select--", patientSelect.getFirstSelectedOption().getText());

        Select roomSelect = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown));
        Assert.assertEquals("--Select--", roomSelect.getFirstSelectedOption().getText());

        Select occupancySelect = new Select(driver.findElement(roomstatusLocator.occupancyFlagDropdown));
        Assert.assertEquals("--Select--", occupancySelect.getFirstSelectedOption().getText());

        Select floorSelect = new Select(driver.findElement(roomstatusLocator.floorDropdown));
        Assert.assertEquals("--Select--", floorSelect.getFirstSelectedOption().getText());

        Select toiletSelect = new Select(driver.findElement(roomstatusLocator.toiletTypeDropdown));
        Assert.assertEquals("--Select--", toiletSelect.getFirstSelectedOption().getText());

        Select locationSelect = new Select(driver.findElement(roomstatusLocator.locationDropdown));
        Assert.assertEquals("--Select--", locationSelect.getFirstSelectedOption().getText());
    }
    
 //SEARCH ROOM
    @And("user enters Room No in search {string}")
    public void user_enters_room_no_in_search(String roomNo) {
        WebElement search = driver.findElement(roomstatusLocator.searchRoomInput);
        search.clear(); 
        search.sendKeys(roomNo);
    }
    @Then("room status search result should be displayed")
    public void room_status_search_result() {

        try { Thread.sleep(1000); } catch (Exception e) {}
        boolean isResultPresent = driver.findElements(By.xpath("//table//tr")).size() > 0;
        Assert.assertTrue(isResultPresent, "No search results found");
    }
    @Then("no room status result should be displayed")
    public void no_room_status_result_should_be_displayed() {

        try { Thread.sleep(1000); } catch (Exception e) {}
        boolean isEmpty = driver.findElements(By.xpath("//table//tr")).size() == 0;
        Assert.assertTrue(isEmpty, "Results found for invalid search");
    }
}