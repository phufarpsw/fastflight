package com.project_sop.reserveservice.core.data;

import com.project_sop.reserveservice.core.ReserveEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReserveRepository extends MongoRepository<ReserveEntity, String> {
    @Query(value = "{username :  '?0'}")
    public List<ReserveEntity> findByUsername(String username);

    @Query(value = "{username:  '?0', airlineID:  '?1'}")
    public ReserveEntity findOnlyOne(String username, String airlineID);
}
