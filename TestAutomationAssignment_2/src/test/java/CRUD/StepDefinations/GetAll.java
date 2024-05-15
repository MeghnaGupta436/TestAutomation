package CRUD.StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAll {
    private Response response;

//when get is hit then response is extracted from the provided endpoint
@When("Get request is hit")
public void getAllRequest(){
   response= given().baseUri("https://reqres.in/")//base URI of the endpoint
            .basePath("api/users?page=2")//path of the endpoint
            .when().get()
            .then()
            .extract()
            .response();
    System.out.println(response);
}

//to put validations on the response data
@Then("All users list is shown")
    public void getAllResponse() {
    response.then().statusCode(200);
    response.then().body("data", notNullValue());
    response.then().body("data.id",notNullValue());

}
}
