package com.project_sop.userservice.service;

import com.project_sop.userservice.command.CreatePassengerCommand;
import com.project_sop.userservice.command.rest.CreatePassengerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PassengerServiceCommand {

    private final CommandGateway commandGateway;

    @Autowired
    public PassengerServiceCommand(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }



    @RabbitListener(queues = "createPassenger")
    public String addUsers(CreatePassengerRestModel createPassengerRestModel) {
        CreatePassengerCommand command = CreatePassengerCommand.builder()
                ._id(UUID.randomUUID().toString())
                .username(createPassengerRestModel.getUsername())
                .password(createPassengerRestModel.getPassword())
                .firstName(createPassengerRestModel.getFirstName())
                .lastName(createPassengerRestModel.getLastName())
                .idCardNumber(createPassengerRestModel.getIdCardNumber())
                .email(createPassengerRestModel.getEmail())
                .tel(createPassengerRestModel.getTel())
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
