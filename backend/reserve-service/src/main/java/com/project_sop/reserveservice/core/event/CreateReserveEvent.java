package com.project_sop.reserveservice.core.event;

import lombok.Data;

@Data
public class CreateReserveEvent {
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
