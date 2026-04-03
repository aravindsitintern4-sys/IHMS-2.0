package pages;

import locators.masterLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MasterPage {

    WebDriver driver;

    public MasterPage(WebDriver driver) {
        this.driver = driver;
    }
   
    public void selectOutpatientMasters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement masters = wait.until(
                ExpectedConditions.visibilityOfElementLocated(masterLocator.MASTERS));

        Actions actions = new Actions(driver);

        actions.moveToElement(masters)
               .moveToElement(wait.until(
                   ExpectedConditions.visibilityOfElementLocated(masterLocator.OUTPATIENT_MASTERS)))
               .click()
               .build()
               .perform();
    }
}