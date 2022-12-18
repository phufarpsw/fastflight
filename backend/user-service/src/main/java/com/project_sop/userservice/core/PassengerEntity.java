package com.project_sop.userservice.core;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document("Passenger")
public class PassengerEntity implements Serializable {
    @Id
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

    public PassengerEntity() {
    }

    public PassengerEntity(String _id, String username, String password, String firstName, String lastName, String idCardNumber, String email, String tel, String airline, String seat) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCardNumber = idCardNumber;
        this.email = email;
        this.tel = tel;
        this.airline = airline;
        this.seat = seat;
    }
}
