package com.group18.converter;

import com.group18.dto.UserBean;
import com.group18.entities.User;

public class UserConverter {
    public static UserBean convert(User user) {
        if(user == null) {
            return null;
        } else {
            UserBean bean = new UserBean();
            if(user.getId() != null) {
                bean.setId(user.getId().toString());
            }

            bean.setName((user.getName()));
            if(user.getPhoneNumber() != null) {
                bean.setPhoneNumber((user.getPhoneNumber()).toString());
            }
            bean.setEmail(user.getEmail());
            bean.setUserName(user.getUserName());
            bean.setPassWord(user.getPassWord());
            bean.setMailingAddress(user.getMailingAddress());
            bean.setBillingAddress(user.getBillingAddress());
            if(user.getDinerNumber() != null) {
                bean.setDinerNumber(user.getDinerNumber().toString());
            }
            if(user.getPoints() != null) {
                bean.setPoints(user.getPoints().toString());
            }

            bean.setPreferredPayment(user.getPreferredPayment());
            return bean;
        }
    }

    public static User convert(UserBean bean) {
        User user = new User();
        if(bean.getId() != null) {
            user.setId(Integer.parseInt(bean.getId()));
        }

        bean.setName((bean.getName()));
        if(bean.getPhoneNumber() != null) {
            user.setPhoneNumber(Integer.parseInt(bean.getPhoneNumber()));
        }
        user.setEmail(bean.getEmail());
        user.setUserName(bean.getUserName());
        user.setPassWord(bean.getPassWord());
        user.setMailingAddress(bean.getMailingAddress());
        user.setBillingAddress(bean.getBillingAddress());
        if(bean.getDinerNumber() != null) {
            user.setDinerNumber(Integer.parseInt(bean.getDinerNumber()));
        }
        if(bean.getPoints() != null) {
            user.setPoints(Integer.parseInt(bean.getPoints()));
        }

        user.setPreferredPayment(bean.getPreferredPayment());
        return user;
    }
}
