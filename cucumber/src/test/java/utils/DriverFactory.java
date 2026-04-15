package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Collections;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-blink-features=AutomationControlled");
            
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }  

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; 
        }
    }
}