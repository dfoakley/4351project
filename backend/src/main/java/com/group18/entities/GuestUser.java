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
public class GuestUser {
    @Id
    private Integer id;
    private String name;
    private Integer phoneNumber;
    private String email;
}
