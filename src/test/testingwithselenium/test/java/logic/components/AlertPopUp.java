package logic.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertPopUp extends BaseComponent{

    private final By ALERT_POPUP_MSG = By.xpath("//div[@id = 'alert-popup']//h2");
    private final By ALERT_POPUP_BUTTON = By.xpath("//div[@id = 'alert-popup']//button");

    // Web Elements
    private WebElement alertMessage;
    private WebElement alertButton;

    public AlertPopUp(WebDriver driver) {
        super(driver);
    }

    public void clickOnConfirmAlertBtn(){
        alertButton = waitForElement(ALERT_POPUP_BUTTON);
        alertButton.click();
    }

    public String getAlertMsg(){
        alertMessage = waitForElement(ALERT_POPUP_MSG);
        return alertMessage.getText();
    }

}