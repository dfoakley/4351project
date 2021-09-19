package com.group18.entities;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class RegisteredUser {
    private String userName;
    private String passWord;
    private String mailingAddress;
    private String billingAddress;
    private Integer dinerNumber;
    private Integer points;
    private String preferredPayment;
}
