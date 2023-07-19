package com.ishitasharma.reservation.model.dto.response;

import com.ishitasharma.reservation.model.dto.common.Cuisine;
import com.ishitasharma.reservation.model.dto.common.RestaurantCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponse {
    private String id;
    private String name;
    private RestaurantCategory category;
    private Cuisine cuisine;
}
