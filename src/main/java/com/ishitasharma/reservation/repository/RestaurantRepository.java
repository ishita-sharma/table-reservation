package com.ishitasharma.reservation.repository;

import com.ishitasharma.reservation.model.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
