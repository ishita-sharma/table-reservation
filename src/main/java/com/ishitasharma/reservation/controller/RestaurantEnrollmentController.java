package com.ishitasharma.reservation.controller;

import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.request.CreateRestaurantTableRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.dto.response.RestaurantTableResponse;
import com.ishitasharma.reservation.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantEnrollmentController {

    private final RestaurantService restaurantService;

    public RestaurantEnrollmentController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getEnrolledRestaurant(@PathVariable("id") String restaurantId) {
        RestaurantResponse response = restaurantService.getEnrolledRestaurant(restaurantId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RestaurantResponse> enrollRestaurant(@RequestBody CreateRestaurantRequest createRestaurantRequest) {
        RestaurantResponse response = restaurantService.enrollNewRestaurant(createRestaurantRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/tables")
    public ResponseEntity<List<RestaurantTableResponse>> addTables(@PathVariable("id") String id, @RequestBody List<CreateRestaurantTableRequest> createTableRequest) {
        List<RestaurantTableResponse> response = restaurantService.addNewTables(id, createTableRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
