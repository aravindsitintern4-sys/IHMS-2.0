package locators;

import org.openqa.selenium.By;

public class locationmasterLocation {

    // Navigation
    public static By LOCATION_MASTER = By.xpath("//button[.//span[normalize-space()='Location Master']]");

    // Search input
    public static By locationSearchInput = By.xpath("//input[@placeholder='Location name']");

    // Table rows 
    public static By tableRows = By.xpath("//tbody//tr");
}