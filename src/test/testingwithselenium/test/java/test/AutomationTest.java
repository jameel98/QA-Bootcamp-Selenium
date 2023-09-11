package test;

import infra.DriverManager;
import infra.HttpResponse;
import logic.api.ApiCalls;
import logic.entities.Restaurant;
import logic.pages.RestaurantPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static infra.DriverManager.refreshPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class AutomationTest {
    private HttpResponse<Restaurant> response;
    private static ApiCalls apiCalls;
    private RestaurantPage restaurantPage;
    public static WebDriver driver;

    // default restaurant data to create
    private int restaurantID = 121212;
    private String restaurantName = "Shaloms place";
    private String restaurantAddress = "The street 1";
    private double restaurantScore = 5.5;

    @BeforeAll
    public static void init(){
        driver = DriverManager.getDriver();
        apiCalls = new ApiCalls();
    }
    @BeforeEach
    public void setUp() throws IOException {
        response = apiCalls.resetRestaurants();
        assumeTrue(response.getData().isSuccess());
        restaurantPage = new RestaurantPage(driver);
    }

    @AfterAll
    public static void tearDown(){
        DriverManager.closeDriver();
    }

    @Test
    public void testCreateRestaurant() {
        //arrange
        restaurantPage.createNewRestaurant(restaurantID, restaurantName, restaurantAddress, restaurantScore);

        //act
        String alertMsg = restaurantPage.getAlertPopUp().getAlertMsg();
        restaurantPage.getAlertPopUp().clickOnConfirmAlertBtn();

        //assert
        assertEquals(200, response.getStatus());
        assertTrue(response.getData().isSuccess());
        assertEquals("Created!", alertMsg);

    }

    @Test
    public void testEditRestaurant() throws IOException {
        //arrange
        response = apiCalls.createNewRestaurant(restaurantID,restaurantName,restaurantAddress,restaurantScore);

        assertEquals(201,response.getStatus());
        assertTrue(response.getData().isSuccess());

        refreshPage();

        //act
        restaurantName = "pop";
        restaurantAddress = "Google";
        response =  apiCalls.editRestaurant(restaurantID, restaurantName, restaurantAddress, restaurantScore);

        assertEquals(200, response.getStatus());
        assertTrue(response.getData().isSuccess());

        refreshPage();

        boolean isExist = restaurantPage.findRestaurantInPage(restaurantID,restaurantName,restaurantAddress,restaurantScore);
        assertTrue(isExist);
    }
    @Test
    public void testEditInvalidRestaurant() throws IOException {
        //arrange
        response = apiCalls.createNewRestaurant(restaurantID,restaurantName,restaurantAddress,restaurantScore);

        assertEquals(201,response.getStatus());
        assertTrue(response.getData().isSuccess());

        refreshPage();

        //act
        restaurantName = "pop";
        restaurantAddress = "Google";
        restaurantID = restaurantID + 10000;
        response =  apiCalls.editRestaurant(restaurantID, restaurantName, restaurantAddress, restaurantScore);

        //assert
        assertEquals(404, response.getStatus());
        assertFalse(response.getData().isSuccess());

        refreshPage();

        assertThrows(TimeoutException.class, () -> {
            restaurantPage.findRestaurantInPage(restaurantID, restaurantName, restaurantAddress, restaurantScore);
        });
    }

    @Test
    public void testDeleteRestaurant() throws IOException {
        //arrange
        response = apiCalls.createNewRestaurant(restaurantID, restaurantName, restaurantAddress, restaurantScore);
        assertEquals(201, response.getStatus());
        assertTrue(response.getData().isSuccess());

        refreshPage();

        //act
        restaurantPage.deleteRestaurant(restaurantID);
        String alertMessage = restaurantPage.getAlertPopUp().getAlertMsg();
        restaurantPage.getAlertPopUp().clickOnConfirmAlertBtn();

        //assert
        assertEquals("Deleted!", alertMessage);

    }

    @Test
    public void testDeleteUnExistedRestaurant() throws IOException {

        //arrange
        response = apiCalls.createNewRestaurant(restaurantID, restaurantName, restaurantAddress, restaurantScore);
        assertEquals(201, response.getStatus());
        assertTrue(response.getData().isSuccess());

        refreshPage();
        restaurantID = restaurantID + 10000;

        //assert
        assertThrows(TimeoutException.class,()->{
            restaurantPage.deleteRestaurant(restaurantID);
        });
    }

}
