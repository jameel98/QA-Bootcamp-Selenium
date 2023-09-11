package logic.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewRestaurantPopUp extends BaseComponent {

    // Locators
    private final By INPUT_ID = By.id("id");
    private final By INPUT_NAME = By.id("name");
    private final By INPUT_ADDRESS = By.id("address");
    private final By INPUT_SCORE = By.id("score");
    private final By BUTTON_CLOSE = By.id("close-button");
    private final By BUTTON_SUBMIT = By.xpath("//button[text() = 'Submit']");

    // Web elements
    private WebElement idInput;
    private WebElement nameInput;
    private WebElement addressInput;
    private WebElement scoreInput;
    private WebElement closeBtn;
    private WebElement submitBtn;

    public NewRestaurantPopUp(WebDriver driver) {
        super(driver);
        initializePageElements();
    }

    private void initializePageElements() {
        idInput = waitForElement(INPUT_ID);
        nameInput = waitForElement(INPUT_NAME);
        addressInput = waitForElement(INPUT_ADDRESS);
        scoreInput = waitForElement(INPUT_SCORE);
        closeBtn = waitForElement(BUTTON_CLOSE);
        submitBtn = waitForElement(BUTTON_SUBMIT);
    }

    public void closeCreateRestaurantPopUp() {
        closeBtn.click();
    }

    private void submitForm() {
        submitBtn.click();
    }

    private void enterId(int id) {
        idInput.sendKeys(String.valueOf(id));
    }

    private void enterName(String name) {
        nameInput.sendKeys(name);
    }

    private void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    private void enterScore(double score) {
        scoreInput.sendKeys(String.valueOf(score));
    }

    private void clearFormInputs() {
        idInput.clear();
        nameInput.clear();
        addressInput.clear();
        scoreInput.clear();
    }

    public void createRestaurant(int id, String name, String address, double score) {
        clearFormInputs();
        enterId(id);
        enterName(name);
        enterAddress(address);
        enterScore(score);
        submitForm();
    }
}
