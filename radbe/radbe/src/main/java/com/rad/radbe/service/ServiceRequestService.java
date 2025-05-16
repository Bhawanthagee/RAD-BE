package com.rad.radbe.service;

import com.rad.radbe.entity.ServiceReqEntity;
import com.rad.radbe.entity.ServiceRequestEntity;
import com.rad.radbe.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {
    @Autowired
    private ServiceRequestRepository repository;

    public ServiceRequestEntity save(ServiceRequestEntity request) {
        request.setStatus("Pending");
        return repository.save(request);
    }
    public List<ServiceReqEntity>getAll(){
        return repository.getAllReq();
    }
}
