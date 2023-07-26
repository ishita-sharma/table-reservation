package com.ishitasharma.reservation.model.dto.response;

import com.ishitasharma.reservation.model.dto.common.TableType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableResponse {
    private String id;
    private String tableNumber;
    private Integer numberOfSeats;
    private TableType tableType;
}
