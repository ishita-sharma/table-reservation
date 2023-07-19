package com.ishitasharma.reservation.controller;

import com.ishitasharma.reservation.model.dto.request.Table;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tables")
public class TableReservationController {

    @GetMapping("/restaurant/{id}/tables")
    public String getAllTables(@PathVariable("id") String id) {
        return "list of all tables";
    }

    @PutMapping("/restaurant/{restaurantId}/table")
    public String reserveTable(@RequestBody Table restaurant) {
        return "table reserved";
    }

}
