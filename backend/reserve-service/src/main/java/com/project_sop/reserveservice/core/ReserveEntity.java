package com.project_sop.reserveservice.core;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Reserve")
public class ReserveEntity implements Serializable {
    @Id
    private String _id;
    private String username;
    private String fullName;
    private String from;
    private String to;
    private String airline;
    private String airlineID;
    private String planeName;
    private String goFlight;
    private String returnFlight;
    private String seat;
    private String price;

    public ReserveEntity() {
    }

    public ReserveEntity(String _id, String username, String fullName, String from, String to, String airline, String airlineID, String planeName, String goFlight, String returnFlight, String seat, String price) {
        this._id = _id;
        this.username = username;
        this.fullName = fullName;
        this.from = from;
        this.to = to;
        this.airline = airline;
        this.airlineID = airlineID;
        this.planeName = planeName;
        this.goFlight = goFlight;
        this.returnFlight = returnFlight;
        this.seat = seat;
        this.price = price;
    }
}
