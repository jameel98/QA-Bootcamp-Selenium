package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyingFormat extends BasePage{

    private By acceptsOffers = By.id("s0-1-17-6[3]-[0]-LH_BO");
    private By auction = By.id("s0-1-17-6[3]-[1]-LH_Auction");
    private By buyItNow = By.id("s0-1-17-6[3]-[2]-LH_BIN");
    private By classifiedAds = By.id("s0-1-17-6[3]-[3]-LH_CAds");

    public BuyingFormat(WebDriver driver){
        super(driver);
    }

    public void clickAcceptsOffers(){
        WebElement btn =driver.findElement(acceptsOffers);
        btn.click();
    }
    public void clickAuction(){
        WebElement btn =driver.findElement(auction);
        btn.click();
    }
    public void clickBuyItNow(){
        WebElement btn =driver.findElement(buyItNow);
        btn.click();
    }
    public void clickClassifiedAds(){
        WebElement btn =driver.findElement(classifiedAds);
        btn.click();
    }
}
