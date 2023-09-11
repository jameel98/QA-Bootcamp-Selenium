package logic.components;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected WebDriver driver;
    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    private int waitingTime = 10;
    public WebElement waitForElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitingTime);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            throw new TimeoutException("TimeoutException: " + e.getMessage());
        }
    }

}