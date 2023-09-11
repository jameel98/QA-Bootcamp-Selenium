package components;

import enums.KeywordOptions;
import enums.PerPageOptions;
import enums.SortByOptions;
import enums.ViewResultOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Sort extends BasePage{

    private By sortBy = By.id("s0-1-17-8[9]-1[0]-_sop");
    private By viewResults = By.id("s0-1-17-8[9]-1[1]-_dmd");
    private By resultsPerPage = By.id("s0-1-17-8[9]-1[2]-_ipg");
    private By searchButton = By.xpath("/html/body/div[3]/div/main/form/div[2]/button");
    private By clearOptions = By.className("nav-link");

    public Sort(WebDriver driver) {
        super(driver);
    }
    public void sortBy(SortByOptions input) {
        Select dropKeyword = new Select(driver.findElement(sortBy));
        dropKeyword.selectByVisibleText(input.getValue());

    }
    public void viewResults(ViewResultOptions input) {
        Select dropKeyword = new Select(driver.findElement(viewResults));
        dropKeyword.selectByVisibleText(input.getValue());

    }
    public void resultsPerPage(PerPageOptions input) {
        Select dropKeyword = new Select(driver.findElement(resultsPerPage));
        dropKeyword.selectByVisibleText(input.getValue());

    }

    public void setSearchButton() {
        WebElement search =driver.findElement(searchButton);
        search.click();
    }
    public void clearResults() {
        WebElement search =driver.findElement(searchButton);
        search.click();
    }

}
