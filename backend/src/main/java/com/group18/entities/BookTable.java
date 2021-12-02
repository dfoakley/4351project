package com.group18.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BookTable {
    @Id
    private Integer bookingNumber;
    private Integer tableNumber;
}
