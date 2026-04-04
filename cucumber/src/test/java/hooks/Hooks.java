package hooks;

import io.cucumber.java.Before;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import utils.DriverFactory;

public class Hooks {
	
	  private static boolean isBrowserStarted = false;
	  public static WebDriver driver;

	    @Before
	    public void setup() {

	        if (!isBrowserStarted) {
	            DriverFactory.initDriver();
	            DriverFactory.getDriver().get("https://eyenotes20-base-qa.aravind.org:30434/login"); 
	            isBrowserStarted = true;
	        }
	    }

    @After
    public void tearDown() {
//        DriverFactory.getDriver().quit();
    }
}


