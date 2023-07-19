package com.ishitasharma.reservation.controller;

import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.service.RestaurantEnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantEnrollmentController {

    private final RestaurantEnrollmentService restaurantEnrollmentService;

    public RestaurantEnrollmentController(RestaurantEnrollmentService restaurantEnrollmentService) {
        this.restaurantEnrollmentService = restaurantEnrollmentService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getEnrolledRestaurants() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantResponse> enrollRestaurant(@RequestBody CreateRestaurantRequest createRestaurantRequest) {
        RestaurantResponse response = restaurantEnrollmentService.enrollNewRestaurant(createRestaurantRequest);
        return new ResponseEntity<RestaurantResponse>(response, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{name}")
    public String getEnrolledRestaurantByName() {
        return "enrolled restaurant";
    }

    @GetMapping("/restaurant/{id}")
    public String getEnrolledRestaurantById() {
        return "enrolled restaurant";
    }

    @PutMapping("/restaurant/{id}")
    public String updateRestaurant(@RequestBody CreateRestaurantRequest createRestaurantRequest) {
        return "";
    }
}
