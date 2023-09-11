import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu  extends BasePage{

    private By allItemsLink = By.id("inventory_sidebar_link");
    private By aboutLink = By.id("about_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");
    private By menuBtn = By.id("react-burger-menu-btn");

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    public void clickAllItemsLink() {
        WebElement allItemsElement = driver.findElement(allItemsLink);
        allItemsElement.click();
    }

    public void clickSideMenuButton(){
        WebElement allItemsElement = driver.findElement(menuBtn);
        allItemsElement.click();
    }
    public void clickAboutLink() {
        WebElement aboutElement = driver.findElement(aboutLink);
        aboutElement.click();
    }

    public void clickLogoutLink() {
        WebElement logoutElement = driver.findElement(logoutLink);
        logoutElement.click();
    }
}
