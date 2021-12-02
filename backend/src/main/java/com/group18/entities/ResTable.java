package com.group18.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ResTable {
    @Id
    private Integer tableNumber;
    private Integer maxGuests;
    private boolean isReserved;
    private Integer bookingNumber;
}
