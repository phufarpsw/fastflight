package com.project_sop.userservice.command;


import com.project_sop.userservice.core.event.CreatePassengerEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate
public class PassengerAggregate {
    private String _id;
    @AggregateIdentifier
    private String key = UUID.randomUUID().toString();
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String idCardNumber;
    private String email;
    private String tel;
    private String airline;
    private String seat;

    public PassengerAggregate(){

    }

    @CommandHandler
    public PassengerAggregate(CreatePassengerCommand command){
        if(command.getIdCardNumber().length() != 13){
            throw new IllegalArgumentException("Please input your idCardNumber");
        }

        CreatePassengerEvent createPassengerEvent = new CreatePassengerEvent();
        BeanUtils.copyProperties(command, createPassengerEvent);
        AggregateLifecycle.apply(createPassengerEvent);
    }

    @EventSourcingHandler
    public void on(CreatePassengerEvent createPassengerEvent){
        this._id = createPassengerEvent.get_id();
        this.username = createPassengerEvent.getUsername();
        this.password = createPassengerEvent.getPassword();
        this.firstName = createPassengerEvent.getFirstName();
        this.lastName = createPassengerEvent.getLastName();
        this.idCardNumber = createPassengerEvent.getIdCardNumber();
        this.email = createPassengerEvent.getEmail();
        this.tel = createPassengerEvent.getTel();
        this.airline = createPassengerEvent.getAirline();
        this.seat = createPassengerEvent.getSeat();
    }
}
