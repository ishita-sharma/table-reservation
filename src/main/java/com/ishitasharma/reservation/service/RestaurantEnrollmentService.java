package com.ishitasharma.reservation.service;

import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;

public interface RestaurantEnrollmentService {
    RestaurantResponse enrollNewRestaurant(CreateRestaurantRequest createRestaurantRequest);
}
