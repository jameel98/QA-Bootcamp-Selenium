package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Price extends BasePage {

    private By showItems = By.id("s0-1-17-5[2]-[0]-");
    private By minPrice = By.id("s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox");
    private By maxPrice = By.id("s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox");

    public Price(WebDriver driver){
        super(driver);
    }

    public void clickShowItems(){
        WebElement btn =driver.findElement(showItems);
        btn.click();
    }

    public void fillMinPrice(String input){
        WebElement minprice =driver.findElement(minPrice);
        minprice.sendKeys(input);
    }

    public void fillMaxPrice(String input){
        WebElement maxprice =driver.findElement(maxPrice);
        maxprice.sendKeys(input);
    }


}
