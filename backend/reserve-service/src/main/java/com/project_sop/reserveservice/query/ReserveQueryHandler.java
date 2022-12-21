package com.project_sop.reserveservice.query;

import com.project_sop.reserveservice.core.ReserveEntity;
import com.project_sop.reserveservice.core.data.ReserveRepository;
import com.project_sop.reserveservice.query.rest.ReserveRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReserveQueryHandler {
    @Autowired
    private ReserveRepository repository;
    public ReserveQueryHandler(ReserveRepository repository){
        this.repository = repository;
    }
    @QueryHandler
    List<ReserveRestModel> findReserves(FindReserveQuery findReserveQuery){
        List<ReserveRestModel> reserve = new ArrayList<>();
        List<ReserveEntity> entity = repository.findAll();
        for(ReserveEntity e: entity){
            ReserveRestModel reserveRestModel = new ReserveRestModel();
            BeanUtils.copyProperties(e,reserveRestModel);
            reserve.add(reserveRestModel);
        }
        return reserve;
    }
    @QueryHandler
    public List<ReserveRestModel> findByUsername(FindByUsername findByUsername){
        List<ReserveRestModel> reserve = new ArrayList<>();
        List<ReserveEntity> entity = repository.findByUsername(findByUsername.getUsername());
        if (entity != null){
            for(ReserveEntity e: entity){
                ReserveRestModel reserveRestModel = new ReserveRestModel();
                BeanUtils.copyProperties(e, reserveRestModel);
                reserve.add(reserveRestModel);
            }
        }
        return reserve;

    }
    @QueryHandler
    public ReserveRestModel findOnlyOne(FindOnlyOne findOnlyOne){
        ReserveRestModel reserve = new ReserveRestModel();
        ReserveEntity entity = repository.findOnlyOne(findOnlyOne.getUsername(), findOnlyOne.getAirlineID());
        System.out.println(entity);
        if (entity != null){
            BeanUtils.copyProperties(entity,reserve);
        }
        System.out.println(reserve);
        return reserve;
    }
}
