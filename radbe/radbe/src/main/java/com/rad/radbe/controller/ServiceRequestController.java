package com.rad.radbe.controller;

import com.rad.radbe.entity.ServiceRequestEntity;
import com.rad.radbe.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @PostMapping("/submit")
    public String submitRequest(@RequestBody ServiceRequestEntity request) {
        serviceRequestService.save(request);
        return "Saved Successfully";
    }
}
