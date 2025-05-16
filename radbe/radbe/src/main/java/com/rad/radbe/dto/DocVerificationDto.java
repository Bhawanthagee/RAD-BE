package com.rad.radbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocVerificationDto {
    private String id;
    private String name;
    private String type;
    private String aiValid;
    private String adminApproved;

}
