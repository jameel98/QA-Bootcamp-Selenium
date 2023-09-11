package logic.api;

import infra.HttpRequest;
import infra.HttpResponse;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import logic.entities.AllRestaurants;
import logic.entities.CreateNewRestaurant;
import logic.entities.Restaurant;
import logic.enums.Methods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiCalls {

    private static final String BASE_URL = "https://us-central1-testomate-test.cloudfunctions.net/api/";

    // API call to create a new restaurant
    public HttpResponse<Restaurant> createNewRestaurant(int id, String name, String address, double score) throws IOException {
        CreateNewRestaurant newRestaurant = new CreateNewRestaurant(id, name, address, score);
        String requestBody = buildBodyRequest(newRestaurant);
        return HttpRequest.request(Methods.POST,BASE_URL + "restaurant",null, requestBody,getDefaultHeaders(), Restaurant.class);
    }
    private static String buildBodyRequest(CreateNewRestaurant bodyRequestData) {
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(bodyRequestData);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to build body request!");
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    //Deletes a restaurant by id
    public HttpResponse<Restaurant> deleteRestaurant(int id) throws IOException {
        return HttpRequest.request(Methods.DELETE,BASE_URL + "restaurant/" + id,null,null,getDefaultHeaders() ,Restaurant.class);
    }

    // edit restaurant by id
    public HttpResponse<Restaurant> editRestaurant(int id, String name, String address, double score) throws IOException {
        CreateNewRestaurant newRestaurant = new CreateNewRestaurant(id, name, address, score);
        String requestBody = buildBodyRequest(newRestaurant);
        return HttpRequest.request(Methods.PATCH,BASE_URL + "restaurant/" + id,null,requestBody,getDefaultHeaders() , Restaurant.class);

    }

    public HttpResponse<AllRestaurants> getAllRestaurants() throws IOException {
        return HttpRequest.request(Methods.GET,BASE_URL + "restaurants",null, null,getDefaultHeaders(),AllRestaurants.class);
    }


    private Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public HttpResponse<Restaurant> resetRestaurants() throws IOException {
        return HttpRequest.request(Methods.POST,BASE_URL + "reset", getDefaultHeaders(), null ,null, Restaurant.class);
    }

}
