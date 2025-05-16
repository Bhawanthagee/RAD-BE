package com.rad.radbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registrations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "name_with_initial", nullable = false)
    private String nameWithInitial;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "mobile", nullable = false, length = 10)
    private String mobile;

    @Column(name = "dob", nullable = false)
    private String dob; // Can be changed to LocalDate if needed

    @Column(name = "nic_number", nullable = false)
    private String nicNumber;
}
