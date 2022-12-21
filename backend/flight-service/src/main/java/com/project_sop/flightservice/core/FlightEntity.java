package com.project_sop.flightservice.core;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("Flight")
public class FlightEntity implements Serializable {
    @Id
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
