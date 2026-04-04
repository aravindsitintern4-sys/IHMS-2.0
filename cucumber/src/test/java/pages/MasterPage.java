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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    public void clickOutpatientMasters() {

        WebElement masters = wait.until(
            ExpectedConditions.visibilityOfElementLocated(masterLocator.MASTERS)
        );

        WebElement parent = masters.findElement(By.xpath(".."));

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].querySelector('div.absolute').style.display='block';",
            parent
        );

        // ✅ Wait and click option
        WebElement outpatient = wait.until(
            ExpectedConditions.elementToBeClickable(masterLocator.OUTPATIENT_MASTERS)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", outpatient);
    }
}