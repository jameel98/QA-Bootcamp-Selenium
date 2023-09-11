package infra;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import logic.enums.Methods;

public class HttpRequest {
    private String method;
    private String url;
    private Map<String, String> headers;
    private String body;

    private HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public static <T> HttpResponse<T> request(Methods methods, String url, Map<String, String> queryParams, String requestBody, Map<String, String> headers, Class<T> clz) {
        HttpResponse<T> responseWrapper = new HttpResponse<>();

        // Set the param of the request if found!
        if (queryParams != null) {
            String queryString = queryParams.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"));
            url += "?" + queryString;
        }

        ClassicHttpRequest request;

        switch (methods) {
            case POST -> {
                // Create an instance of HttpPost with the URL
                request = new HttpPost(url);

                // Set the request body for POST requests
                if (requestBody != null) {
                    StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                    request.setEntity(entity);
                } else {
                    // Set an empty request body
                    request.setEntity(new StringEntity("", ContentType.APPLICATION_JSON));
                }
            }
            case GET -> {
                // Create an instance of HttpGet with the URL
                request = new HttpGet(url);

            }
            case PATCH -> {
                request = new HttpPatch(url);
                // Set the request body for PATCH requests
                if (requestBody != null) {
                    StringEntity entity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                    request.setEntity(entity);
                }
            }
            case DELETE -> {
                request = new HttpDelete(url);
            }
            default -> {
                throw new RuntimeException("Bad Method!");
            }
        }
        // Set the headers of the request
        if (headers != null) {
            for (String key : headers.keySet()) {
                request.setHeader(key, headers.get(key));
            }
        }
        // Create an instance of CloseableHttpClient
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Execute
            execute(httpClient, request, responseWrapper, clz);
        } catch (IOException e) {
            throw new RuntimeException("Error of creating an instance of CloseableHttpClient:\n" + e);
        }
        return responseWrapper;
    }
    public static <T> void execute(CloseableHttpClient httpClient, ClassicHttpRequest httpMethod, HttpResponse<T> responseWrapper, Class<T> clz) {

        // Execute the request and get the response
        try (CloseableHttpResponse response = httpClient.execute(httpMethod)) {
            // Get the response status code
            responseWrapper.setStatus(response.getCode());

            // Get the response entity
            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);
            // Validate Json
            if (!responseBody.isEmpty() && isJson(responseBody)) {
                responseWrapper.setData(new Gson().fromJson(responseBody, clz));
            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // Helper function to check if a string is a valid JSON
    private static boolean isJson(String str) {
        try {
            new JsonParser().parse(str);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

}