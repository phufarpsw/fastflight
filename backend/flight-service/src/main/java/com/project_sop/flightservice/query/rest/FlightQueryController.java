package com.project_sop.flightservice.query.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/flights")
public class FlightQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<FlightRestModel> getUsers(){
        try{
            Object allFlight = rabbitTemplate.convertSendAndReceive("Direct","getflight", "");
            return ((List<FlightRestModel>) allFlight);
        }
        catch (Exception e){
            return null;
        }
    }

}
