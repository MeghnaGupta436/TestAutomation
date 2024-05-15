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
        String updateBody="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        response = given()
                .baseUri("https://reqres.in/")
                .basePath("api/users/2")
                .body(updateBody)
                .when().put()
                .then().extract().response();
    }

    @Then("record updated successfully")
    public void updateResponse(){
        response.then().statusCode(200);
        System.out.println(response.statusLine());
    }
}
