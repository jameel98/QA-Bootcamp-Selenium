package logic.pages;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    @Getter
    protected WebDriver driver;
    //locators
    private final By LABEL_TITLE = By.xpath("(//h2)[1]");

    //web elements
    private WebElement titlePage;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        initPage();
    }
    private void initPage() {
        titlePage = waitToLoad(LABEL_TITLE);
    }

    //get the title of the page
    public String getPageTitle() {
        return titlePage.getText();
    }

    //wait the element to be found
    public WebElement waitToLoad(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            throw new TimeoutException("TimeoutException: \n" + e.getMessage());
        }
    }

    //wait the element to be deleted
    public boolean waitToDelete(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("NoSuchElementException: " + e.getMessage());
        } catch (TimeoutException e) {
            throw new TimeoutException("TimeoutException: " + e.getMessage());
        }
    }

}
