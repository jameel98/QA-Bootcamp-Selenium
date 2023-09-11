package components;

import enums.CountryOptions;
import enums.PatternTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemLocation extends BasePage {

    private By defaultt = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By usOnly = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By northAmerica = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By worldWide = By.id("s0-1-17-5[6]-[0]-LH_FS");
    private By locationCountry = By.id("s0-1-17-6[7]-5[@field[]]-_salic");
    private By availibleCountry = By.id("s0-1-17-6[7]-5[@field[]]_1-_saact");

    public ItemLocation(WebDriver driver) {
        super(driver);
    }
    public void clickDefault(){
        WebElement btn =driver.findElement(defaultt);
        btn.click();
    }
    public void clickUsOnly(){
        WebElement btn =driver.findElement(usOnly);
        btn.click();
    }

    public void clickNorthAmerica(){
        WebElement btn =driver.findElement(northAmerica);
        btn.click();
    }
    public void clickWorldWide(){
        WebElement btn =driver.findElement(worldWide);
        btn.click();
    }

    public void selectItemLocation(CountryOptions input) {
        Select dropKeyword = new Select(driver.findElement(locationCountry));
        dropKeyword.selectByVisibleText(input.getValue());
    }

    public void selectAvailibleCountry(CountryOptions input) {
        Select dropKeyword = new Select(driver.findElement(availibleCountry));
        dropKeyword.selectByVisibleText(input.getValue());
    }

}
