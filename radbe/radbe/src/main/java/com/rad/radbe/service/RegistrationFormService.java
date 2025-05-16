package com.rad.radbe.service;

import com.rad.radbe.entity.RegistrationFormEntity;
import com.rad.radbe.repository.RegistrationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationFormService {
    @Autowired
    private RegistrationFormRepository repository;

    public void save(RegistrationFormEntity form){
        repository.save(form);
    }
}