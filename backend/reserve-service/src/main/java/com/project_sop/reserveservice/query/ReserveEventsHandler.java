package com.project_sop.reserveservice.query;

import com.project_sop.reserveservice.core.ReserveEntity;
import com.project_sop.reserveservice.core.data.ReserveRepository;
import com.project_sop.reserveservice.core.event.CreateReserveEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReserveEventsHandler {
    @Autowired
    ReserveRepository repository;
    public ReserveEventsHandler(ReserveRepository repository){
        this.repository = repository;
    }
    @EventHandler
    public void on(CreateReserveEvent createReserveEvent){
        ReserveEntity reserve = new ReserveEntity();
        BeanUtils.copyProperties(createReserveEvent, reserve);
        repository.save(reserve);
    }
}
