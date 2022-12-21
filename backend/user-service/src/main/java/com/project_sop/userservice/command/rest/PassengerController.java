package com.project_sop.userservice.command.rest;


import com.project_sop.userservice.query.rest.PassengerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final CommandGateway commandGateway;

    @Autowired
    public PassengerController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addUser(@RequestBody CreatePassengerRestModel createPassengerRestModel){
        try{
            Object message = rabbitTemplate.convertSendAndReceive("Direct","create", createPassengerRestModel);
            return (String)message;
        }
        catch (Exception e){
            return "CreatePassenger Error";
        }
    }
    @RequestMapping("/getUserByUsername")
    public PassengerRestModel getUserUsername(@RequestBody PassengerRestModel passengerRestModel){
        Object getUser = rabbitTemplate.convertSendAndReceive("Direct", "getbyUsername", passengerRestModel);
        return (PassengerRestModel) getUser;
    }

    @RequestMapping("/login")
    public PassengerRestModel login(@RequestBody PassengerRestModel passengerRestModel){
        Object validation = rabbitTemplate.convertSendAndReceive("Direct", "login", passengerRestModel);
        return (PassengerRestModel) validation;
    }
}
