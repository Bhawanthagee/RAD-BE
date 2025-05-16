package com.rad.radbe.repository;

import com.rad.radbe.entity.ServiceReqEntity;
import com.rad.radbe.entity.ServiceRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequestEntity, Integer> {

    @Query(value = """
            SELECT * FROM service_requests
            """,nativeQuery = true)
    List<ServiceReqEntity> getAllReq();
}
