package com.rad.radbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "service_requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "service_type", nullable = false)
    private String serviceType;

    @ElementCollection
    @CollectionTable(name = "uploaded_documents", joinColumns = @JoinColumn(name = "request_id"))
    @Column(name = "document")
    private List<String> uploadedDocuments;

    @Column(nullable = false)
    private String description;
}
