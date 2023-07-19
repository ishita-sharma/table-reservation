package com.ishitasharma.reservation.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;
}
