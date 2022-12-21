package com.project_sop.reserveservice.command.rest;

import com.project_sop.reserveservice.query.rest.ReserveRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final CommandGateway commandGateway;

    @Autowired
    public ReserveController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addUser(@RequestBody CreateReserveRestModel createReserveRestModel){
        try{
            Object message = rabbitTemplate.convertSendAndReceive("Direct","createreserve", createReserveRestModel);
            return (String)message;
        }
        catch (Exception e){
            return "CreateReserve Error";
        }
    }
    @RequestMapping(value = "/reserveByUsername")
    public List<ReserveRestModel> getReserveByUsername(@RequestBody ReserveRestModel reserveRestModel){
        Object reserve = rabbitTemplate.convertSendAndReceive("Direct", "usernamereserve", reserveRestModel);
        return (List<ReserveRestModel>) reserve;
    }

    @RequestMapping(value = "/reserveByAirlineID")
    public ReserveRestModel getReserveByAirlineWithUsername(@RequestBody ReserveRestModel reserveRestModel){
        Object reserve = rabbitTemplate.convertSendAndReceive("Direct", "onlyone", reserveRestModel);
        return (ReserveRestModel) reserve;
    }

}
