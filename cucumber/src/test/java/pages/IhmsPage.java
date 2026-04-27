package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Set;

import locators.IhmsLocator;

public class IhmsPage {

    WebDriver driver;
    WebDriverWait wait;

    public IhmsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void waitForDashboardToLoad() {

        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete")
        );

        wait.until(ExpectedConditions.urlContains("dashboard"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmslogin));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Dashboard fully loaded");
    }

    public void clickIHMSModule() {
        String mainWindow = driver.getWindowHandle();

        WebElement ihmsCard = wait.until(ExpectedConditions.elementToBeClickable(IhmsLocator.ihmslogin));
        ihmsCard.click();
        System.out.println("Clicked IHMS Card. Waiting for new window...");

        wait.until(d -> d.getWindowHandles().size() > 1);

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Switched to new window: " + window);
                break;
            }
        }

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(IhmsLocator.ihmsMenu));
            wait.until(ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmsMenu));
            System.out.println("IHMS UI loaded successfully.");
        } catch (TimeoutException e) {
            System.err.println("Page is still blank after switching! Current URL: " + driver.getCurrentUrl());
            debugBlankPage();
        }
    }

    public boolean isIHMSPageDisplayed() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));

            WebElement ihmsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(IhmsLocator.ihmsMenu));

            System.out.println("IHMS menu visible: " + ihmsMenu.getText());
            return ihmsMenu.isDisplayed();

        } catch (TimeoutException e) {
            System.out.println("Timeout: IHMS page NOT displayed within the wait time.");
            debugBlankPage();
            return false;

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            debugBlankPage();
            return false;
        }
    }
    
    private void debugBlankPage() {
        System.out.println("--- DEBUG INFO ---");
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        
        String pageSource = driver.getPageSource();
        if (pageSource != null && pageSource.length() > 500) {
            System.out.println("Page Source Snippet: " + pageSource.substring(0, 500) + "..."); 
        } else {
            System.out.println("Page Source: " + pageSource);
        }
        System.out.println("------------------");
    }
}