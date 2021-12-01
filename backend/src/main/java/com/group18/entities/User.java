package com.group18.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private String userName;
    private String passWord;
    private String mailingAddress;
    private String billingAddress;
    private Integer dinerNumber;
    private Integer points;
    private String preferredPayment;
}
