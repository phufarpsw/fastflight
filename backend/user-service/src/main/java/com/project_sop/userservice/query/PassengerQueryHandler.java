package com.project_sop.userservice.query;

import com.project_sop.userservice.command.rest.CreatePassengerRestModel;
import com.project_sop.userservice.command.rest.UpdatePassengerRestModel;
import com.project_sop.userservice.core.PassengerEntity;
import com.project_sop.userservice.core.data.PassengerRepository;
import com.project_sop.userservice.query.rest.PassengerRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerQueryHandler {
    @Autowired
    private PassengerRepository passengerRepository;
    public PassengerQueryHandler(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @QueryHandler
    List<PassengerRestModel> findUser(FindUserQuery findUserQuery){
        List<PassengerRestModel> users = new ArrayList<>();
        List<PassengerEntity> entity = passengerRepository.findAll();
        for (PassengerEntity e: entity
             ) {
            PassengerRestModel passengerRestModel = new PassengerRestModel();
            BeanUtils.copyProperties(e, passengerRestModel);
            users.add(passengerRestModel);
        }
        return users;
    }

    @QueryHandler
    public PassengerRestModel findByUsername(FindUserByUsername findUserByUsername){
        PassengerRestModel passenger = new PassengerRestModel();
        PassengerEntity entity = passengerRepository.findByUsername(findUserByUsername.getUsername());
        System.out.println(entity);
        if (entity != null){
            BeanUtils.copyProperties(entity,passenger);
        }
        System.out.println(passenger);
        return passenger;
    }

    @QueryHandler
    public UpdatePassengerRestModel updatePassenger(FindPassengerById findPassengerById){
        PassengerEntity entity = passengerRepository.findByPassengerId(findPassengerById.get_id());
        UpdatePassengerRestModel updatePassengerRestModel = new UpdatePassengerRestModel();
        if(entity != null){
            BeanUtils.copyProperties(entity, updatePassengerRestModel);
        }
        return updatePassengerRestModel;

    }

    @QueryHandler
    public PassengerRestModel loginPassenger(LoginPassenger loginPassenger){
        PassengerRestModel passenger = new PassengerRestModel();
        PassengerEntity entity = passengerRepository.findByUsername(loginPassenger.getUsername(), loginPassenger.getPassword());
        if (entity != null){
            BeanUtils.copyProperties(entity,passenger);
        }
        return passenger;
    }

}
