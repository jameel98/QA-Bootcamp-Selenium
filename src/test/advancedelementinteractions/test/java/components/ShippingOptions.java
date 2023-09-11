package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingOptions extends BasePage{

    private By freeShipping = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By localPickUp = By.id("s0-1-17-5[6]-[1]-LH_LPickup");

    public ShippingOptions(WebDriver driver) {
        super(driver);
    }
    public void clickFreeShipping(){
        WebElement btn =driver.findElement(freeShipping);
        btn.click();
    }
    public void clickLocalPickUp(){
        WebElement btn =driver.findElement(localPickUp);
        btn.click();
    }


}
