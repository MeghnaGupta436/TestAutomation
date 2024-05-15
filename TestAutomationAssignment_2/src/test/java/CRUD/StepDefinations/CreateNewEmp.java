package CRUD.StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateNewEmp {

    private Response response;
    //To create a new employee using post
    @When("^Post request is hit$")
    public void PostCreateEmp(){
        String requestBody ="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        response= given()
                .baseUri("https://reqres.in/")
                .basePath("api/users")
                .body(requestBody)
                .when().post()
                .then().extract().response();
    }

    @Then("^new user is created successfully$")
    public void createResponse(){
        response.then().statusCode(201);
        System.out.println(response.statusLine());

        System.out.println(response);
    }
}
