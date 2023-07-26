package com.ishitasharma.reservation.model.dto.request;

import com.ishitasharma.reservation.model.dto.common.Cuisine;
import com.ishitasharma.reservation.model.dto.common.RestaurantCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRestaurantRequest {
    private String name;
    private RestaurantCategory category;
    private Cuisine cuisine;
   // private Address address;
}
