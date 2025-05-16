package com.rad.radbe.controller;


import com.rad.radbe.entity.RegistrationFormEntity;
import com.rad.radbe.service.RegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
@CrossOrigin(origins = "*")

public class RegistrationFormController {
    @Autowired
    private RegistrationFormService formService;

    @PostMapping("/submit")
    public String submitForm(@RequestBody RegistrationFormEntity form) {
          formService.save(form);
          return "Form Saved Successfully";
     }
}
