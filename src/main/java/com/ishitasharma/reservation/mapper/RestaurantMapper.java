package com.ishitasharma.reservation.mapper;

import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.request.CreateRestaurantTableRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.dto.response.RestaurantTableResponse;
import com.ishitasharma.reservation.model.entity.Restaurant;
import com.ishitasharma.reservation.model.entity.RestaurantTable;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    Restaurant map(CreateRestaurantRequest createRestaurantRequest);

    RestaurantResponse map(Restaurant restaurant);

    RestaurantTable map(CreateRestaurantTableRequest createTableRequest);
    RestaurantTableResponse map(RestaurantTable restaurantTable);
}
