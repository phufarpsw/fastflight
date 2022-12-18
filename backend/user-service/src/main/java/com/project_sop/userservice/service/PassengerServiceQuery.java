package com.project_sop.userservice.service;

import com.project_sop.userservice.command.rest.CreatePassengerRestModel;
import com.project_sop.userservice.core.PassengerEntity;
import com.project_sop.userservice.core.data.PassengerRepository;
import com.project_sop.userservice.query.FindUserByUsername;
import com.project_sop.userservice.query.FindUserQuery;
import com.project_sop.userservice.query.LoginPassenger;
import com.project_sop.userservice.query.rest.PassengerRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceQuery {

    @Autowired
    private static PassengerRepository passengerRepository;

    @Autowired
    QueryGateway queryGateway;

    public PassengerServiceQuery(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @RabbitListener(queues = "GetPassengerById")
    public CreatePassengerRestModel getUserById(CreatePassengerRestModel createPassengerRestModel){
        System.out.println(createPassengerRestModel);
        PassengerEntity passengerEntity = passengerRepository.findByUserid(createPassengerRestModel.get_id());
        CreatePassengerRestModel user = new CreatePassengerRestModel();
        BeanUtils.copyProperties(passengerEntity, user);
        return user;
    }

    @RabbitListener(queues = "GetPassenger")
    public List<PassengerRestModel> retrieveUsers() {
        FindUserQuery findUserQuery = new FindUserQuery();
        List<PassengerRestModel> users = queryGateway
                .query(findUserQuery, ResponseTypes.multipleInstancesOf(PassengerRestModel.class)).join();
        return users;
    }
    @RabbitListener(queues = "GetPassengerByUsername")
    public PassengerRestModel getPassengerByUsername(PassengerRestModel passengerRestModel) {
        FindUserByUsername findUserByUsername = new FindUserByUsername(passengerRestModel.getUsername());
        List<PassengerRestModel> passenger = queryGateway.query(findUserByUsername, ResponseTypes.multipleInstancesOf(PassengerRestModel.class)).join();
        System.out.println(passenger.get(0));
        return passenger.get(0);
    }

    @RabbitListener(queues = "loginPassenger")
    public PassengerRestModel loginPassenger(PassengerRestModel passengerRestModel) {
        LoginPassenger loginPassenger = new LoginPassenger(passengerRestModel.getUsername(), passengerRestModel.getPassword());
        List<PassengerRestModel> passenger = queryGateway.query(loginPassenger, ResponseTypes.multipleInstancesOf(PassengerRestModel.class)).join();
        return passenger.get(0);
    }

}
