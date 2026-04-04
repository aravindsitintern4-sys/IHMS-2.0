package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import locators.roomstatusLocator;

import java.util.List;
import java.util.stream.Collectors;

public class RoomstatusPage {

    WebDriver driver;

    public RoomstatusPage(WebDriver driver) {
        this.driver = driver;
    }

    //NAVIGATION
    public void clickRoomStatus() {
        driver.findElement(roomstatusLocator.ROOM_STATUS).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //PATIENT TYPE
    public void selectPatientType(String patientType) {
        Select select = new Select(driver.findElement(roomstatusLocator.patientTypeDropdown));
        select.selectByVisibleText(patientType);
    }

    public void leavePatientTypeEmpty() {
        Select select = new Select(driver.findElement(roomstatusLocator.patientTypeDropdown));
        select.selectByVisibleText("--Select--");
    }
    
    //VERIFY ALL FIELDS CLEARED
    public boolean areAllFieldsReset() {

        boolean patientTypeReset = new Select(driver.findElement(roomstatusLocator.patientTypeDropdown))
                .getFirstSelectedOption().getText().equals("--Select--");
        boolean roomTypeReset = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown))
                .getFirstSelectedOption().getText().equals("--Select--");
        boolean occupancyReset = new Select(driver.findElement(roomstatusLocator.occupancyFlagDropdown))
                .getFirstSelectedOption().getText().equals("--Select--");
        boolean floorReset = new Select(driver.findElement(roomstatusLocator.floorDropdown))
                .getFirstSelectedOption().getText().equals("--Select--");
        boolean toiletReset = new Select(driver.findElement(roomstatusLocator.toiletTypeDropdown))
                .getFirstSelectedOption().getText().equals("--Select--");
        boolean locationReset = new Select(driver.findElement(roomstatusLocator.locationDropdown))
                .getFirstSelectedOption().getText().equals("--Select--");
        boolean roomNoReset = driver.findElement(roomstatusLocator.roomNoInput).getAttribute("value").isEmpty();

        return patientTypeReset && roomTypeReset && occupancyReset && floorReset
                && toiletReset && locationReset && roomNoReset;
    }

    //ROOM TYPE 
    public void selectRoomType(String roomType) {
        Select select = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown));
        select.selectByVisibleText(roomType);
    }

    public void leaveRoomTypeEmpty() {
        Select select = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown));
        select.selectByVisibleText("--Select--");
    }

    public List<String> getRoomTypeOptions() {
        Select select = new Select(driver.findElement(roomstatusLocator.roomTypeDropdown));
        return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    //ROOM NUMBER
    public void enterRoomNo(String roomNo) {
        WebElement input = driver.findElement(roomstatusLocator.roomNoInput);
        input.clear();
        input.sendKeys(roomNo);
    }

    public void leaveRoomNoEmpty() {
        driver.findElement(roomstatusLocator.roomNoInput).clear();
    }

    //OCCUPANCY FLAG 
    public void selectOccupancyFlag(String occupancyFlag) {
        Select select = new Select(driver.findElement(roomstatusLocator.occupancyFlagDropdown));
        select.selectByVisibleText(occupancyFlag);
    }

    public void leaveOccupancyFlagEmpty() {
        Select select = new Select(driver.findElement(roomstatusLocator.occupancyFlagDropdown));
        select.selectByVisibleText("--Select--");
    }

    //FLOOR 
    public void selectFloor(String floor) {
        Select select = new Select(driver.findElement(roomstatusLocator.floorDropdown));
        select.selectByVisibleText(floor);
    }

    public void leaveFloorEmpty() {
        Select select = new Select(driver.findElement(roomstatusLocator.floorDropdown));
        select.selectByVisibleText("--Select--");
    }

    //TOILET TYPE 
    public void selectToiletType(String toiletType) {
        Select select = new Select(driver.findElement(roomstatusLocator.toiletTypeDropdown));
        select.selectByVisibleText(toiletType);
    }

    public void leaveToiletTypeEmpty() {
        Select select = new Select(driver.findElement(roomstatusLocator.toiletTypeDropdown));
        select.selectByVisibleText("--Select--");
    }

    //LOCATION
    public void selectLocation(String location) {
        Select select = new Select(driver.findElement(roomstatusLocator.locationDropdown));
        select.selectByVisibleText(location);
    }

    public void leaveLocationEmpty() {
        Select select = new Select(driver.findElement(roomstatusLocator.locationDropdown));
        select.selectByVisibleText("--Select--");
    }

    //SAVE BUTTON 
//    public boolean isSaveEnabled() {
//        return driver.findElement(roomstatusLocator.saveButton).isEnabled();
//    }
//
//    public void clickSave() {
//        driver.findElement(roomstatusLocator.saveButton).click();
//    }
//
//    CLEAR BUTTON
//    public void clickClear() {
//        driver.findElement(roomstatusLocator.clearButton).click();
//    }
 
   // SEARCH ROOM
    public void enterSearchRoomNo(String roomNo) {
        WebElement search = driver.findElement(roomstatusLocator.searchRoomInput);
        search.clear();   
        search.sendKeys(roomNo);
    }

    public boolean isSearchResultDisplayed() {
        return driver.findElements(roomstatusLocator.Tablerow).size() > 0;
    }

    public boolean isNoResultDisplayed() {
        return driver.findElements(roomstatusLocator.Tablerow).size() == 0;
    }
}