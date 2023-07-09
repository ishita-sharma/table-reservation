package com.ishitasharma.reservation.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Restaurant {
    private String id;
    private String name;
    private Address address;
    private List<Table> tables;
}
