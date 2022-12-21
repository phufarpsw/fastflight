package com.project_sop.reserveservice.service;

import com.project_sop.reserveservice.core.ReserveEntity;
import com.project_sop.reserveservice.core.data.ReserveRepository;
import com.project_sop.reserveservice.query.FindByUsername;
import com.project_sop.reserveservice.query.FindOnlyOne;
import com.project_sop.reserveservice.query.FindReserveQuery;
import com.project_sop.reserveservice.query.rest.ReserveRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReserveServiceQuery {

    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    QueryGateway queryGateway;

    public ReserveServiceQuery(ReserveRepository repository){
        this.reserveRepository = repository;
    }
    @RabbitListener(queues = "getReserve")
    public List<ReserveRestModel> retrieveReserve(){
        FindReserveQuery findUserQuery = new FindReserveQuery();
        List<ReserveRestModel> reserve = queryGateway
                .query(findUserQuery, ResponseTypes.multipleInstancesOf(ReserveRestModel.class)).join();
        return reserve;
    }
    @RabbitListener(queues = "getUsernameReserve")
    public List<ReserveRestModel> getReserveByUsername(ReserveRestModel reserveRestModel){
        FindByUsername findByUsername = new FindByUsername(reserveRestModel.getUsername());
        List<ReserveRestModel> reserveRestModels = queryGateway.query(findByUsername, ResponseTypes.multipleInstancesOf(ReserveRestModel.class)).join();
        return reserveRestModels;
    }
    @RabbitListener(queues = "findOnlyOne")
    public ReserveRestModel getPassengerByUsername(ReserveRestModel reserveRestModel) {
        FindOnlyOne findOnlyOne = new FindOnlyOne(reserveRestModel.getUsername(), reserveRestModel.getAirlineID());
        List<ReserveRestModel> passenger = queryGateway.query(findOnlyOne, ResponseTypes.multipleInstancesOf(ReserveRestModel.class)).join();
        System.out.println(passenger.get(0));
        return passenger.get(0);
    }
}
