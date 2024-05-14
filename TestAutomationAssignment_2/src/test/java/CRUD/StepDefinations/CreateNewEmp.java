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
        response= given()
                .baseUri("https://dummy.restapiexample.com/")
                .basePath("api/v1/create")
                .pathParams("body","{\n" +
                        "    \"data\": {\n" +
                        "        \"name\": \"test\",\n" +
                        "        \"salary\": \"123\",\n" +
                        "        \"age\": \"23\",\n" +
                        "        \"id\": 25\n" +
                        "    }\n" +
                        "}")
                .when().post()
                .then().extract().response();
    }

    @Then("^new employee is created successfully$")
    public void createResponse(){
        response.then().statusCode(200);

        System.out.println(response);
    }
}
