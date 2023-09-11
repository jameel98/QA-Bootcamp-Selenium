package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchIncluding extends BasePage{

    private By titleAndDescription = By.id("s0-1-17-5[1]-[0]-LH_TitleDesc");
    private By CompletedItems = By.id("s0-1-17-5[1]-[1]-LH_Complete");
    private By SoldItems = By.id("s0-1-17-5[1]-[2]-LH_Sold");

    public SearchIncluding(WebDriver driver){
        super(driver);
    }
    public void clickTitleAndDescription(){
        WebElement search =driver.findElement(titleAndDescription);
        search.click();
    }
    public void clickCompletedItems(){
        WebElement search =driver.findElement(CompletedItems);
        search.click();
    }
    public void clickSoldItems(){
        WebElement search =driver.findElement(SoldItems);
        search.click();
    }

}
