package com.ishitasharma.reservation.controller;

import com.ishitasharma.reservation.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enroll")
public class RestaurantEnrollmentController {

    @GetMapping("/restaurants")
    public ResponseEntity<String> getEnrolledRestaurants() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restaurant/{name}")
    public String getEnrolledRestaurantByName() {
        return "enrolled restaurant";
    }

    @GetMapping("/restaurant/{id}")
    public String getEnrolledRestaurantById() {
        return "enrolled restaurant";
    }

    @PostMapping("/restaurant/")
    public ResponseEntity<String> enrollRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @PutMapping("/restaurant/{id}")
    public String updateRestaurant(@RequestBody Restaurant restaurant) {
        return "";
    }
}
