package com.project_sop.flightservice.service;

import com.project_sop.flightservice.command.CreateFlightCommand;
import com.project_sop.flightservice.command.rest.CreateFlightRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightServiceCommand {
    private final CommandGateway commandGateway;

    @Autowired
    public FlightServiceCommand(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "addFlight")
    public String addFlight(CreateFlightRestModel createFlightRestModel){
        CreateFlightCommand command = CreateFlightCommand.builder()
                ._id(UUID.randomUUID().toString())
                .airlineID(createFlightRestModel.getAirlineID())
                .airline(createFlightRestModel.getAirline())
                .planeName(createFlightRestModel.getPlaneName())
                .from(createFlightRestModel.getFrom())
                .to(createFlightRestModel.getTo())
                .dateFrom(createFlightRestModel.getDateFrom())
                .dateTo(createFlightRestModel.getDateTo())
                .goFlight(createFlightRestModel.getGoFlight())
                .returnFlight(createFlightRestModel.getReturnFlight())
                .amount(createFlightRestModel.getAmount())
                .available(createFlightRestModel.getAvailable())
                .price(createFlightRestModel.getPrice())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        System.out.println("ดูสิมันปริ้นอะไร "+result);
        return result;
    }
}
