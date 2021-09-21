package com.group18.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ResTable {
    @Id
    private Integer tableNumber;
    private Integer maxGuests;
    private boolean isReserved;
    private Integer bookingNumber;
}
