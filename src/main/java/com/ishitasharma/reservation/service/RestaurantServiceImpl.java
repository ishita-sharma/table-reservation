package com.ishitasharma.reservation.service;

import com.ishitasharma.reservation.mapper.RestaurantMapper;
import com.ishitasharma.reservation.model.dto.request.CreateRestaurantRequest;
import com.ishitasharma.reservation.model.dto.request.CreateRestaurantTableRequest;
import com.ishitasharma.reservation.model.dto.response.RestaurantResponse;
import com.ishitasharma.reservation.model.dto.response.RestaurantTableResponse;
import com.ishitasharma.reservation.model.entity.Restaurant;
import com.ishitasharma.reservation.model.entity.RestaurantTable;
import com.ishitasharma.reservation.repository.RestaurantRepository;
import com.ishitasharma.reservation.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, TableRepository tableRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.tableRepository = tableRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public RestaurantResponse enrollNewRestaurant(CreateRestaurantRequest createRestaurantRequest) {
        Restaurant restaurant = restaurantMapper.map(createRestaurantRequest);
        Restaurant restaurantFromDb = restaurantRepository.save(restaurant);
        return restaurantMapper.map(restaurantFromDb);
    }

    @Override
    public RestaurantResponse getEnrolledRestaurant(String restaurantId) {
        return restaurantMapper.map(restaurantRepository.findById(Integer.valueOf(restaurantId)).orElse(null));
    }

    @Override
    public List<RestaurantTableResponse> addNewTables(String id, List<CreateRestaurantTableRequest> createRestaurantTableRequests) {
        Restaurant restaurant = restaurantRepository.findById(Integer.valueOf(id)).orElseThrow();

        List<RestaurantTable> tables = createRestaurantTableRequests.stream()
                .map(restaurantMapper::map)
                .map(restaurantTable -> restaurantTable.setRestaurantAndReturnTable(restaurant))
                .collect(Collectors.toList());
        return StreamSupport.stream(tableRepository.saveAll(tables).spliterator(), false)
                .map(restaurantMapper::map)
                .collect(Collectors.toList());
    }
}
