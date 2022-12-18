package com.project_sop.userservice.query.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<PassengerRestModel> getUsers(){
        try{
            Object allUser = rabbitTemplate.convertSendAndReceive("Direct","getpassenger", "");
            return ((List<PassengerRestModel>) allUser);
        }
        catch (Exception e){
            return null;
        }
    }
}
