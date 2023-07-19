package com.ishitasharma.reservation.model.entity;

import com.ishitasharma.reservation.model.dto.common.Cuisine;
import com.ishitasharma.reservation.model.dto.common.RestaurantCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "RESTAURANT")
@EqualsAndHashCode(callSuper = true)
public class Restaurant extends BaseEntity {
    @Id
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private RestaurantCategory category;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
}
