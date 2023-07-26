package com.ishitasharma.reservation;

import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.dto.response.RestaurantTableResponse;
import com.ishitasharma.reservation.model.entity.Restaurant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
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
        Response response = given()
                .body(cucumberTestInformation.getContextMap().get("INPUT_RESTAURANT"))
                .header("Content-Type", "application/json")
                .when()
                .post("http://localhost:8081/restaurants/");
        cucumberTestInformation.getContextMap().put("RESTAURANT_RESPONSE", response);
    }

    @When("a POST request is sent to endpoint tables")
    public void add_tables() {
        String addTablesRequest = """
                [
                    {
                        "tableNumber": "1",
                        "numberOfSeats": 4,
                        "tableType": "NORMAL"
                    },
                    {
                        "tableNumber": "2",
                        "numberOfSeats": 4,
                        "tableType": "NORMAL"
                    },
                     {
                        "tableNumber": "3",
                        "numberOfSeats": 4,
                        "tableType": "NORMAL"
                    }
                ]
                 """;
        RestaurantResponse restaurantResponse = ((Response) cucumberTestInformation.getContextMap().get("RESTAURANT_RESPONSE")).body().as(RestaurantResponse.class);
        Response response = given()
                .body(addTablesRequest)
                .header("Content-Type", "application/json")
                .when()
                .post("http://localhost:8081/restaurants/" + restaurantResponse.getId() + "/tables");
        cucumberTestInformation.getContextMap().put("TABLE_RESPONSE", response);
    }

    @Then("a new restaurant is enrolled")
    public void a_restaurant_is_created() {
        Response response = (Response) cucumberTestInformation.getContextMap().get("RESTAURANT_RESPONSE");
        response.then().statusCode(HttpStatus.CREATED.value()).body("id", notNullValue());
    }

    @Then("tables are successfully added")
    public void tables_are_added_to_a_restaurant() {
        Response response = (Response) cucumberTestInformation.getContextMap().get("TABLE_RESPONSE");
        System.out.println(response.body().prettyPrint());
        response.then()
                .statusCode(HttpStatus.CREATED.value())
                .body("size()", is(3));
        assertThat(((Map) response.jsonPath().getList(".").get(0)).get("numberOfSeats")).isEqualTo(4);

    }
}