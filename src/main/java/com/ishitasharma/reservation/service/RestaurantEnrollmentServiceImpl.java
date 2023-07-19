package com.ishitasharma.reservation.service;

import com.ishitasharma.reservation.mapper.RestaurantMapper;
import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.entity.Restaurant;
import com.ishitasharma.reservation.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantEnrollmentServiceImpl implements RestaurantEnrollmentService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantEnrollmentServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public RestaurantResponse enrollNewRestaurant(CreateRestaurantRequest createRestaurantRequest) {
        Restaurant restaurant = restaurantMapper.map(createRestaurantRequest);
        return restaurantMapper.map(restaurantRepository.save(restaurant));
    }
}
