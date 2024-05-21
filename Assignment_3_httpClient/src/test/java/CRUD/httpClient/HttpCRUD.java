package CRUD.httpClient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
class HttpCRUD {
    static HttpClient httpClient;

    @BeforeAll
    public static void setHttpClient() {
        httpClient = HttpClient.newHttpClient();
    }

    @Test
    public void getUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://reqres.in/api/users?page=2"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());

        if (response.statusCode() == 200) {
            System.out.println("\"Successful\"");
        } else {
            System.out.println("Request failed with status code: " + response.statusCode());
        }

        //to print the body of the response obtained
        String responseBody = response.body().toString();
        System.out.println("Response body is: \n" + responseBody);
        System.out.println("----------------------------------------------------------------------------------\n");
    }

    @Test
    public void createUser() throws IOException, InterruptedException {

        String jsonBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://reqres.in/api/users"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(201, response.statusCode());

        if (response.statusCode() == 201) {
            System.out.println("Post request successful");
        } else {
            System.out.println("Request failed with status code: " + response.statusCode());
        }

        // Print the body of the response
        String responseBody = response.body();
        System.out.println("Response body is: \n" + responseBody);
        System.out.println("----------------------------------------------------------------------------------\n");
    }

    @Test
    public void updateUser() throws IOException, InterruptedException {
        // JSON body for the PUT request
        String jsonBody = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());

        if (response.statusCode() == 200) {
            System.out.println("PUT request successful");
        } else {
            System.out.println("PUT request failed with status code: " + response.statusCode());
        }

        // Print the body of the response
        String responseBody = response.body();
        System.out.println("PUT Response body is: \n" + responseBody);
        System.out.println("----------------------------------------------------------------------------------\n");
    }

    @Test
    public void deleteUser() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(204, response.statusCode());

        if (response.statusCode() == 204) {
            System.out.println("DELETE request successful");
        } else {
            System.out.println("DELETE request failed with status code: " + response.statusCode());
        }

        // Print the body of the response (should be empty)
        String responseBody = response.body();
        System.out.println("DELETE Response body is: \n" + responseBody);
        System.out.println("-----------------------------------------------------------------------------------");
    }
}