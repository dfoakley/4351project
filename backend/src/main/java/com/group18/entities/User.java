package com.group18.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private Integer userNumber;
    private String name;
    private Integer phoneNumber;
    private String email;
    private RegisteredUser registeredUser;
}
