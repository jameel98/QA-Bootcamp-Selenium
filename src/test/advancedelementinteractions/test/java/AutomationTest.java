import components.*;
import components.ShippingOptions;
import enums.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static enums.CountryOptions.AFGHANISTAN;
import static enums.CountryOptions.ALBANIA;
import static enums.KeywordOptions.ALL_WORDS_ANY_ORDER;
import static enums.Pattern.ENDING_WITHIN;
import static enums.SellersOptions.INCLUDE;
import static enums.SortByOptions.BEST_MATCH;

public class AutomationTest {

    @Test
    public void testKeyWords(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        KeyWords keyWordsPage = new KeyWords(driver);
        keyWordsPage.setKeywords("gaming Pc");
        keyWordsPage.setKeywordsOptions(ALL_WORDS_ANY_ORDER);
        keyWordsPage.setExcludeWords("mercedes");
        keyWordsPage.setCategory(CategoryOptions.BABY);
        keyWordsPage.setSearchButton();

        driver.quit();
    }
    @Test
    public void testSearchIncluding(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        SearchIncluding searchIncluding = new SearchIncluding(driver);
        searchIncluding.clickCompletedItems();
        searchIncluding.clickTitleAndDescription();
        searchIncluding.clickSoldItems();

        driver.quit();
    }
    @Test
    public void testPrice(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        Price price = new Price(driver);
        price.fillMaxPrice("5000");
        price.fillMinPrice("1000");

        driver.quit();
    }

    @Test
    public void testBuyingFormat(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        BuyingFormat buyingFormat = new BuyingFormat(driver);
        buyingFormat.clickAcceptsOffers();
        buyingFormat.clickAuction();
        buyingFormat.clickBuyItNow();
        buyingFormat.clickClassifiedAds();

        driver.quit();
    }

    @Test
    public void testCondition(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        Condition condition = new Condition(driver);
        condition.clickNewBtn();
        condition.clickUsedBtn();
        condition.clickNotSpecifiedButton();

        driver.quit();
    }

    @Test
    public void testShowResults(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        ShowResults showResults = new ShowResults(driver);
        showResults.clickFreeReturn();
        showResults.clickReturnsAccepted();
        showResults.clickAuthorizedSeller();
        showResults.clickDealsAndSavings();
        showResults.clickSaleItems();
        showResults.clickListedAsLots();
        showResults.clickBenefitsCharity();
        showResults.clickAuthenticityGarantee();
        showResults.selectPattern(ENDING_WITHIN);
        showResults.selectPatternTime(PatternTime.HOUR_3);
        showResults.fillMinBidCount("123");
        showResults.fillMaxBidCount("1234");
        showResults.fillMinQuantity("123");
        showResults.fillMaxQuantity("1234");

        driver.quit();
    }

    @Test
    public void testShippingOptions(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        ShippingOptions shippingOptions = new ShippingOptions(driver);
        shippingOptions.clickFreeShipping();
        shippingOptions.clickLocalPickUp();

        driver.quit();
    }
    @Test
    public void testItemLocation(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        ItemLocation itemLocation = new ItemLocation(driver);
        itemLocation.clickDefault();
        itemLocation.clickUsOnly();
        itemLocation.clickNorthAmerica();
        itemLocation.clickWorldWide();
        itemLocation.selectItemLocation(AFGHANISTAN);
        itemLocation.selectAvailibleCountry(ALBANIA);

        driver.quit();
    }

    @Test
    public void testSeller(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        Sellers sellers = new Sellers(driver);
        sellers.selectSellerOptions(INCLUDE);
        sellers.setSellersText("012345678");
        sellers.clickSellersWithEbay();
        sellers.clickMySavedSellers();

        driver.quit();

    }

    @Test
    public void testSort(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\AdvancedElementInteraction\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        Sort sort = new Sort(driver);
        sort.sortBy(BEST_MATCH);
        sort.viewResults(ViewResultOptions.GALLERY_VIEW);
        sort.resultsPerPage(PerPageOptions.PER_PAGE_60);

        sort.setSearchButton();

        driver.quit();
    }
}
