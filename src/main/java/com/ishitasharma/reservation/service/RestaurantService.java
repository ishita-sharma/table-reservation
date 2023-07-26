package com.ishitasharma.reservation.service;

import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.request.CreateRestaurantTableRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.dto.response.RestaurantTableResponse;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse enrollNewRestaurant(CreateRestaurantRequest createRestaurantRequest);
    RestaurantResponse getEnrolledRestaurant(String restaurantId);
    List<RestaurantTableResponse> addNewTables(String id, List<CreateRestaurantTableRequest> tables);
}
