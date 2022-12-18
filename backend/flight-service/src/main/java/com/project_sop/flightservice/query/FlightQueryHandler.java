package com.project_sop.flightservice.query;

import com.project_sop.flightservice.core.FlightEntity;
import com.project_sop.flightservice.core.data.FlightRepository;
import com.project_sop.flightservice.query.rest.FlightRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightQueryHandler {
    @Autowired
    private FlightRepository flightRepository;
    public FlightQueryHandler(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @QueryHandler
    List<FlightRestModel> findUser(FindFlightQuery findFlightQuery){
        List<FlightRestModel> flight = new ArrayList<>();
        List<FlightEntity> entity = flightRepository.findAll();
        for (FlightEntity e: entity
        ) {
            FlightRestModel flightRestModel = new FlightRestModel();
            BeanUtils.copyProperties(e, flightRestModel);
            flight.add(flightRestModel);
        }
        return flight;
    }

    @QueryHandler
    public List<FlightRestModel> findDestination(FindByDestinationWithTo findByDestinationWithTo){
        List<FlightRestModel> flight = new ArrayList<>();
        List<FlightEntity> entity = flightRepository
                .findByDestinationWithTo(findByDestinationWithTo.getFrom(),
                        findByDestinationWithTo.getTo(),
                        findByDestinationWithTo.getDateFrom(),
                        findByDestinationWithTo.getDateTo());
        if (entity != null){
            for(FlightEntity e: entity){
                FlightRestModel flightRestModel = new FlightRestModel();
                BeanUtils.copyProperties(e, flightRestModel);
                flight.add(flightRestModel);
            }
        }
        System.out.println(flight);
        return flight;
    }

}
