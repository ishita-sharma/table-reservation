package com.ishitasharma.reservation.model.entity;

import com.ishitasharma.reservation.model.dto.common.TableType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "RESTAURANT_TABLE")
@EqualsAndHashCode(callSuper = true)
public class RestaurantTable extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "table_number")
    private String tableNumber;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private TableType tableType;

    @ManyToOne
    @JoinColumn(name="restaurant_id", referencedColumnName="id")
    private Restaurant restaurant;

    public RestaurantTable setRestaurantAndReturnTable(Restaurant restaurant) {
        this.setRestaurant(restaurant);
        return this;
    }
}
