package com.ishitasharma.reservation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {
    private String tableId;
    private Integer numberOfSeats;
    private TableType tableType;

    private enum TableType {
        HIGHTABLE,
        NORMAL,
        BOOTH
    }
}
