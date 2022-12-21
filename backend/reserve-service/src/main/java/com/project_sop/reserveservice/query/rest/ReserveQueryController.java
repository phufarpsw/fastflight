package com.project_sop.reserveservice.query.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<ReserveRestModel>getReserves(){
        try{
            Object allReserve = rabbitTemplate.convertSendAndReceive("Direct","getreserve", "");
            return ((List<ReserveRestModel>) allReserve);
        }
        catch (Exception e){
            return null;
        }
    }
}
