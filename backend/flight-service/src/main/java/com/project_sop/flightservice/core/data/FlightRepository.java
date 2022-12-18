package com.project_sop.flightservice.core.data;

import com.project_sop.flightservice.core.FlightEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlightRepository extends MongoRepository<FlightEntity, String> {

    @Query(value = "{from : '?0', to : '?1', dateFrom : '?2', dateTo: '?3'}")
    public List<FlightEntity> findByDestinationWithTo(String from, String to, String dateFrom, String dateTo);
}
