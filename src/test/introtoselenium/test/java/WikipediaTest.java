import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {
    private WebDriver driver;
    String searchData = "Aardvark";
    String pageSearch = "bear";

    @BeforeEach
    public void setUp() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\IntroToSelenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchAndCount() {
        // Open Wikipedia
        driver.get("https://www.wikipedia.org");

        // Perform the search
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(searchData);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        // Count occurrences of "bear" on the page
        String pageText = driver.findElement(By.tagName("body")).getText();
        int bearCount = countOccurrences(pageText, pageSearch);
        System.out.println("Number of occurrences of 'bear': " + bearCount);
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    private int countOccurrences(String text, String target) {
        return text.split(target, -1).length - 1;
    }
}
