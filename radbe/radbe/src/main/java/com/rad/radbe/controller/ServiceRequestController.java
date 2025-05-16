package com.rad.radbe.controller;

import com.rad.radbe.entity.ServiceReqEntity;
import com.rad.radbe.entity.ServiceRequestEntity;
import com.rad.radbe.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-requests")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from frontend

public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @PostMapping("/submit")
    public String submitRequest(@RequestBody ServiceRequestEntity request) {
        serviceRequestService.save(request);
        return "Saved Successfully";
    }
    @GetMapping("/getAll")
    public List<ServiceReqEntity>getAll(){
       return serviceRequestService.getAll();
    }
}
