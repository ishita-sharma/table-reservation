package com.ishitasharma.reservation.repository;

import com.ishitasharma.reservation.model.entity.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<RestaurantTable, Integer> {
}
