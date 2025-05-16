package com.rad.radbe.repository;

import com.rad.radbe.entity.RegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationFormRepository extends JpaRepository<RegistrationFormEntity, Integer> {

}