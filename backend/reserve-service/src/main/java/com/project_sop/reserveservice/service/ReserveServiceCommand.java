package com.project_sop.reserveservice.service;

import com.project_sop.reserveservice.command.CreateReserveCommand;
import com.project_sop.reserveservice.command.rest.CreateReserveRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReserveServiceCommand {
    private final CommandGateway commandGateway;

    @Autowired
    public ReserveServiceCommand(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "createReserve")
    public String addReserve(CreateReserveRestModel createReserveRestModel){
        CreateReserveCommand command = CreateReserveCommand.builder()
                ._id(UUID.randomUUID().toString())
                .username(createReserveRestModel.getUsername())
                .fullName(createReserveRestModel.getFullName())
                .from(createReserveRestModel.getFrom())
                .to(createReserveRestModel.getTo())
                .airline(createReserveRestModel.getAirline())
                .airlineID(createReserveRestModel.getAirlineID())
                .planeName(createReserveRestModel.getPlaneName())
                .goFlight(createReserveRestModel.getGoFlight())
                .returnFlight(createReserveRestModel.getReturnFlight())
                .seat(createReserveRestModel.getSeat())
                .price(createReserveRestModel.getPrice())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        System.out.println(result);
        return result;
    }
}
