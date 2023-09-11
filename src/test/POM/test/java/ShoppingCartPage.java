import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsCount() {

        return driver.findElements(By.className("cart_item")).size();
    }

    public void removeItem(String item) {
        WebElement removeButton = driver.findElement(By.id(item));
        removeButton.click();
    }
}
