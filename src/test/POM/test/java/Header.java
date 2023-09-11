import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {

    private By headerLogo = By.className("app_logo");
    private By headerCartIcon = By.className("shopping_cart_container");

    public Header(WebDriver driver) {
        super(driver);
    }
    public void clickHeaderLogo() {
        driver.findElement(headerLogo).click();
    }

    public void clickHeaderCartIcon() {
        driver.findElement(headerCartIcon).click();
    }
}
