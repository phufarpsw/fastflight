package com.project_sop.userservice.query;


import com.project_sop.userservice.core.PassengerEntity;
import com.project_sop.userservice.core.data.PassengerRepository;
import com.project_sop.userservice.core.event.CreatePassengerEvent;
import com.project_sop.userservice.core.event.UpdatePassengerEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerEventsHandler {

    @Autowired
    PassengerRepository passengerRepository;

    public PassengerEventsHandler(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @EventHandler
    public void on(CreatePassengerEvent event){
        PassengerEntity passenger = new PassengerEntity();
        BeanUtils.copyProperties(event, passenger);
        passengerRepository.save(passenger);
    }

    @EventHandler
    public void on(UpdatePassengerEvent event){
        PassengerEntity passenger = new PassengerEntity();
        BeanUtils.copyProperties(event, passenger);
        passengerRepository.save(passenger);
    }

}
