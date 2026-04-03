package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import locators.locationmasterLocation;

public class locationmasterPage {

    WebDriver driver;

    public locationmasterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigation
    public void clickLocationMaster() {
        driver.findElement(locationmasterLocation.LOCATION_MASTER).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Search
    public void enterLocation(String location) {
        WebElement search = driver.findElement(locationmasterLocation.locationSearchInput);
        search.clear();
        search.sendKeys(location);
    }

    public String getEnteredLocation() {
        return driver.findElement(locationmasterLocation.locationSearchInput).getAttribute("value");
    }
}