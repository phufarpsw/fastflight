package com.project_sop.flightservice.core.event;

import lombok.Data;

@Data
public class CreateFlightEvent {
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
    private int price;
}
