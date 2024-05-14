package CRUD.StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UpdateEmp {

    private Response response;

    @When("Put request for update")
    public void PutUpdateEmp() {
        response = given()
                .baseUri("https://dummy.restapiexample.com/")
                .basePath("api/v1/update/21")
                .when().put()
                .then().extract().response();
    }

    @Then("record updated successfully")
    public void updateResponse(){
        response.then().statusCode(200);
    }
}
