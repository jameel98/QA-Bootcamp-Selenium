package components;

import enums.CategoryOptions;
import enums.Pattern;
import enums.PatternTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShowResults extends BasePage{

    private By freeReturns = By.id("s0-1-17-5[5]-[0]-LH_FR");
    private By returnsAccepted = By.id("s0-1-17-5[5]-[1]-LH_RPA");
    private By authorizedSeller = By.id("s0-1-17-5[5]-[2]-LH_AS");
    private By dealsAndSavings = By.id("s0-1-17-5[5]-[3]-LH_Savings");
    private By saleItems = By.id("s0-1-17-5[5]-[4]-LH_SaleItems");
    private By listedAsLots = By.id("s0-1-17-5[5]-[5]-LH_Lots");
    private By benefitsCharity = By.id("s0-1-17-5[5]-[6]-LH_Charity");
    private By authenticityGarantee = By.id("s0-1-17-5[5]-[7]-LH_AV");
    private By pattern = By.id("s0-1-17-5[5]-3[@field[]]-1[0]-_ftrt");
    private By patternTime = By.id("s0-1-17-5[5]-3[@field[]]-1[1]-_ftrv");
    private By minBidQuantity = By.id("s0-1-17-5[5]-@range-comp[]-@range-textbox[]-textbox");
    private By maxBidQuantity = By.id("s0-1-17-5[5]-@range-comp[]-@range-textbox[]_1-textbox");
    private By minQuantity = By.id("s0-1-17-5[5]-@range-comp[]_1-@range-textbox[]-textbox");
    private By maxQuantity = By.id("s0-1-17-5[5]-@range-comp[]_1-@range-textbox[]_1-textbox");

    public ShowResults(WebDriver driver) {
        super(driver);
    }

    public void clickFreeReturn(){
        WebElement btn =driver.findElement(freeReturns);
        btn.click();
    }
    public void clickReturnsAccepted(){
        WebElement btn =driver.findElement(returnsAccepted);
        btn.click();
    }
    public void clickAuthorizedSeller(){
        WebElement btn =driver.findElement(authorizedSeller);
        btn.click();
    }
    public void clickDealsAndSavings(){
        WebElement btn =driver.findElement(dealsAndSavings);
        btn.click();
    }
    public void clickSaleItems(){
        WebElement btn =driver.findElement(saleItems);
        btn.click();
    }
    public void clickListedAsLots(){
        WebElement btn =driver.findElement(listedAsLots);
        btn.click();
    }
    public void clickBenefitsCharity(){
        WebElement btn =driver.findElement(benefitsCharity);
        btn.click();
    }
    public void clickAuthenticityGarantee(){
        WebElement btn =driver.findElement(authenticityGarantee);
        btn.click();
    }

    public void selectPattern(Pattern input) {
        Select dropKeyword = new Select(driver.findElement(pattern));
        dropKeyword.selectByVisibleText(input.getValue());
    }

    public void selectPatternTime(PatternTime input) {
        Select dropKeyword = new Select(driver.findElement(patternTime));
        dropKeyword.selectByVisibleText(input.getValue());
    }

    public void fillMinBidCount(String input) {
        WebElement textInput =driver.findElement(minBidQuantity);
        textInput.sendKeys(input);
    }
    public void fillMaxBidCount(String input) {
        WebElement textInput =driver.findElement(maxBidQuantity);
        textInput.sendKeys(input);
    }
    public void fillMinQuantity(String input) {
        WebElement textInput =driver.findElement(minQuantity);
        textInput.sendKeys(input);
    }
    public void fillMaxQuantity(String input) {
        WebElement textInput =driver.findElement(maxQuantity);
        textInput.sendKeys(input);
    }

}
