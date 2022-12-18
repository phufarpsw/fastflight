package com.project_sop.userservice.core.event;

import lombok.Data;

@Data
public class CreatePassengerEvent {
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
