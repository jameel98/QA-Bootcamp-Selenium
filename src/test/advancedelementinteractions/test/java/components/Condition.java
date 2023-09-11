package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Condition extends BasePage{

    private By newButton = By.id("s0-1-17-6[4]-[0]-LH_ItemCondition");
    private By usedButton = By.id("s0-1-17-6[4]-[1]-LH_ItemCondition");
    private By notSpecifiedButton = By.id("s0-1-17-6[4]-[2]-LH_ItemCondition");

    public Condition(WebDriver driver){
        super(driver);
    }
    public void clickNewBtn(){
        WebElement btn =driver.findElement(newButton);
        btn.click();
    }
    public void clickUsedBtn(){
        WebElement btn =driver.findElement(usedButton);
        btn.click();
    }
    public void clickNotSpecifiedButton(){
        WebElement btn =driver.findElement(notSpecifiedButton);
        btn.click();
    }

}
