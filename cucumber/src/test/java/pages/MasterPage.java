package pages;

import locators.masterLocator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MasterPage {

    WebDriver driver;
    WebDriverWait wait;

        public MasterPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void openMastersMenu() {
            WebElement masters = wait.until(
                ExpectedConditions.visibilityOfElementLocated(masterLocator.MASTERS)
            );

            Actions actions = new Actions(driver);
            actions.moveToElement(masters).pause(Duration.ofMillis(500)).perform();
        }

        public void clickOutpatientMasters() {

            WebElement outpatient = wait.until(
                ExpectedConditions.visibilityOfElementLocated(masterLocator.OUTPATIENT_MASTERS)
            );

            wait.until(ExpectedConditions.elementToBeClickable(outpatient));

            outpatient.click();
        }
        
    }
