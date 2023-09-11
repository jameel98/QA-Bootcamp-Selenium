package components;

import enums.CategoryOptions;
import enums.KeywordOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeyWords extends BasePage {

    private By keywords = By.id("_nkw");
    private By keywordsOptions = By.id("s0-1-17-4[0]-7[1]-_in_kw");
    private By excludeWords = By.id("_ex_kw");
    private By category = By.id("s0-1-17-4[0]-7[3]-_sacat");
    private By searchButton = By.xpath("/html/body/div[3]/div/main/form/fieldset[1]/div[5]/button");

    public KeyWords(WebDriver driver){
        super(driver);
    }

    public void setKeywords(String input){
        WebElement keyWords =driver.findElement(keywords);
        keyWords.sendKeys(input);
    }

    public void setKeywordsOptions(KeywordOptions input) {
        Select dropKeyword = new Select(driver.findElement(keywordsOptions));
        dropKeyword.selectByVisibleText(input.getValue());

    }

    public void setExcludeWords(String input) {
        WebElement keyWords =driver.findElement(excludeWords);
        keyWords.sendKeys(input);    }

    public void setCategory(CategoryOptions input) {
        Select dropKeyword = new Select(driver.findElement(category));
        dropKeyword.selectByVisibleText(input.getValue());

    }

    public void setSearchButton() {
        WebElement search =driver.findElement(searchButton);
        search.click();
    }

}
