package com.ishitasharma.reservation.model.dto.request;

import com.ishitasharma.reservation.model.dto.common.TableType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRestaurantTableRequest {
    private String tableNumber;
    private Integer numberOfSeats;
    private TableType tableType;
}
