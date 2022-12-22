package com.project_sop.userservice.command.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePassengerRestModel implements Serializable {
    private String _id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String idCardNumber;
    private String email;
    private String tel;
}
