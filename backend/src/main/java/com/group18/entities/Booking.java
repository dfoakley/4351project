package com.group18.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Booking {
    @Id
    private Integer bookingNumber;
    private Integer userNumber;
    private Integer numGuests;
    private String dateTime;
    private Integer ccNumber;
}
