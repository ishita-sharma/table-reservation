package com.ishitasharma.reservation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfig.class)
public class TableReservationSteps {

    @Autowired
    private CucumberTestInformation cucumberTestInformation;


    @Given("a restaurant name Mini's restaurant, category TAKE_AWAY and cuisine INDIAN")
    public void input_restaurant() {
        String testRestaurant = """
                {
                    "name": "Mini's",
                    "category": "TAKE_AWAY",
                    "cuisine": "INDIAN"
                }
                """;
        cucumberTestInformation.getContextMap().put("INPUT_RESTAURANT", testRestaurant) ;
    }

    @When("a POST request is sent to endpoint restaurants")
    public void create_restaurant() {
        Response response = given().body(cucumberTestInformation.getContextMap().get("INPUT_RESTAURANT")).header("Content-Type", "application/json").when().post("http://localhost:8081/restaurants/");
        cucumberTestInformation.getContextMap().put("RESPONSE", response);
    }

    @Then("a new restaurant is enrolled")
    public void a_user_is_eventually_created() {
        Response response = (Response) cucumberTestInformation.getContextMap().get("RESPONSE");
        response.then().statusCode(HttpStatus.CREATED.value()).body("id", notNullValue());
    }
}