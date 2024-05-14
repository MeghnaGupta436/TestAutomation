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
@When("^Get request is hit$")
public void getAllRequest(){
   response= given().baseUri("https://dummy.restapiexample.com")//base URI of the endpoint
            .basePath("/api/v1/employees")//path of the endpoint
            .when().get()
            .then()
            .extract()
            .response();
    System.out.println(response);
}

//to put validations on the response data
@Then("^All employees data is shown$")
    public void getAllResponse() {
    response.then().statusCode(200);
    response.then().body("data", notNullValue());
    response.then().body("data.employee_name", isA(ArrayList.class));
    response.then().body("employee_salary",isA(ArrayList.class));
    response.then().body("employee_age",isA(ArrayList.class));
    response.then().body("profile_image",startsWith("https://example.com/images/"));
}
}
