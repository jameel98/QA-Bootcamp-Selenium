import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);

    }
    public void addToCart(String item) {

        WebElement addToCartButton = driver.findElement(By.id( item));
      //  WebElement addToCartButton = driver.findElement(By.xpath("//div[text()='" + item + "']/following-sibling::div/button"));
        addToCartButton.click();
    }
    public void navigateToCartPage(String item){
        WebElement cartPageButton = driver.findElement(By.className( item));
        cartPageButton.click();
    }
}