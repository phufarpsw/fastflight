package com.project_sop.reserveservice.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Builder
@Data
public class CreateReserveCommand {
    @TargetAggregateIdentifier
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
