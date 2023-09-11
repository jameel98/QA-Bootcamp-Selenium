package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {


    private By keywordsInput = By.id("AdvKeyword");

 //   @FindBy(id = "searchIncluding")
    private By searchIncludingInput = By.id("searchIncluding");

    private By minPriceInput = By.id("");

    private By maxPriceInput;

    private WebElement conditionDropdown;

    private WebElement buyingFormatDropdown;

//    public void performAdvancedSearch(String keywords, String searchIncluding, String minPrice, String maxPrice, enums.Status status, String buyingFormat) {
//        keywordsInput.clear();
//        keywordsInput.sendKeys(keywords);
//
//        searchIncludingInput.clear();
//        searchIncludingInput.sendKeys(searchIncluding);
//
//        minPriceInput.clear();
//        minPriceInput.sendKeys(minPrice);
//
//        maxPriceInput.clear();
//        maxPriceInput.sendKeys(maxPrice);
//
//        // Select condition from the dropdown
//        // You may need to use a Select class for this, similar to keywordsInput, searchIncludingInput, etc.
//
//        // Select buying format
//        // You may need to use a Select class for this, similar to conditionDropdown
//
//        // Add more actions to submit the form and perform the search
//    }
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public void addToCart(String item) {

        WebElement addToCartButton = driver.findElement(By.id( item));
      //  WebElement addToCartButton = driver.findElement(By.xpath("//div[text()='" + item + "']/following-sibling::div/button"));
        addToCartButton.click();
    }
}