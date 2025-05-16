package com.rad.radbe.service;

import com.rad.radbe.entity.ServiceRequestEntity;
import com.rad.radbe.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRequestService {
    @Autowired
    private ServiceRequestRepository repository;

    public ServiceRequestEntity save(ServiceRequestEntity request) {
        return repository.save(request);
    }
}
