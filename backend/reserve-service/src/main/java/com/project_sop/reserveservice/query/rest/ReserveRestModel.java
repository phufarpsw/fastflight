package com.project_sop.reserveservice.query.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReserveRestModel implements Serializable {
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
}
