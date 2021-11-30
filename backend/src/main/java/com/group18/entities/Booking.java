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
public class Booking {
    @Id
    private Integer bookingNumber;
    private Integer userNumber;
    private Integer numGuests;
    private String dateTime;
    private String ccInfo;
    private Integer[] tablesBooked;
}
