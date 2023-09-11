import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage extends BasePage {
    private final String  INPUT_USER_NAME = "user-name";
    private final String  INPUT_PASSWORD = "password";
    private final String  BUTTON_SUBMIT = "login-button";
    private final String TITLE = "login_logo";
    private  WebElement user;
    private WebElement pass;
    private WebElement submit;
    private WebElement title;
    public LoginPage(WebDriver driver){
        super(driver);
        this.initPage();
    }
    public void initPage(){
        title = this.driver.findElement(By.className(TITLE));
        user = this.driver.findElement(By.id(INPUT_USER_NAME));
        pass = this.driver.findElement(By.name(INPUT_PASSWORD));
        submit = this.driver.findElement(By.id(BUTTON_SUBMIT));
    }
    public void fillUserName(String userName){
        this.user.sendKeys(userName);
    }
    public void fillPassword(String password){
        this.pass.sendKeys(password);
    }
    public void clickOnSubmit(){
        this.submit.click();
    }
    public void fullLoginProcess(String userName,String password){
        this.fillUserName(userName);
        this.fillPassword(password);
        this.clickOnSubmit();
    }
    public boolean titleIsVisible(){
        return this.title.isDisplayed();
    }
    public void checkTitleInPage(){
        Assert.assertEquals(titleIsVisible(),true);
    }
}