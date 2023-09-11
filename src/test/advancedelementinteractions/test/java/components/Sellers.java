package components;

import enums.SellersOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Sellers extends BasePage{

    private By sellersOption = By.id("s0-1-17-7[8]-7[0[@adv-seller]]-_saslop");
    private By sellersText = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By sellersWithEbay = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By mySavedSellers = By.id("s0-1-17-5[6]-[0]-LH_FS");

    public Sellers(WebDriver driver) {
        super(driver);
    }

    public void selectSellerOptions(SellersOptions input) {
        Select dropKeyword = new Select(driver.findElement(sellersOption));
        dropKeyword.selectByValue(input.getValue());
    }

    public void setSellersText(String input) {
        WebElement keyWords =driver.findElement(sellersText);
        keyWords.sendKeys(input);
    }
    public void clickSellersWithEbay(){
        WebElement btn =driver.findElement(sellersWithEbay);
        btn.click();
    }

    public void clickMySavedSellers(){
        WebElement btn =driver.findElement(mySavedSellers);
        btn.click();
    }

}
