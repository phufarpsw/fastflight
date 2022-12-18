package com.project_sop.flightservice.query.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlightRestModel implements Serializable {
    private String _id;
    private String airlineID;
    private String airline;
    private String planeName;
    private String from;
    private String to;
    private String dateFrom;
    private String dateTo;
    private String goFlight;
    private String returnFlight;
    private int amount;
    private int available;
}
