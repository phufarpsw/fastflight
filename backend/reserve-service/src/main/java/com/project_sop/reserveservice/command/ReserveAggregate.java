package com.project_sop.reserveservice.command;

import com.project_sop.reserveservice.core.event.CreateReserveEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;
@Aggregate
public class ReserveAggregate {
    private String _id;
    @AggregateIdentifier
    private String key = UUID.randomUUID().toString();
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

    public ReserveAggregate() {
    }

    @CommandHandler
    public ReserveAggregate(CreateReserveCommand createReserveCommand){
        CreateReserveEvent createReserveEvent= new CreateReserveEvent();
        BeanUtils.copyProperties(createReserveCommand, createReserveEvent);
        AggregateLifecycle.apply(createReserveEvent);
    }
    @EventSourcingHandler
    public void on(CreateReserveEvent createReserveEvent){
        this._id = createReserveEvent.get_id();
        this.username = createReserveEvent.getUsername();
        this.fullName = createReserveEvent.getFullName();
        this.from = createReserveEvent.getFrom();
        this.to = createReserveEvent.getTo();
        this.airline = createReserveEvent.getAirline();
        this.airlineID = createReserveEvent.getAirlineID();
        this.planeName = createReserveEvent.getPlaneName();
        this.goFlight = createReserveEvent.getGoFlight();
        this.returnFlight = createReserveEvent.getReturnFlight();
        this.seat = createReserveEvent.getSeat();
        this.price = createReserveEvent.getPrice();
    }
}
