import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationTest {

    private String standardUser = "standard_user";
    private String password = "secret_sauce";
    private final String BACKPACKITEMID = "add-to-cart-sauce-labs-backpack";
    private final String BIKELIGHTITEMID = "add-to-cart-sauce-labs-bike-light";
    private final String BIKELIGHTREMOVEITEMID = "remove-sauce-labs-bike-light";
    private final String TSHIRTITEMID = "add-to-cart-sauce-labs-bolt-t-shirt";
    private String shopCartPageButton = "shopping_cart_link";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\POM\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void testFlowA() {
        //arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\POM\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com");

        //initialize login page
        LoginPage loginPage = new LoginPage(driver);
        //enter username and pass and click submit button
        loginPage.fullLoginProcess(standardUser, password);

        //act
        //initialize main page
        MainPage mainPage = new MainPage(driver);
        // Flow a: Login -> Add 2 items to cart -> Validate cart has 2 items
        mainPage.addToCart(BACKPACKITEMID);
        mainPage.addToCart(BIKELIGHTITEMID);

        // initialize cart page
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        //navigate to cart page
        mainPage.navigateToCartPage(shopCartPageButton);
        System.out.println(cartPage.getCartItemsCount());

        //assert
        assert cartPage.getCartItemsCount() == 2;
        driver.quit();

    }

    @Test
    public void testFlowB() {
        //arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\POM\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com");

        //initialize login page
        LoginPage loginPage = new LoginPage(driver);
        //enter username and pass and click submit button
        loginPage.fullLoginProcess(standardUser, password);

        //initialize main page
        MainPage mainPage = new MainPage(driver);

        //act
        // Flow a: Login -> Add 3 items to cart -> Validate cart has 2 items
        mainPage.addToCart(BACKPACKITEMID);
        mainPage.addToCart(BIKELIGHTITEMID);
        mainPage.addToCart(TSHIRTITEMID);

        // initialize cart page
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        //navigate to cart page
        mainPage.navigateToCartPage(shopCartPageButton);
        cartPage.removeItem(BIKELIGHTREMOVEITEMID);

        //assert
        assert cartPage.getCartItemsCount() == 2;
        driver.quit();

    }

    @Test
    public void extraFlowHeader() {
        //arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\POM\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com");

        //initialize login page
        LoginPage loginPage = new LoginPage(driver);
        //enter username and pass and click submit button
        loginPage.fullLoginProcess(standardUser, password);

        //act
        Header header = new Header(driver);
        header.clickHeaderCartIcon();
        header.clickHeaderLogo();

        //assert
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.equals("https://www.saucedemo.com/cart.html");

        driver.quit();
    }

    @Test
    public void extraFlowSideMenu() {
        //arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\POM\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com");

        //initialize login page
        LoginPage loginPage = new LoginPage(driver);
        //enter username and pass and click submit button
        loginPage.fullLoginProcess(standardUser, password);

        //act
        SideMenu sideMenu = new SideMenu(driver);
        sideMenu.clickSideMenuButton();
        sideMenu.clickAboutLink();

        String currentUrl = driver.getCurrentUrl();
        //assert
        assert currentUrl.equals("https://saucelabs.com/");

        driver.quit();
    }

    @Test
    public void extraFlowFooter() {
        //arrange
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\POM\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // Navigate to the login page
        driver.get("https://www.saucedemo.com");

        //initialize login page
        LoginPage loginPage = new LoginPage(driver);
        //enter username and pass and click submit button
        loginPage.fullLoginProcess(standardUser, password);

        Footer footer = new Footer(driver);
        //act
        footer.clickLinkedInIcon();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        String currentUrl = driver.getCurrentUrl();
        //assert
        assert currentUrl.equals("https://www.linkedin.com/company/sauce-labs/");

        driver.quit();
    }
}
