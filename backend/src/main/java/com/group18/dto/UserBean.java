package com.group18.dto;

import lombok.Data;

@Data
public class UserBean {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String userName;
    private String passWord;
    private String mailingAddress;
    private String billingAddress;
    private String dinerNumber;
    private String points;
    private String preferredPayment;
}
