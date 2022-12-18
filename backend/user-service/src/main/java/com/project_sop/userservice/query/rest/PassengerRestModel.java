package com.project_sop.userservice.query.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassengerRestModel implements Serializable {
    private String _id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String idCardNumber;
    private String email;
    private String tel;
    private String airline;
    private String seat;
}
