package com.ishitasharma.reservation.model;

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
