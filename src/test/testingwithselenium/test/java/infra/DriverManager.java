package infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    protected static WebDriver driver;
    private static final String driverPath = "C:\\Users\\Admin\\IdeaProjects\\Testing with selenium\\chromedriver.exe";
    public DriverManager() {

    }

    /**
     * initialize chrome driver
     * @return
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.get("https://testomate-test.web.app/home");
        }
        return driver;
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}