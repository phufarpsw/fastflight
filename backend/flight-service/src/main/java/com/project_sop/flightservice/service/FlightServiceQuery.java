package com.project_sop.flightservice.service;

import com.project_sop.flightservice.core.data.FlightRepository;
import com.project_sop.flightservice.query.FindByDestinationWithTo;
import com.project_sop.flightservice.query.FindFlightQuery;
import com.project_sop.flightservice.query.rest.FlightRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceQuery {
    @Autowired
    private static FlightRepository flightRepository;

    @Autowired
    QueryGateway queryGateway;

    public FlightServiceQuery(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    @RabbitListener(queues = "GetFlight")
    public List<FlightRestModel> retrieveFlights(){
        FindFlightQuery findFlightQuery = new FindFlightQuery();
        List<FlightRestModel> flight = queryGateway
                .query(findFlightQuery, ResponseTypes.multipleInstancesOf(FlightRestModel.class)).join();
        return flight;
    }

    @RabbitListener(queues = "getFlightWithTo")
    public List<FlightRestModel> getFlightWithTo(FlightRestModel flightRestModel){
        FindByDestinationWithTo findByDestinationWithTo = new FindByDestinationWithTo(
                flightRestModel.getFrom(),
                flightRestModel.getTo(),
                flightRestModel.getDateFrom());
        List<FlightRestModel> flight = queryGateway.query(findByDestinationWithTo, ResponseTypes.multipleInstancesOf(FlightRestModel.class)).join();
        return flight;
    }
}
