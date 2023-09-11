package logic.pages;

import logic.components.AlertPopUp;
import logic.components.NewRestaurantPopUp;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantPage extends BasePage {

    //locators
    private final By BUTTON_CREATE = By.xpath("//button[text() = 'Create new']");
    private final String buttonDeleteLocator = "//td[text() = '%s']//..//button";
    private final String restaurantRawLocator = "//tr[td[text()= '%s'] and td[text()= '%s'] and td[text()= '%s'] and td[text()= '%s']]";

    //web elements
    private WebElement createButton;
    private WebElement deleteButton;

    //popup
    @Getter
    private AlertPopUp alertPopUp;

    public RestaurantPage(WebDriver driver) {
        super(driver);
        initPage();
    }

    private void initPage() {
        createButton = waitToLoad(BUTTON_CREATE);
        alertPopUp = new AlertPopUp(driver);
    }

    public void createNewRestaurant(int id, String name, String address, double score) {
        createButton.click();
        NewRestaurantPopUp newRestaurantPopUp = new NewRestaurantPopUp(getDriver());
        newRestaurantPopUp.createRestaurant(id, name, address, score);
    }

    public void closePopUp() {
        NewRestaurantPopUp newRestaurantPopUp = new NewRestaurantPopUp(getDriver());
        newRestaurantPopUp.closeCreateRestaurantPopUp();
    }

    public boolean deleteRestaurant(int id) {
        By BUTTON_DELETE = By.xpath(String.format(buttonDeleteLocator, id));
        deleteButton = waitToLoad(BUTTON_DELETE);
        deleteButton.click();
        return waitToDelete(BUTTON_DELETE);
    }

    public boolean findRestaurantInPage(int id, String name, String address, double score) {
        By RESTAURANT_ROW = By.xpath(String.format(restaurantRawLocator, id, name, address, score));
        try {
            waitToLoad(RESTAURANT_ROW);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
            return false;
        }
    }

}