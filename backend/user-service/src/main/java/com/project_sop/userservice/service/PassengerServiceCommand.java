package com.project_sop.userservice.service;

import com.project_sop.userservice.command.CreatePassengerCommand;
import com.project_sop.userservice.command.UpdatePassengerCommand;
import com.project_sop.userservice.command.rest.CreatePassengerRestModel;
import com.project_sop.userservice.command.rest.UpdatePassengerRestModel;
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
    public String addPassenger(CreatePassengerRestModel createPassengerRestModel) {
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
    @RabbitListener(queues = "UpdatePassenger")
    public String updatePassenger(UpdatePassengerRestModel updatePassengerRestModel) {
        UpdatePassengerCommand command = UpdatePassengerCommand.builder()
                ._id(updatePassengerRestModel.get_id())
                .username(updatePassengerRestModel.getUsername())
                .password(updatePassengerRestModel.getPassword())
                .firstName(updatePassengerRestModel.getFirstName())
                .lastName(updatePassengerRestModel.getLastName())
                .idCardNumber(updatePassengerRestModel.getIdCardNumber())
                .email(updatePassengerRestModel.getEmail())
                .tel(updatePassengerRestModel.getTel())
                .build();
        String result;

        try{
            result = commandGateway.sendAndWait(command);
            result = "Update Successful";
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
