package com.ishitasharma.reservation.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public class Address {
    private String careOf;
    private String street;
    private String additional;
    private String zipCode;
    private String city;
    private String countryCode;
}
