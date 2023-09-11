import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer extends BasePage{
    private By twitterIcon = By.cssSelector(".social_twitter");
    private By facebookIcon = By.cssSelector(".social_facebook");
    private By linkedinIcon = By.cssSelector(".social_linkedin");

    public Footer(WebDriver driver) {
        super(driver);
    }

    public void clickTwitterIcon() {
        driver.findElement(twitterIcon).click();
    }

    public void clickFacebookIcon() {
        driver.findElement(facebookIcon).click();
    }

    public void clickLinkedInIcon() {
        driver.findElement(linkedinIcon).click();
    }
}
