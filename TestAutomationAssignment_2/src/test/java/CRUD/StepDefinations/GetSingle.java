package CRUD.StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class GetSingle {
    private Response response;

//to get the single employee details using get request
    @When("^Get request for single Employee$")
    public void getSingleRequest(){
        response= given().baseUri("https://dummy.restapiexample.com/")
                .basePath("api/v1/employee")
                .pathParams("data.id","1")
                .when().get()
                .then()
                .extract()
                .response();
    }
    //to validate the response of request
    @Then("^Single employee data is shown$")
    public void getSingleResponse(){
         response.then().statusCode(200);
        //body should contain some data , should not be null
         response.then().body("data",notNullValue());

    }
}
