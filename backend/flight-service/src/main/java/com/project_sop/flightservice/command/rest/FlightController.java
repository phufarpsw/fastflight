package com.project_sop.flightservice.command.rest;

import com.project_sop.flightservice.query.rest.FlightRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final CommandGateway commandGateway;

    @Autowired
    public FlightController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addUser(@RequestBody CreateFlightRestModel createFlightRestModel){
        try{
            Object message = rabbitTemplate.convertSendAndReceive("Direct","addflight", createFlightRestModel);
            return (String)message;
        }
        catch (Exception e){
            return "CreatePassenger Error";
        }
    }
    @RequestMapping("/getFlightWithTo")
    public List<FlightRestModel> getUserUsername(@RequestBody FlightRestModel flightRestModel){
        Object flight = rabbitTemplate.convertSendAndReceive("Direct", "withto", flightRestModel);
        return (List<FlightRestModel>) flight;
    }
}
