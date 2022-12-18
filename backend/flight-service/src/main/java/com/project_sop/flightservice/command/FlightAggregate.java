package com.project_sop.flightservice.command;


import com.project_sop.flightservice.core.event.CreateFlightEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate
public class FlightAggregate {
    private String _id;
    @AggregateIdentifier
    private String key = UUID.randomUUID().toString();
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

    public FlightAggregate() {

    }
    @CommandHandler
    public FlightAggregate(CreateFlightCommand createFlightCommand){
        CreateFlightEvent createFlightEvent = new CreateFlightEvent();
        BeanUtils.copyProperties(createFlightCommand, createFlightEvent);
        AggregateLifecycle.apply(createFlightEvent);
    }
    @EventSourcingHandler
    public void on(CreateFlightEvent createFlightEvent){
        this._id = createFlightEvent.get_id();
        this.airlineID = createFlightEvent.getAirlineID();
        this.airline = createFlightEvent.getAirline();
        this.planeName = createFlightEvent.getPlaneName();
        this.from = createFlightEvent.getFrom();
        this.to = createFlightEvent.getTo();
        this.dateFrom = createFlightEvent.getDateFrom();
        this.dateTo = createFlightEvent.getDateTo();
        this.goFlight = createFlightEvent.getGoFlight();
        this.returnFlight = createFlightEvent.getReturnFlight();
        this.amount = createFlightEvent.getAmount();
        this.available = createFlightEvent.getAvailable();
    }
}
