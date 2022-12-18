package com.project_sop.flightservice.query;

import com.project_sop.flightservice.core.FlightEntity;
import com.project_sop.flightservice.core.data.FlightRepository;
import com.project_sop.flightservice.core.event.CreateFlightEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightEventsHandler {
    @Autowired
    FlightRepository flightRepository;

    public FlightEventsHandler(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    @EventHandler
    public void on(CreateFlightEvent createFlightEvent){
        FlightEntity flight = new FlightEntity();
        BeanUtils.copyProperties(createFlightEvent, flight);
        flightRepository.save(flight);
    }
}
