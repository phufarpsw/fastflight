package com.project_sop.userservice.core.data;

import com.project_sop.userservice.core.PassengerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PassengerRepository extends MongoRepository<PassengerEntity, String> {
    @Query(value = "{username: '?0', password :  '?1'}")
    public PassengerEntity findByUsername(String username, String password);

    @Query( "{_id: '?0'}")
    public PassengerEntity findByPassengerId(String id);

    @Query("{username:  '?0'}")
    public PassengerEntity findByUsername(String username);
}
