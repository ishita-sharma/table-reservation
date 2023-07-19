package com.ishitasharma.reservation.mapper;

import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    Restaurant map(CreateRestaurantRequest createRestaurantRequest);

    RestaurantResponse map(Restaurant restaurant);
}
