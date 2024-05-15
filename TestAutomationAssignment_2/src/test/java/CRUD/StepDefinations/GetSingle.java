package CRUD.StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetSingle {
    private Response response;

//to get the single employee details using get request
    @When("Get request for single user")
    public void getSingleRequest(){
        response= given().baseUri("https://reqres.in/")
                .basePath("api/users/2")
                .when().get()
                .then()
                .extract()
                .response();
    }
    //to validate the response of request
    @Then("Single user data is shown")
    public void getSingleResponse(){
         response.then().statusCode(200);
        //body should contain some data , should not be null
         response.then().body("data",notNullValue());
         response.then().body("data.id",equalTo(2));
         response.then().body("data.first_name",equalTo("Janet"));

    }
}
