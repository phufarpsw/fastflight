package com.project_sop.flightservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateFlightCommand {
    @TargetAggregateIdentifier
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
