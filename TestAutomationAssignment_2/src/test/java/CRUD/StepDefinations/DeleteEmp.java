package CRUD.StepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteEmp {
    private Response response;

    @When("Delete request for deletion")
    public void DelEmployee(){
        response=given()
                .baseUri("https://dummy.restapiexample.com")
                .basePath("v1/delete/2")
                .when().delete()
                .then().extract().response();
    }

    @Then("record deleted successfully")
    public void deleteResponse(){
        response.then().statusCode(200);
    }
}
